package com.oracle.dao;

import com.oracle.model.Purchas;
import jakarta.persistence.EntityManager;

public class PurchasDAO {
    private EntityManager em;

    public PurchasDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Purchas p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public Purchas getById(int id) {
        return em.find(Purchas.class, id);
    }

    public void update(Purchas p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    public void delete(Purchas p) {
        em.getTransaction().begin();
        em.remove(em.contains(p) ? p : em.merge(p));
        em.getTransaction().commit();
    }
}
