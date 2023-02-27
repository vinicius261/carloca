package br.com.carloca.controller;

import br.com.carloca.dao.*;
import br.com.carloca.exceptions.DateFormatException;
import br.com.carloca.models.Car;
import br.com.carloca.models.CarWithdrawalSpecifications;
import br.com.carloca.models.Costumer;
import br.com.carloca.models.FranchiseUnit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewRentController {
    private CarRentalsRecordsDao carRentalsRecordsDao;
    private CostumerDao costumerDao;
    private CarDao carDao;
    private WithdrawalSpecificationsDao withdrawalSpecificationsDao;
    private FranchiseUnitDao franchiseUnitDao;

    public NewRentController() {
        this.carRentalsRecordsDao = new CarRentalsRecordsDao();
        this.costumerDao = new CostumerDao();
        this.carDao = new CarDao();
        this.withdrawalSpecificationsDao = new WithdrawalSpecificationsDao();
        this.franchiseUnitDao = new FranchiseUnitDao();
    }

    public Costumer getCostumer(String document) {
        return costumerDao.retrieve(document);
    }

    public void newRent(Car car, Costumer costumer, CarWithdrawalSpecifications withdrawalSpecifications) {
        carRentalsRecordsDao.createCarRentalsRecords(car, costumer, withdrawalSpecifications);
    }

    public Car getAvailableCar(String licensePlate) {
        return carDao.retrieve(licensePlate);
    }

    public LocalDate getDate(String input) {
        LocalDate date;

        try{
            date = LocalDate.parse(input);
        }catch (RuntimeException ex){
            throw new DateFormatException("Respeite o formato indicado.");
        }

        return date;
    }

    public CarWithdrawalSpecifications newWithdrawalSpecifications(LocalDate date, Integer odometer, FranchiseUnit franchiseUnit) {
        return withdrawalSpecificationsDao.createWithdrawalSpecifications(date,odometer,franchiseUnit);
    }

    public FranchiseUnit getFranchiseUnit(String id) {
        return franchiseUnitDao.retrieve(id);
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();

        List<Car> cars = carDao.retrieveAll();

        for (Car car: cars) {
            if(car.isInUSe() == false){
                availableCars.add(car);
            }
        }

        return availableCars;
    }

    public List<FranchiseUnit> showFranchiseUnits() {
        List<FranchiseUnit> franchiseUnits = franchiseUnitDao.retrieveAll();

        if (franchiseUnits.isEmpty()){
            System.out.println("Ainda não tem unidades cadastradas.");
        }
        return franchiseUnitDao.retrieveAll();
    }
}