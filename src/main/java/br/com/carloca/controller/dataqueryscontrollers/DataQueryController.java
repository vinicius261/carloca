package br.com.carloca.controller.dataqueryscontrollers;

import br.com.carloca.dao.CarDao;
import br.com.carloca.dao.CarRentalsRecordsDao;
import br.com.carloca.dao.WithdrawalSpecificationsDao;
import br.com.carloca.models.Car;
import br.com.carloca.models.CarReturnSpecifications;
import br.com.carloca.models.CarWithdrawalSpecifications;
import br.com.carloca.models.Costumer;
import br.com.carloca.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataQueryController {
    private CarDao carDao;
    private CarRentalsRecordsDao carRentalsRecordsDao;

    public DataQueryController() {
        this.carDao = new CarDao();
        this.carRentalsRecordsDao = new CarRentalsRecordsDao();
    }

    public List<Car> getCars() {
        return carDao.retrieveAll();
    }

    public List<Costumer> getCostumersPerCar(Car car) {
       return carRentalsRecordsDao.retrieveCostumersPerCar(car);
    }

    public List<CarReturnSpecifications> getReturnsPerCar(Car car) {
        return carRentalsRecordsDao.retrieveReturnsPerCar(car);
    }

    public List<CarWithdrawalSpecifications> getWithdrawalsPerCar(Car car) {
        return carRentalsRecordsDao.retrieveWithdrawalsPerCar(car);
    }

    public Integer getKmPerRent( CarWithdrawalSpecifications withdrawal, CarReturnSpecifications returns) {
        Integer withdrawalKm = withdrawal.getOdometerRegistration();
        Integer returnsKm = returns.getOdometerRegistration();
        Integer kmRodado = returnsKm - withdrawalKm;

        return kmRodado;
    }

    public Car getCar(String licensePlate) {
        return carDao.retrieve(licensePlate);
    }
}
