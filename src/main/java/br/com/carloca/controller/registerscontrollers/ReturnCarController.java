package br.com.carloca.controller.registerscontrollers;

import br.com.carloca.dao.*;
import br.com.carloca.exceptions.CostumerNotUsingCarException;
import br.com.carloca.exceptions.DateFormatException;
import br.com.carloca.models.*;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;

public class ReturnCarController {
    private FranchiseUnitDao franchiseUnitDao;
    private CarReturnSpecificationsDao carReturnSpecificationsDao;
    private CostumerDao costumerDao;
    private CarRentalsRecordsDao carRentalsRecordsDao;
    private CarDao carDao;

    public ReturnCarController(){
        this.franchiseUnitDao = new FranchiseUnitDao();
        this.carReturnSpecificationsDao = new CarReturnSpecificationsDao();
        this.costumerDao = new CostumerDao();
        this.carRentalsRecordsDao = new CarRentalsRecordsDao();
        this.carDao =new CarDao();
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

    public CarReturnSpecifications newReturn(LocalDate date, Integer odometer, FranchiseUnit franchiseUnit, Costumer costumer, Car car) {
        CarReturnSpecifications carReturnSpecifications = carReturnSpecificationsDao.createCarReturnSpecificationsDao(date,odometer,franchiseUnit);
        carRentalsRecordsDao.registerReturn(costumer, carReturnSpecifications);
        costumerDao.updateInUseReturn(costumer);
        carDao.updateCarAtributesInReturn(car,carReturnSpecifications.getOdometerRegistration());
        return carReturnSpecifications;
    }

    public FranchiseUnit getFranchiseUnit(int id) {
        return franchiseUnitDao.retrieve(id);
    }

    public Costumer getCostumer(String document) {
        Costumer costumer = costumerDao.retrieve(document);
        if (!costumer.isUsingCar()) {
            throw new CostumerNotUsingCarException("Esse cliente não está alugando nenhum carro");
        }
        return costumer;
    }

    public CarRentalsRecords getCurrentRent(Costumer costumer) {
        try{
            carRentalsRecordsDao.retrieve(costumer);
        }catch (NoResultException ex){
            throw new NoResultException();
        }
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
