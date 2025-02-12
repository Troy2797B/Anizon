package passion.troy.anizone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;
import passion.troy.anizone.services.ApiService;


//Okay so now we inject the service into this Controller and this is where we use annotations to decide the path variable and what not.
@Controller
public class AnimeApiController {
    @Autowired
    private final ApiService apiService;

    public AnimeApiController(ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping("/anime/genres")
    public Mono<String> getAnimeGenres(){
        return apiService.getSomeDataFromAnimeAPI();
    }
}
