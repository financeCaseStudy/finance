package com.oracle.dao;

import com.oracle.model.Otp;
import jakarta.persistence.EntityManager;

public class OtpDAO {
    private EntityManager em;

    public OtpDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Otp otp) {
        em.getTransaction().begin();
        em.persist(otp);
        em.getTransaction().commit();
    }
}
