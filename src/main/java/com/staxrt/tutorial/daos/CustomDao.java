package com.staxrt.tutorial.daos;


import java.util.Optional;


public interface CustomDao<E, I> {
    Optional<E> update(E e, I i);

    void save(E e);

    void delete(I i);

    void getAll();

    void findById(I i);

    void addDD();
}
