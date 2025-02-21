package passion.troy.anizone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import passion.troy.anizone.services.AnimeApiService;


//Okay so now we inject the service into this Controller and this is where we use annotations to decide the path variable and what not.
@RestController
public class AnimeApiController {
    private final AnimeApiService animeApiService;

    public AnimeApiController(AnimeApiService animeApiService){
        this.animeApiService = animeApiService;
    }

    @GetMapping("/anime/genres")
    public Mono<String> getAnimeGenres(){
        return animeApiService.getAnimeGenres();
    }
}
