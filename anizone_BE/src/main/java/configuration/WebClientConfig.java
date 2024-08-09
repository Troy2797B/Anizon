package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${api.key}")
    private String apikey;
    //We created a custom web client that tells us what type of information we can expect to give and receive, and it also sets the api key using the @Value annotation.
    //We put the real api key in the application-dev.properties and then added that file to the gitignore.
    //this web client is a bean that will be injected into any class we make for making API calls.
    @Bean
    public WebClient animeApiWebClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://myanimelist.p.rapidapi.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("rapidApiKey", apikey)
                .build();
    }
    //We are creating a bean for every API we are using and spring will automatically inject it.
    @Bean
    public WebClient streamingApiWebClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://streaming-availability.p.rapidapi.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("rapidApiKey", apikey)
                .build();
    }
}
