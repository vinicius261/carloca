package br.com.carloca.util;

import javax.persistence.EntityManager;

public class Util {

    public void create(Object object, EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
