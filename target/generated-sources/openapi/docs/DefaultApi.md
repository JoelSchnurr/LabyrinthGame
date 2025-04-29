# DefaultApi

All URIs are relative to *https://mazegame.rinderle.info*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**gameGameIdGet**](DefaultApi.md#gameGameIdGet) | **GET** /game/{gameId} | Get game status |
| [**gameGameIdMoveGet**](DefaultApi.md#gameGameIdMoveGet) | **GET** /game/{gameId}/move | Get all moves |
| [**gameGameIdMoveMoveIdGet**](DefaultApi.md#gameGameIdMoveMoveIdGet) | **GET** /game/{gameId}/move/{moveId} | Get move |
| [**gameGameIdMovePost**](DefaultApi.md#gameGameIdMovePost) | **POST** /game/{gameId}/move | Move in the maze |
| [**gamePost**](DefaultApi.md#gamePost) | **POST** /game | Start a new game |



## gameGameIdGet

> GameDto gameGameIdGet(gameId)

Get game status

Retrieves the current game status.

### Example

```java
// Import classes:
import MazeGameClientApplication.invoker.ApiClient;
import MazeGameClientApplication.invoker.ApiException;
import MazeGameClientApplication.invoker.Configuration;
import MazeGameClientApplication.invoker.models.*;
import MazeGameClientApplication.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mazegame.rinderle.info");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        BigDecimal gameId = new BigDecimal(78); // BigDecimal | 
        try {
            GameDto result = apiInstance.gameGameIdGet(gameId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#gameGameIdGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **BigDecimal**|  | |

### Return type

[**GameDto**](GameDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Game status retrieved successfully |  -  |
| **404** | Game not found |  -  |


## gameGameIdMoveGet

> List&lt;MoveDto&gt; gameGameIdMoveGet(gameId)

Get all moves

Retrieves the history of moves the player has made in the game.

### Example

```java
// Import classes:
import MazeGameClientApplication.invoker.ApiClient;
import MazeGameClientApplication.invoker.ApiException;
import MazeGameClientApplication.invoker.Configuration;
import MazeGameClientApplication.invoker.models.*;
import MazeGameClientApplication.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mazegame.rinderle.info");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        BigDecimal gameId = new BigDecimal(78); // BigDecimal | 
        try {
            List<MoveDto> result = apiInstance.gameGameIdMoveGet(gameId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#gameGameIdMoveGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **BigDecimal**|  | |

### Return type

[**List&lt;MoveDto&gt;**](MoveDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of all moves made by the player |  -  |
| **404** | Game not found |  -  |


## gameGameIdMoveMoveIdGet

> MoveDto gameGameIdMoveMoveIdGet(gameId, moveId)

Get move

Retrieves the move.

### Example

```java
// Import classes:
import MazeGameClientApplication.invoker.ApiClient;
import MazeGameClientApplication.invoker.ApiException;
import MazeGameClientApplication.invoker.Configuration;
import MazeGameClientApplication.invoker.models.*;
import MazeGameClientApplication.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mazegame.rinderle.info");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        BigDecimal gameId = new BigDecimal(78); // BigDecimal | 
        BigDecimal moveId = new BigDecimal(78); // BigDecimal | 
        try {
            MoveDto result = apiInstance.gameGameIdMoveMoveIdGet(gameId, moveId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#gameGameIdMoveMoveIdGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **BigDecimal**|  | |
| **moveId** | **BigDecimal**|  | |

### Return type

[**MoveDto**](MoveDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Game status retrieved successfully |  -  |
| **404** | Move not found |  -  |


## gameGameIdMovePost

> MoveDto gameGameIdMovePost(gameId, moveInputDto)

Move in the maze

Move the player in the given direction.

### Example

```java
// Import classes:
import MazeGameClientApplication.invoker.ApiClient;
import MazeGameClientApplication.invoker.ApiException;
import MazeGameClientApplication.invoker.Configuration;
import MazeGameClientApplication.invoker.models.*;
import MazeGameClientApplication.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mazegame.rinderle.info");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        BigDecimal gameId = new BigDecimal(78); // BigDecimal | 
        MoveInputDto moveInputDto = new MoveInputDto(); // MoveInputDto | 
        try {
            MoveDto result = apiInstance.gameGameIdMovePost(gameId, moveInputDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#gameGameIdMovePost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **BigDecimal**|  | |
| **moveInputDto** | [**MoveInputDto**](MoveInputDto.md)|  | |

### Return type

[**MoveDto**](MoveDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Move result |  -  |


## gamePost

> GameDto gamePost(gameInputDto)

Start a new game

Creates a new game instance and returns the initial player position.

### Example

```java
// Import classes:
import MazeGameClientApplication.invoker.ApiClient;
import MazeGameClientApplication.invoker.ApiException;
import MazeGameClientApplication.invoker.Configuration;
import MazeGameClientApplication.invoker.models.*;
import MazeGameClientApplication.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mazegame.rinderle.info");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        GameInputDto gameInputDto = new GameInputDto(); // GameInputDto | 
        try {
            GameDto result = apiInstance.gamePost(gameInputDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#gamePost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameInputDto** | [**GameInputDto**](GameInputDto.md)|  | |

### Return type

[**GameDto**](GameDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Game started successfully |  -  |

