package com.oracle.dao;

import com.oracle.model.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDAO {
    private EntityManager em;

    public TransactionDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Transaction t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    public Transaction getById(int id) {
        return em.find(Transaction.class, id);
    }

    public void update(Transaction t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    public void delete(Transaction t) {
        em.getTransaction().begin();
        em.remove(em.contains(t) ? t : em.merge(t));
        em.getTransaction().commit();
    }
}
