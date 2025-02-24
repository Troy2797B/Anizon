package passion.troy.anizone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class AnimeApiService {
    //The web client configuration gets injected into this class in order for us to use that custom configuration with any API call we make here.
    //You can inject both of the clients here and use the @Qualifier annotation along with @Autowired so Spring knows what to do, but for more clean code, we will keep it simple and just inject the animeApiClient.
    private final WebClient animeApiClient;
    @Autowired
    public AnimeApiService(@Qualifier("animeApiWebClient") WebClient animeApiClient){
        this.animeApiClient = animeApiClient;
    }

    //This is a method that gets a list of anime Genres from the external API.
    public Mono<String> getAnimeGenres(){
        return animeApiClient.get()
                .uri("/v2/anime/genres")
                .retrieve()
                .bodyToMono(String.class);
    }
    // This returns a list of anime with a maximum of 50. The query param allows for the attributes of the api call to be filled in dynamically.
    public Mono<String> getAnimeByTitleContaining(String title){
        return animeApiClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/anime/search")
                        .queryParam("q", title)
                        .queryParam("n", 50)
                        .build())
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
