package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Address;
import br.com.carloca.models.Costumer;
import br.com.carloca.models.FranchiseUnit;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class FranchiseUnitDao {
    private EntityManager entityManager;
    private Util util;

    public FranchiseUnitDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public FranchiseUnit createFranchiseUnit(String name, Address address){
        FranchiseUnit franchiseUnit = new FranchiseUnit(name, address);

        util.create(franchiseUnit, entityManager);

        return franchiseUnit;
    }
}
