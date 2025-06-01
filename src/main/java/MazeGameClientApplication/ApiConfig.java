package MazeGameClientApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import MazeGameClientApplication.invoker.ApiClient;
import MazeGameClientApplication.api.DefaultApi;

@Configuration
public class ApiConfig {

    @Bean
    public ApiClient apiClient() {
        ApiClient client = new ApiClient();
        client.setBasePath("https://mazegame.rinderle.info");
        return client;
    }

    @Bean
    public DefaultApi defaultApi(ApiClient apiClient) {
        return new DefaultApi(apiClient);
    }
}
