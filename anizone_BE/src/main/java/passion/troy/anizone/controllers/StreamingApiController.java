package passion.troy.anizone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import passion.troy.anizone.services.StreamingApiService;
import reactor.core.publisher.Mono;

@RestController
public class StreamingApiController {
    private final StreamingApiService streamingApiService;

    public StreamingApiController (StreamingApiService streamingApiService){
        this.streamingApiService = streamingApiService;
    }
    //just testing to see if it returns all us platform shows
    @GetMapping("/streaming/platforms")
    public Mono<String> getStreamingPlatform(String platformName){
        return streamingApiService.getShowsByStreamingPlatform(platformName);
    }
}
