package com.staxrt.tutorial.reactive.handler;

import com.staxrt.tutorial.reactive.Repository.ItemRepos;
import com.staxrt.tutorial.reactive.entities.Items;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ubuntu on 18/05/20.
 */
@Component
public class ItemHandler {

    @Qualifier("itemReposImpl")
    ItemRepos itemRepos;

    public ItemHandler(ItemRepos itemRepos) {
        this.itemRepos = itemRepos;
    }

    public Mono<ServerResponse> addItem(ServerRequest serverRequest) {
        Mono<Items> items = serverRequest.bodyToMono(Items.class);
        return items.flatMap(i ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(itemRepos.add(i), Items.class)
        );
    }

    public Mono<ServerResponse> getAllItems(ServerRequest serverRequest) {
        List<Items> itemsList = itemRepos.getALL();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.just(itemsList).log(), Items.class);
    }

}
