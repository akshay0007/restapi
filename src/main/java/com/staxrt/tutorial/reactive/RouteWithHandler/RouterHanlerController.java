package com.staxrt.tutorial.reactive.RouteWithHandler;

import com.staxrt.tutorial.reactive.Repository.ItemRepos;
import com.staxrt.tutorial.reactive.entities.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;

import java.util.Arrays;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by ubuntu on 18/05/20.
 */
@Configuration
public class RouterHanlerController {
    ItemRepos itemRepo;

    @Autowired
    public void setItemRepo(@Qualifier("itemReposImpl") ItemRepos itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Bean
    public RouterFunction<?> getAllData() {
        return route(GET("/v11/getAll"), serverRequest ->
                ok().body(Flux.just(Arrays.asList(
                        new Items("d1", "d", "d"),
                        new Items("d2", "d", "d")
                )), Items.class)
        );
    }

}
