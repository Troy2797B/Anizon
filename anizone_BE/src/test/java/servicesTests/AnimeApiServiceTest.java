package servicesTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import passion.troy.anizone.services.AnimeApiService;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import java.net.URI;
import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnimeApiServiceTest{

    @Mock
    private WebClient mockWebClient;

    @Mock
    private WebClient.RequestHeadersUriSpec mockRequestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec mockRequestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec mockResponseSpec;

    @InjectMocks
    private AnimeApiService animeApiService;

    @Test
    public void testGetAnimeByTitleContaining() {
        // Arrange: Simulate the WebClient call chain
        when(mockWebClient.get()).thenReturn(mockRequestHeadersUriSpec);
        when(mockRequestHeadersUriSpec.uri(Mockito.<Function<UriBuilder, URI>>any()))
                .thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(String.class)).thenReturn(Mono.just("Mocked anime list"));

        // Act: Call the method
        Mono<String> result = animeApiService.getAnimeByTitleContaining("Naruto");

        // Assert: Verify the result
        StepVerifier.create(result)
                .expectNext("Mocked anime list")
                .verifyComplete();
    }

    @Test
    public void testGetAnimeGenres(){
        when(mockWebClient.get()).thenReturn(mockRequestHeadersUriSpec);
        when(mockRequestHeadersUriSpec.uri(anyString()))
                .thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(String.class)).thenReturn(Mono.just("Mocked list of genres"));

        Mono<String> result = animeApiService.getAnimeGenres();

        StepVerifier.create(result)
                .expectNext("Mocked list of genres")
                .verifyComplete();
    }
}
