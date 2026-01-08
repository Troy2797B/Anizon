package servicesTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import passion.troy.anizone.services.StreamingApiService;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import java.net.URI;
import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StreamingApiServiceTest{

    @Mock
    private WebClient mockWebClient;

    @Mock
    private WebClient.RequestHeadersUriSpec mockRequestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec mockRequestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec mockResponseSpec;

    @InjectMocks
    private StreamingApiService streamingApiService;

    @Test
    public void getShowsByStreamingPlatformTest(){
        // Arrange: Simulate the WebClient call chain
        // Act: Call the method
        // Assert: Verify the result
        when(mockWebClient.get()).thenReturn(mockRequestHeadersUriSpec);
        when(mockRequestHeadersUriSpec.uri(Mockito.<Function<UriBuilder, URI>>any())).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(String.class)).thenReturn(Mono.just("Mocked streaming platform"));

        Mono<String> result = streamingApiService.getShowsByStreamingPlatform("Netflix");

        StepVerifier.create(result)
                .expectNext("Mocked streaming platform")
                .verifyComplete();
    }
}
