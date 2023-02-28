package br.com.carloca.controller;

import br.com.carloca.dao.*;
import br.com.carloca.models.*;

public class NewCostumerController {
    private CostumerDao costumerDao;
    private AddressDao addressDao;
    private StreetDao streetDao;
    private ZipcodeDao zipcodeDao;
    private ComplementDao complementDao;

    public NewCostumerController(){
        this.costumerDao = new CostumerDao();
        this.addressDao = new AddressDao();
        this.streetDao = new StreetDao();
        this.zipcodeDao = new ZipcodeDao();
        this.complementDao = new ComplementDao();
    }
    public Costumer registerCostumer(String name, String document, String inputZipcode, String inputStreet,
                                     String inputComplement) {
        Complement complement = complementDao.createComplement(inputComplement);
        Street street = streetDao.createStreet(inputStreet);
        Zipcode zipcode = zipcodeDao.createZipcode(inputZipcode);
        Address address = addressDao.createAddress(zipcode,street,complement);
        Costumer costumer = costumerDao.createCostumer(document, name,address);

        return new Costumer(document, name,address);
    }

}
