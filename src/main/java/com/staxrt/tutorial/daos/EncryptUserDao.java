package com.staxrt.tutorial.daos;

import java.util.List;

/**
 * Created by ubuntu on 15/05/20.
 */
public interface EncryptUserDao<E, I> {
    E findById(I i);

    List<E> getAll();

    void delete(I i);

    void create(E e);

    void put(E e);

    E findByUserName(String userName);
}
