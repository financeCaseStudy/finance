package com.oracle.dao;

import com.oracle.model.User;
import jakarta.persistence.EntityManager;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User getById(int id) {
        return em.find(User.class, id);
    }

    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void delete(User user) {
        em.getTransaction().begin();
        em.remove(em.contains(user) ? user : em.merge(user));
        em.getTransaction().commit();
    }
}
