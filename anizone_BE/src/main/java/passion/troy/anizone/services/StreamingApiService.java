package passion.troy.anizone.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StreamingApiService {
    private final WebClient streamingApiWebClient;

    public StreamingApiService (WebClient streamingApiWebClient) {
        this.streamingApiWebClient = streamingApiWebClient;
    }

    public Mono<String> getShowsByStreamingPlatform(String platformName){
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

    // TODO: make a method to getAllAnimeByPlatformFromStreamingApi(String platformName)
    /* use the GET search shows by filters
        output_language=en
        country=us
        output_language=en
        shows_type=series
        show_original_language=ja
        series_granularity=show
     */


}
