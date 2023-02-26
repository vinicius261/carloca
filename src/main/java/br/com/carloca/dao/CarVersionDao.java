package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.CarModel;
import br.com.carloca.models.CarReturnSpecifications;
import br.com.carloca.models.CarVersion;
import br.com.carloca.models.FranchiseUnit;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;
import java.util.Date;

public class CarVersionDao {
    private EntityManager entityManager;
    private Util util;

    public CarVersionDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public CarVersion createCarVersionDao(String name, CarModel carModel, String motorization,
                                    boolean airConditioning, boolean hydraulicStreering, boolean airbag){
        CarVersion carVersion = new CarVersion(name, carModel, motorization, airConditioning, hydraulicStreering, airbag);

        util.create(carVersion, entityManager);

        return carVersion;
    }
}
