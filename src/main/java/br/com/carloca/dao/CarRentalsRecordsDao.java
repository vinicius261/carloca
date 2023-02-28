package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.*;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class CarRentalsRecordsDao {
    private EntityManager entityManager;
    private Util util;

    public CarRentalsRecordsDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public CarRentalsRecords createCarRentalsRecords(Car car, Costumer costumer, CarWithdrawalSpecifications carWithdrawalSpecifications){
        CarRentalsRecords carRentalsRecords = new CarRentalsRecords(car, costumer, carWithdrawalSpecifications);

        util.create(carRentalsRecords, entityManager);

        return carRentalsRecords;
    }

    public CarRentalsRecords retrieve(Costumer costumer) {
        entityManager.getTransaction().begin();
        String jpql = "SELECT c FROM CarRentalsRecords c WHERE c.costumer = :costumer";
        CarRentalsRecords carRentalsRecords = entityManager.createQuery(jpql, CarRentalsRecords.class)
                .setParameter("costumer", costumer)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return carRentalsRecords;
    }

    public void registerReturn(Costumer costumer, CarReturnSpecifications carReturnSpecifications) {
        CarRentalsRecords records = retrieve(costumer);
        entityManager.getTransaction().begin();
        entityManager.merge(records);
        records.setReturnSpecifications(carReturnSpecifications);
        entityManager.getTransaction().commit();
    }
}
