//package servicesTests;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.util.UriBuilder;
//
//import java.net.URI;
//import java.util.function.Function;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ApiTestConfiguration {
//
//    @Mock
//    protected WebClient mockWebClient;
//
//    @Mock
//    protected WebClient.RequestHeadersUriSpec mockRequestHeadersUriSpec;
//
//    @Mock
//    protected WebClient.RequestHeadersSpec mockRequestHeadersSpec;
//
//    @Mock
//    protected WebClient.ResponseSpec mockResponseSpec;
//
//    @BeforeEach
//    void setUpBaseMocks() {
//        MockitoAnnotations.openMocks(this);
//        when(mockWebClient.get()).thenReturn(mockRequestHeadersUriSpec);
//        when(mockRequestHeadersUriSpec.uri(Mockito.<Function<UriBuilder, URI>>any())).thenReturn(mockRequestHeadersSpec);
//        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
//    }
//}
