package com.staxrt.tutorial.reactive.Repository;

import java.util.List;

/**
 * Created by ubuntu on 18/05/20.
 */
public interface ItemRepos<I, E> {
    E add(E t);

    E delete(I i);

    List<E> getALL();

    E find(I i);
}
