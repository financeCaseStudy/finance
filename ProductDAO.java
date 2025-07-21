package com.oracle.dao;

import com.oracle.model.Product;
import jakarta.persistence.EntityManager;

public class ProductDAO {
    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Product p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public Product getById(int id) {
        return em.find(Product.class, id);
    }

    public void update(Product p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    public void delete(Product p) {
        em.getTransaction().begin();
        em.remove(em.contains(p) ? p : em.merge(p));
        em.getTransaction().commit();
    }
}
