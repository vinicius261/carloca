package br.com.carloca.controller;

import br.com.carloca.dao.CarRentalsRecordsDao;
import br.com.carloca.dao.CarReturnSpecificationsDao;
import br.com.carloca.dao.CostumerDao;
import br.com.carloca.dao.FranchiseUnitDao;
import br.com.carloca.exceptions.DateFormatException;
import br.com.carloca.models.*;

import java.time.LocalDate;
import java.util.List;

public class ReturnCarController {
    private FranchiseUnitDao franchiseUnitDao;
    private CarReturnSpecificationsDao carReturnSpecificationsDao;
    private CostumerDao costumerDao;
    private CarRentalsRecordsDao carRentalsRecordsDao;

    public ReturnCarController(){
        this.franchiseUnitDao = new FranchiseUnitDao();
        this.carReturnSpecificationsDao = new CarReturnSpecificationsDao();
        this.costumerDao = new CostumerDao();
        this.carRentalsRecordsDao = new CarRentalsRecordsDao();
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

    public CarReturnSpecifications newReturn(LocalDate date, Integer odometer, FranchiseUnit franchiseUnit, Costumer costumer) {
        CarReturnSpecifications carReturnSpecifications = carReturnSpecificationsDao.createCarReturnSpecificationsDao(date,odometer,franchiseUnit);
        carRentalsRecordsDao.registerReturn(costumer, carReturnSpecifications);
        return carReturnSpecifications;
    }

    public FranchiseUnit getFranchiseUnit(int id) {
        return franchiseUnitDao.retrieve(id);
    }

    public Costumer getCostumer(String document) {
        return costumerDao.retrieve(document);
    }

    public CarRentalsRecords getCurrentRent(Costumer costumer) {
        return carRentalsRecordsDao.retrieve(costumer);
    }

    public List<FranchiseUnit> showFranchiseUnits() {
        List<FranchiseUnit> franchiseUnits = franchiseUnitDao.retrieveAll();

        if (franchiseUnits.isEmpty()){
            System.out.println("Ainda não tem unidades cadastradas.");
        }
        return franchiseUnitDao.retrieveAll();
    }
}
