package MazeGameClientApplication;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import MazeGameClientApplication.api.DefaultApi;
import MazeGameClientApplication.model.GameDto;
import MazeGameClientApplication.model.GameInputDto;

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
            GameDto result = defaultApi.gamePost(
                    new GameInputDto().groupName("Joel Schnurr")
            );
            log.info("Spiel gestartet: {}", result);
        } catch (Exception ex) {
            log.warn("Konnte Spiel nicht starten – überspringe StartupBean", ex);
        }
    }
}
