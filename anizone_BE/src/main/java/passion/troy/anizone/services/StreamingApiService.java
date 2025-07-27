package passion.troy.anizone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StreamingApiService {
    private final WebClient streamingApiWebClient;

    public StreamingApiService (WebClient streamingApiWebClient) {
        this.streamingApiWebClient = streamingApiWebClient;
    }

    public Mono<String> getStreamingPlatform(String platformName){
        return streamingApiWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/shows/search/filters")
                        .queryParam("country", "us")
//                        .queryParam("output_language", "en")
//                        .queryParam("catalogs", platformName)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
