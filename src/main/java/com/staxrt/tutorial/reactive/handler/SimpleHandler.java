package com.staxrt.tutorial.reactive.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by ubuntu on 17/05/20.
 */
@Component
public class SimpleHandler {

    public Mono<ServerResponse> getResponse(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.just("abc", "cde", "efg")
                                .log()
                        , String.class
                );
    }
}
