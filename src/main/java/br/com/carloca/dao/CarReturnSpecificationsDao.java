package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.*;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;
import java.util.Date;

public class CarReturnSpecificationsDao {
    private EntityManager entityManager;
    private Util util;

    public CarReturnSpecificationsDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public CarReturnSpecifications createCarReturnSpecificationsDao(Date date, Double odometerRegistration, FranchiseUnit franchiseUnit){
        CarReturnSpecifications carReturnSpecifications = new CarReturnSpecifications(date, odometerRegistration, franchiseUnit);

        util.create(carReturnSpecifications, entityManager);

        return carReturnSpecifications;
    }
}
