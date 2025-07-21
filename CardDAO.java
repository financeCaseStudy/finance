package com.oracle.dao;

import com.oracle.model.Card;
import jakarta.persistence.EntityManager;

public class CardDAO {
    private EntityManager em;

    public CardDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Card card) {
        em.getTransaction().begin();
        em.persist(card);
        em.getTransaction().commit();
    }
}
