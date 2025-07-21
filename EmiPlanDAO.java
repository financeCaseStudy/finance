package com.oracle.dao;

import com.oracle.model.EmiPlan;
import jakarta.persistence.EntityManager;

public class EmiPlanDAO {
    private EntityManager em;

    public EmiPlanDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(EmiPlan emiPlan) {
        em.getTransaction().begin();
        em.persist(emiPlan);
        em.getTransaction().commit();
    }
}
