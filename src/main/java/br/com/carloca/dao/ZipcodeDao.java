package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Zipcode;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class ZipcodeDao {
    private EntityManager entityManager;
    private Util util;

    public ZipcodeDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Zipcode createZipcode() {
        Zipcode zipcode = new Zipcode();

        util.create(zipcode, entityManager);

        return zipcode;
    }
}
