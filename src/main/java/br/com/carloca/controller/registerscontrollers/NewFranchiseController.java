package br.com.carloca.controller.registerscontrollers;

import br.com.carloca.dao.*;
import br.com.carloca.models.*;

public class NewFranchiseController {
    private StreetDao streetDao;
    private ComplementDao complementDao;
    private ZipcodeDao zipcodeDao;
    private AddressDao addressDao;
    private FranchiseUnitDao franchiseUnitDao;

    public NewFranchiseController(){
        this.streetDao = new StreetDao();
        this.complementDao = new ComplementDao();
        this.zipcodeDao = new ZipcodeDao();
        this.addressDao = new AddressDao();
        this.franchiseUnitDao = new FranchiseUnitDao();
    }


    public FranchiseUnit createFranchise() {
        Street street = streetDao.createStreet("Avenida Pacaembu");
        Complement complement = complementDao.createComplement("59");
        Zipcode zipcode = zipcodeDao.createZipcode("52598774");
        Address address = addressDao.createAddress(zipcode, street, complement);
        FranchiseUnit franchiseUnit = franchiseUnitDao.createFranchiseUnit("Pacaembu", address);

        Street streetReturn = streetDao.createStreet("Marginal pinheiros");
        Complement complementReturn = complementDao.createComplement("12");
        Zipcode zipcodeReturn = zipcodeDao.createZipcode("8569996");
        Address addressReturn = addressDao.createAddress(zipcodeReturn, streetReturn, complementReturn);
        FranchiseUnit franchiseUnitReturn = franchiseUnitDao.createFranchiseUnit("Itaquera", addressReturn);

        return franchiseUnitReturn;
    }
}
