package br.com.carloca.dao;

import br.com.carloca.enums.CarColors;
import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Car;
import br.com.carloca.models.CarVersion;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public void updateInUseRent(Car car){
        Car carToUpdate = retrieve(car.getLicensePlate());
        entityManager.getTransaction().begin();
        entityManager.merge(carToUpdate);
        carToUpdate.setInUse(true);
        entityManager.getTransaction().commit();
    }

    public void updateCarAtributesInReturn(Car car, Integer newOdometer){
        Car carToUpdate = retrieve(car.getLicensePlate());
        entityManager.getTransaction().begin();
        entityManager.merge(carToUpdate);
        carToUpdate.setInUse(false);
        carToUpdate.setOdometer(newOdometer);
        entityManager.getTransaction().commit();
    }

    public List<Car> retrieveAll() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        String jpql = "SELECT c FROM Car c";

        entityManager.getTransaction().begin();
        List<Car> cars = entityManager.createQuery(jpql).getResultList();
        entityManager.getTransaction().commit();

        return cars;
    }

    public List<Car> retrieveAvailableCars() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT c FROM Car c WHERE c.inUse = :inUse";
        List<Car> cars = entityManager.createQuery(jpql, Car.class)
                .setParameter("inUse", false)
                .getResultList();
        entityManager.getTransaction().commit();

        return cars;
    }

    public Car retrieve(String licensePlate) {
        Car car;
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT c FROM Car c WHERE c.licensePlate = :licensePlate";
            car = entityManager.createQuery(jpql, Car.class)
                    .setParameter("licensePlate", licensePlate)
                    .getSingleResult();
            entityManager.getTransaction().commit();
        }catch (NoResultException ex){
            throw new NoResultException();
        }

        return car;
    }
}

