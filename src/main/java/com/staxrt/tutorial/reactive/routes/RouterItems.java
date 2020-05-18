package com.staxrt.tutorial.reactive.routes;

import com.staxrt.tutorial.reactive.handler.ItemHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * Created by ubuntu on 18/05/20.
 */
@Configuration
public class RouterItems {
    @Bean
    RouterFunction<ServerResponse> getItemsRouter(ItemHandler handler) {
        return RouterFunctions
                .route(GET("/item/getAll").and(accept(MediaType.APPLICATION_JSON)), handler::getAllItems)
                .andRoute(POST("/item/add").and(accept(MediaType.APPLICATION_JSON)), handler::addItem);
    }
}