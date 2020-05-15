package com.staxrt.tutorial.daos;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by ubuntu on 15/05/20.
 */
public class AbstractEntityManager {
    protected EntityManagerFactory emf;

    @PersistenceUnit
    void setEmg(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
