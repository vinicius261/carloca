package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.*;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class AddressDao {
    private EntityManager entityManager;
    private Util util;

    public AddressDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Address createAddress(Zipcode zipcode, Street street, Complement complement){
        Address address = new Address(zipcode, street, complement);
        util.create(address, entityManager);

        return address;
    }
}
