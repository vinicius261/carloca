package br.com.carloca.dao;

import br.com.carloca.enums.CarColors;
import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Car;
import br.com.carloca.models.CarVersion;
import br.com.carloca.models.Costumer;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;
import java.util.List;

public class CarDao {

    private EntityManager entityManager;
    private Util util;

    public CarDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Car createCar(String licensePlate, CarVersion carVersion, CarColors carColor, boolean inUSe, Integer odometer){
        Car car = new Car(licensePlate, carVersion, carColor, inUSe, odometer);

        util.create(car, entityManager);

        return car;
    }

    public List<Car> retrieveAll() {
        String jpql = "SELECT c FROM Car c";

        entityManager.getTransaction().begin();
        List<Car> cars = entityManager.createQuery(jpql).getResultList();
        entityManager.getTransaction().commit();

        return cars;
    }

    public Car retrieve(String licensePlate) {
        entityManager.getTransaction().begin();
        String jpql = "SELECT c FROM Car c WHERE c.licensePlate = :licensePlate";
        Car car = entityManager.createQuery(jpql, Car.class)
                .setParameter("licensePlate", licensePlate)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return car;
    }
}

