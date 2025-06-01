package MazeGameClientApplication;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import jakarta.annotation.PostConstruct;

import MazeGameClientApplication.api.DefaultApi;
import MazeGameClientApplication.model.DirectionDto;
import MazeGameClientApplication.model.GameDto;
import MazeGameClientApplication.model.GameInputDto;
import MazeGameClientApplication.model.GameStatusDto;
import MazeGameClientApplication.model.MoveDto;
import MazeGameClientApplication.model.MoveInputDto;
import MazeGameClientApplication.model.MoveStatusDto;
import MazeGameClientApplication.model.PositionDto;

@Component
public class StartupBean {
    private static final Logger log = LoggerFactory.getLogger(StartupBean.class);
    private final DefaultApi defaultApi;

    public StartupBean(DefaultApi defaultApi) {
        this.defaultApi = defaultApi;
    }

    @PostConstruct
    public void init() {
        try {
            // 1) Neues Spiel anlegen
            GameDto game = defaultApi.gamePost(
                    new GameInputDto().groupName("MeinTeamname123")
            );
            BigDecimal gameId = game.getGameId();
            log.info("Spiel gestartet – ID: {}, Start‐Position: {} Status: {}",
                    gameId, game.getPosition(), game.getStatus());

            // 2) Datenstrukturen für DFS: pro Position merken, welche DirectionDto schon probiert wurden
            Map<PositionDto, Set<DirectionDto>> visitedDirections = new HashMap<>();
            //    Stack für erfolgreiche DirectionDto, um später backtracking zu ermöglichen
            Stack<DirectionDto> moveStack = new Stack<>();

            // 3) Solange das Spiel läuft (ONGOING), Maze lösen
            while ((game = defaultApi.gameGameIdGet(gameId)).getStatus() == GameStatusDto.ONGOING) {
                PositionDto currentPos = game.getPosition();

                // a) Hole oder lege an: Set der schon versuchten DirectionDto an dieser Position
                Set<DirectionDto> tried = visitedDirections.computeIfAbsent(
                        currentPos, pos -> new HashSet<>()
                );

                // b) Feste Reihenfolge: LEFT, UP, RIGHT, DOWN
                DirectionDto nextDir = null;
                for (DirectionDto dir : DirectionDto.values()) {
                    if (!tried.contains(dir)) {
                        nextDir = dir;
                        break;
                    }
                }

                if (nextDir != null) {
                    // c) Markiere diese Richtung als ausprobiert
                    tried.add(nextDir);

                    MoveDto moveResult = null;
                    try {
                        // d) Poste den Move ans Backend
                        moveResult = defaultApi.gameGameIdMovePost(
                                gameId, new MoveInputDto().direction(nextDir)
                        );
                    } catch (HttpClientErrorException.BadRequest e) {
                        // BadRequest heißt: ungültiger Move → behandeln wie BLOCKED
                        log.info("Ungültiger Move {} → behandeln wie BLOCKED", nextDir);
                    }

                    if (moveResult != null) {
                        if (moveResult.getMoveStatus() == MoveStatusDto.MOVED) {
                            // Zug erfolgreich
                            log.info("Erfolgreich zu {} bewegt → neue Position={}",
                                    nextDir, moveResult.getPositionAfterMove());
                            moveStack.push(nextDir);
                        } else if (moveResult.getMoveStatus() == MoveStatusDto.BLOCKED) {
                            // Zug gegen Wand → behandeln wie BLOCKED
                            log.info("Move {} → BLOCKED", nextDir);
                        } else if (moveResult.getMoveStatus() == MoveStatusDto.FAILED) {
                            // Falsch: NICHT Spiel beenden, sondern nur BLOCKED
                            log.info("Move {} → FAILED (behandle wie BLOCKED)", nextDir);
                            // → NICHT break, sondern loop weiter
                        }
                    }
                    else {
                        // h) moveResult == null → BadRequest, also behandelt wie BLOCKED
                        // (wurde oben schon geloggt)
                    }

                } else {
                    // i) Alle vier Richtungen an dieser Position probiert → Backtracking
                    if (moveStack.isEmpty()) {
                        log.warn("Keine weiteren Pfade → Maze vermutlich unlösbar.");
                        break;
                    }
                    // j) Letzten erfolgreichen Move zurücknehmen
                    DirectionDto lastDir = moveStack.pop();
                    DirectionDto opposite = oppositeDirection(lastDir);
                    MoveDto back = defaultApi.gameGameIdMovePost(
                            gameId, new MoveInputDto().direction(opposite)
                    );
                    log.info("Backtracking: bewege zurück nach {} → Position={}",
                            opposite, back.getPositionAfterMove());
                }
            }

            // 4) Endstatus prüfen
            if (game.getStatus() == GameStatusDto.SUCCESS) {
                log.info("Maze gelöst! End‐Position {} Status={}",
                        game.getPosition(), game.getStatus());
            } else {
                log.info("Spiel beendet – Status {} End‐Position {}",
                        game.getStatus(), game.getPosition());
            }

        } catch (Exception ex) {
            log.warn("Fehler in der Maze‐Lösung", ex);
        }
    }

    // Berechnet die entgegengesetzte Richtung für Backtracking
    private DirectionDto oppositeDirection(DirectionDto dir) {
        return switch (dir) {
            case LEFT  -> DirectionDto.RIGHT;
            case RIGHT -> DirectionDto.LEFT;
            case UP    -> DirectionDto.DOWN;
            case DOWN  -> DirectionDto.UP;
        };
    }
}
