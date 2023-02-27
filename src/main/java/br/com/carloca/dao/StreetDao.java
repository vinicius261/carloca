package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Address;
import br.com.carloca.models.FranchiseUnit;
import br.com.carloca.models.Street;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class StreetDao {
    private EntityManager entityManager;
    private Util util;

    public StreetDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Street createStreet(String inputStreet){
        Street street = new Street(inputStreet);

        util.create(street, entityManager);

        return street;
    }
}
