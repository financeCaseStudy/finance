package com.oracle.dao;

import com.oracle.model.Admin;
import jakarta.persistence.EntityManager;

public class AdminDAO {
    private EntityManager em;

    public AdminDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Admin admin) {
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
    }
}
