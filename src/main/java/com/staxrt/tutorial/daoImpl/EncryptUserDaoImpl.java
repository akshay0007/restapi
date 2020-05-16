package com.staxrt.tutorial.daoImpl;

import com.staxrt.tutorial.daos.AbstractEntityManager;
import com.staxrt.tutorial.daos.EncryptUserDao;
import com.staxrt.tutorial.model.SecureUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by ubuntu on 15/05/20.
 */
@Repository
public class EncryptUserDaoImpl extends AbstractEntityManager implements EncryptUserDao<SecureUser, Integer> {


    @Override
    public SecureUser findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        SecureUser secureUser = em.find(SecureUser.class, id);
        em.getTransaction().commit();
        em.close();
        return secureUser;
    }

    @Override
    public List<SecureUser> getAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<SecureUser> list = em.createQuery("from SecureUser", SecureUser.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        SecureUser secureUser = em.find(SecureUser.class, id);
        if (secureUser != null)
            em.remove(id);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public SecureUser create(SecureUser secureUser) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(secureUser);
        em.getTransaction().commit();
        em.close();
        return secureUser;
    }

    @Override
    public void put(SecureUser secureUser) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(secureUser);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public SecureUser findByUserName(String userName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        SecureUser secureUser = em.createQuery("from SecureUser s where s.userName=:userName", SecureUser.class)
                .setParameter("userName", userName).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return secureUser;
    }
}
