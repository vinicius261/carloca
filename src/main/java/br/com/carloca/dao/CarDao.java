package br.com.carloca.dao;

import br.com.carloca.enums.CarColors;
import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Car;
import br.com.carloca.models.CarVersion;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class CarDao {

    private EntityManager entityManager;
    private Util util;

    public CarDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Car createCar(String name, CarVersion carVersion, CarColors carColor, boolean inUSe, Integer odometer){
        Car car = new Car(name, carVersion, carColor, inUSe, odometer);

        util.create(car, entityManager);

        return car;
    }
}

