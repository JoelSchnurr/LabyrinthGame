package MazeGameClientApplication.api;

import MazeGameClientApplication.invoker.ApiClient;

import java.math.BigDecimal;
import MazeGameClientApplication.model.GameDto;
import MazeGameClientApplication.model.GameInputDto;
import MazeGameClientApplication.model.MoveDto;
import MazeGameClientApplication.model.MoveInputDto;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient.ResponseSpec;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-29T21:25:06.742188700+02:00[Europe/Berlin]", comments = "Generator version: 7.10.0")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    @Autowired
    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get game status
     * Retrieves the current game status.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec gameGameIdGetRequestCreation(BigDecimal gameId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling gameGameIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get game status
     * Retrieves the current game status.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public GameDto gameGameIdGet(BigDecimal gameId) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdGetRequestCreation(gameId).body(localVarReturnType);
    }

    /**
     * Get game status
     * Retrieves the current game status.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return ResponseEntity&lt;GameDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GameDto> gameGameIdGetWithHttpInfo(BigDecimal gameId) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdGetRequestCreation(gameId).toEntity(localVarReturnType);
    }

    /**
     * Get game status
     * Retrieves the current game status.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec gameGameIdGetWithResponseSpec(BigDecimal gameId) throws RestClientResponseException {
        return gameGameIdGetRequestCreation(gameId);
    }
    /**
     * Get all moves
     * Retrieves the history of moves the player has made in the game.
     * <p><b>200</b> - List of all moves made by the player
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return List&lt;MoveDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec gameGameIdMoveGetRequestCreation(BigDecimal gameId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling gameGameIdMoveGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<List<MoveDto>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/move", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all moves
     * Retrieves the history of moves the player has made in the game.
     * <p><b>200</b> - List of all moves made by the player
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return List&lt;MoveDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<MoveDto> gameGameIdMoveGet(BigDecimal gameId) throws RestClientResponseException {
        ParameterizedTypeReference<List<MoveDto>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdMoveGetRequestCreation(gameId).body(localVarReturnType);
    }

    /**
     * Get all moves
     * Retrieves the history of moves the player has made in the game.
     * <p><b>200</b> - List of all moves made by the player
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return ResponseEntity&lt;List&lt;MoveDto&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<MoveDto>> gameGameIdMoveGetWithHttpInfo(BigDecimal gameId) throws RestClientResponseException {
        ParameterizedTypeReference<List<MoveDto>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdMoveGetRequestCreation(gameId).toEntity(localVarReturnType);
    }

    /**
     * Get all moves
     * Retrieves the history of moves the player has made in the game.
     * <p><b>200</b> - List of all moves made by the player
     * <p><b>404</b> - Game not found
     * @param gameId The gameId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec gameGameIdMoveGetWithResponseSpec(BigDecimal gameId) throws RestClientResponseException {
        return gameGameIdMoveGetRequestCreation(gameId);
    }
    /**
     * Get move
     * Retrieves the move.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Move not found
     * @param gameId The gameId parameter
     * @param moveId The moveId parameter
     * @return MoveDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec gameGameIdMoveMoveIdGetRequestCreation(BigDecimal gameId, BigDecimal moveId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling gameGameIdMoveMoveIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'moveId' is set
        if (moveId == null) {
            throw new RestClientResponseException("Missing the required parameter 'moveId' when calling gameGameIdMoveMoveIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);
        pathParams.put("moveId", moveId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<MoveDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/move/{moveId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get move
     * Retrieves the move.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Move not found
     * @param gameId The gameId parameter
     * @param moveId The moveId parameter
     * @return MoveDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public MoveDto gameGameIdMoveMoveIdGet(BigDecimal gameId, BigDecimal moveId) throws RestClientResponseException {
        ParameterizedTypeReference<MoveDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdMoveMoveIdGetRequestCreation(gameId, moveId).body(localVarReturnType);
    }

    /**
     * Get move
     * Retrieves the move.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Move not found
     * @param gameId The gameId parameter
     * @param moveId The moveId parameter
     * @return ResponseEntity&lt;MoveDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<MoveDto> gameGameIdMoveMoveIdGetWithHttpInfo(BigDecimal gameId, BigDecimal moveId) throws RestClientResponseException {
        ParameterizedTypeReference<MoveDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdMoveMoveIdGetRequestCreation(gameId, moveId).toEntity(localVarReturnType);
    }

    /**
     * Get move
     * Retrieves the move.
     * <p><b>200</b> - Game status retrieved successfully
     * <p><b>404</b> - Move not found
     * @param gameId The gameId parameter
     * @param moveId The moveId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec gameGameIdMoveMoveIdGetWithResponseSpec(BigDecimal gameId, BigDecimal moveId) throws RestClientResponseException {
        return gameGameIdMoveMoveIdGetRequestCreation(gameId, moveId);
    }
    /**
     * Move in the maze
     * Move the player in the given direction.
     * <p><b>200</b> - Move result
     * @param gameId The gameId parameter
     * @param moveInputDto The moveInputDto parameter
     * @return MoveDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec gameGameIdMovePostRequestCreation(BigDecimal gameId, MoveInputDto moveInputDto) throws RestClientResponseException {
        Object postBody = moveInputDto;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling gameGameIdMovePost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'moveInputDto' is set
        if (moveInputDto == null) {
            throw new RestClientResponseException("Missing the required parameter 'moveInputDto' when calling gameGameIdMovePost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<MoveDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/move", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Move in the maze
     * Move the player in the given direction.
     * <p><b>200</b> - Move result
     * @param gameId The gameId parameter
     * @param moveInputDto The moveInputDto parameter
     * @return MoveDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public MoveDto gameGameIdMovePost(BigDecimal gameId, MoveInputDto moveInputDto) throws RestClientResponseException {
        ParameterizedTypeReference<MoveDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdMovePostRequestCreation(gameId, moveInputDto).body(localVarReturnType);
    }

    /**
     * Move in the maze
     * Move the player in the given direction.
     * <p><b>200</b> - Move result
     * @param gameId The gameId parameter
     * @param moveInputDto The moveInputDto parameter
     * @return ResponseEntity&lt;MoveDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<MoveDto> gameGameIdMovePostWithHttpInfo(BigDecimal gameId, MoveInputDto moveInputDto) throws RestClientResponseException {
        ParameterizedTypeReference<MoveDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gameGameIdMovePostRequestCreation(gameId, moveInputDto).toEntity(localVarReturnType);
    }

    /**
     * Move in the maze
     * Move the player in the given direction.
     * <p><b>200</b> - Move result
     * @param gameId The gameId parameter
     * @param moveInputDto The moveInputDto parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec gameGameIdMovePostWithResponseSpec(BigDecimal gameId, MoveInputDto moveInputDto) throws RestClientResponseException {
        return gameGameIdMovePostRequestCreation(gameId, moveInputDto);
    }
    /**
     * Start a new game
     * Creates a new game instance and returns the initial player position.
     * <p><b>201</b> - Game started successfully
     * @param gameInputDto The gameInputDto parameter
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec gamePostRequestCreation(GameInputDto gameInputDto) throws RestClientResponseException {
        Object postBody = gameInputDto;
        // verify the required parameter 'gameInputDto' is set
        if (gameInputDto == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameInputDto' when calling gamePost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Start a new game
     * Creates a new game instance and returns the initial player position.
     * <p><b>201</b> - Game started successfully
     * @param gameInputDto The gameInputDto parameter
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public GameDto gamePost(GameInputDto gameInputDto) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gamePostRequestCreation(gameInputDto).body(localVarReturnType);
    }

    /**
     * Start a new game
     * Creates a new game instance and returns the initial player position.
     * <p><b>201</b> - Game started successfully
     * @param gameInputDto The gameInputDto parameter
     * @return ResponseEntity&lt;GameDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GameDto> gamePostWithHttpInfo(GameInputDto gameInputDto) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return gamePostRequestCreation(gameInputDto).toEntity(localVarReturnType);
    }

    /**
     * Start a new game
     * Creates a new game instance and returns the initial player position.
     * <p><b>201</b> - Game started successfully
     * @param gameInputDto The gameInputDto parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec gamePostWithResponseSpec(GameInputDto gameInputDto) throws RestClientResponseException {
        return gamePostRequestCreation(gameInputDto);
    }
}
