package br.com.carloca.tests;

import br.com.carloca.models.*;
import com.mysql.cj.xdevapi.AddResult;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class Tests {

    public static void main(String[] args) {
        Street street = createStreet();
        Zipcode zipcode = createZipcode();
        Complement complement =createComplement();

        Address address = createAddress(zipcode, street, complement);

        createCostumer(address);
    }

    public static void createCostumer(Address address){
        Costumer costumer = new Costumer("4012sads88", "Chico", address);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jcarloca");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(costumer);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    public static Address createAddress(Zipcode zipcode, Street street, Complement complement){
        Address address = new Address(zipcode, street, complement);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jcarloca");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.close();

        return address;

    }
    public static Zipcode createZipcode(){
        Zipcode zipcode = new Zipcode();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jcarloca");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(zipcode);
        entityManager.getTransaction().commit();
        entityManager.close();

        return zipcode;

    }
    public static Street createStreet(){
        Street street = new Street();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jcarloca");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(street);
        entityManager.getTransaction().commit();
        entityManager.close();

        return street;
    }

    public static Complement createComplement(){
        Complement complement = new Complement();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jcarloca");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(complement);
        entityManager.getTransaction().commit();
        entityManager.close();

        return complement;

    }
}
