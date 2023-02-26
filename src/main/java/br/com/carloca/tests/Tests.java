package br.com.carloca.tests;

import br.com.carloca.dao.*;
import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.*;
import com.mysql.cj.xdevapi.AddResult;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class Tests {

    public static void main(String[] args) {

        StreetDao streetDao = new StreetDao();
        Street street = streetDao.createStreet();

        ZipcodeDao zipcodeDao = new ZipcodeDao();
        Zipcode zipcode = zipcodeDao.createZipcode();

        ComplementDao complementDao = new ComplementDao();
        Complement complement = complementDao.createComplement();

        AddressDao addressDao = new AddressDao();
        Address address = addressDao.createAddress(zipcode, street, complement);

        CostumerDao costumerDao = new CostumerDao();
        costumerDao.createCostumer("401156898", "Lulu", address);
    }
}
