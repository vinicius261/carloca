package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Brand;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class BrandDao {
    private EntityManager entityManager;
    private Util util;

    public BrandDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Brand createBrand(String name){
        Brand brand = new Brand(name);

        util.create(brand, entityManager);

        return brand;
    }
}


