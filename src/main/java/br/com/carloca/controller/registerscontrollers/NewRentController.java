package br.com.carloca.controller.registerscontrollers;

import br.com.carloca.dao.*;
import br.com.carloca.exceptions.CostumerIsUsinCarException;
import br.com.carloca.exceptions.DateFormatException;
import br.com.carloca.exceptions.NoAvailableCarsException;
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
        Costumer costumer =  costumerDao.retrieve(document);
        if(costumer.isUsingCar() == false) {
            return costumer;
        }else {
        throw new CostumerIsUsinCarException("Esse cliente já está alugando um carro.");
        }
    }

    public void newRent(Car car, Costumer costumer, CarWithdrawalSpecifications withdrawalSpecifications) {
        carRentalsRecordsDao.createCarRentalsRecords(car, costumer, withdrawalSpecifications);
        costumerDao.updateInUseRent(costumer);
        carDao.updateInUseRent(car);
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

    public FranchiseUnit getFranchiseUnit(int id) {
        return franchiseUnitDao.retrieve(id);
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = carDao.retrieveAvailableCars();

        if(availableCars.isEmpty()){
            throw new NoAvailableCarsException("Não existem carros disponíveis no momento.");
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
