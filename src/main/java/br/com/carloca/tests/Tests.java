package br.com.carloca.tests;

import br.com.carloca.dao.*;
import br.com.carloca.enums.CarColors;
import br.com.carloca.models.*;

import java.time.LocalDate;

public class Tests {

    public static void main(String[] args) {

        StreetDao streetDao = new StreetDao();
        Street street = streetDao.createStreet();

        ZipcodeDao zipcodeDao = new ZipcodeDao();
        Zipcode zipcode = zipcodeDao.createZipcode();

        ComplementDao complementDao = new ComplementDao();
        Complement complement = complementDao.createComplement("bloco tal");

        AddressDao addressDao = new AddressDao();
        Address address = addressDao.createAddress(zipcode, street, complement);

        CostumerDao costumerDao = new CostumerDao();
        Costumer costumer = costumerDao.createCostumer("401156898", "Lulu", address);

        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.createCategoryDao("SUV");

        BrandDao brandDao = new BrandDao();
        Brand brand = brandDao.createBrand("FIAT");

        CarModelDao carModelDao = new CarModelDao();
        CarModel carModel = carModelDao.createCarModel("Uno", category, brand);

        CarVersionDao carVersionDao = new CarVersionDao();
        CarVersion carVersion = carVersionDao.createCarVersionDao("Joy",carModel,"1.0",
                false,false, false);

        CarDao carDao = new CarDao();
        Car car = carDao.createCar("ejk0589", carVersion, CarColors.WHITE, false, 5000);

        FranchiseUnitDao franchiseUnitDao = new FranchiseUnitDao();
        FranchiseUnit franchiseUnit = franchiseUnitDao.createFranchiseUnit("Pompéia", address);

        WithdrawalSpecificationsDao withdrawalSpecificationsDao = new WithdrawalSpecificationsDao();
        CarWithdrawalSpecifications carWithdrawalSpecifications = withdrawalSpecificationsDao.createWithdrawalSpecifications(LocalDate.parse("2023-12-03"), car.getOdometer(),franchiseUnit);

        CarRentalsRecordsDao carRentalsRecordsDao = new CarRentalsRecordsDao();
        CarRentalsRecords carRentalsRecords = carRentalsRecordsDao.createCarRentalsRecords(car, costumer, carWithdrawalSpecifications);


    }
}
