package br.com.carloca.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {
    public EntityManagerFactory factory;

    public ManagerFactory(){
        this.factory = Persistence.createEntityManagerFactory("jcarloca");
    }

    public EntityManager createEntityManager(){
        return factory.createEntityManager();
    }
}
