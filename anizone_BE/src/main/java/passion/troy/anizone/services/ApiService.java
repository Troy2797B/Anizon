package passion.troy.anizone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ApiService {
    //The web client gets injected into this class in order for us to use that custom configuration with any API call we make here.
    //You can inject both of the clients here and use the @Qualifier annotation along with @Autowired so Spring knows what to do.
    private final WebClient animeApiClient;
    private final WebClient streamingApiClient;
    @Autowired
    public ApiService(@Qualifier("animeApiWebClient") WebClient animeApiClient,
                      @Qualifier("streamingApiWebClient") WebClient streamingApiClient){
        this.animeApiClient = animeApiClient;
        this.streamingApiClient = streamingApiClient;
    }

    //creating an HTTP Request to externalAnimeApi to get some data

    public Mono<String> getSomeDataFromAnimeAPI(){
        return animeApiClient.get()
                .uri("/v2/anime/genres")
                .retrieve()
                .bodyToMono(String.class);
    }

//    public String getMangaGenresFromAnimeApi(String url) {
//        HttpResponse<String> response;
//        try {
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://myanimelist.p.rapidapi.com/v2/manga/genres"))
//                    .header("x-rapidapi-key", apiKey)
//                    .header("x-rapidapi-host", "myanimelist.p.rapidapi.com")
//                    .method("GET", HttpRequest.BodyPublishers.noBody())
//                    .build();
//            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
//        } catch (Exception e) {
//            return "Error occured: " + e.getMessage();
//        }
//        return response.toString();
//    }
}
