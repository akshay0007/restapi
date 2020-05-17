package com.staxrt.tutorial.reactive.routes;

import com.staxrt.tutorial.reactive.handler.SimpleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * Created by ubuntu on 17/05/20.
 */
@Configuration
public class SimpleRouter {

    @Bean
    RouterFunction<ServerResponse> createRouterFun(SimpleHandler simpleHandler){
        return RouterFunctions
                .route(GET("/function/flux").and(accept(MediaType.APPLICATION_JSON)),simpleHandler::getResponse);
    }

}
