package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Address;
import br.com.carloca.models.Complement;
import br.com.carloca.models.Costumer;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class CostumerDao {
    private EntityManager entityManager;
    private Util util;

    public CostumerDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Costumer createCostumer(String document, String name, Address address){
        Costumer costumer = new Costumer(document,name, address);

        util.create(costumer, entityManager);

        return costumer;
    }

    public Costumer retrieve(String document){
        entityManager.getTransaction().begin();
        Costumer costumer = entityManager.find(Costumer.class, document);
        entityManager.getTransaction().commit();
        entityManager.close();

        return costumer;
    }
}
