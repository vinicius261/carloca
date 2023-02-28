package br.com.carloca.controller.registerscontrollers;

import br.com.carloca.dao.*;
import br.com.carloca.enums.CarColors;
import br.com.carloca.models.*;

public class NewCarController {
    private CarDao carDao;
    private BrandDao brandDao;
    private CategoryDao categoryDao;
    private CarModelDao carModelDao;
    private CarVersionDao carVersionDao;

    public NewCarController(){
        this.carDao = new CarDao();
        this.brandDao = new BrandDao();
        this.categoryDao = new CategoryDao();
        this.carModelDao = new CarModelDao();
        this.carVersionDao = new CarVersionDao();
    }
    public Integer getKm(String input) {
        Integer odometer;
        try{
            odometer = Integer.parseInt(input);
        }catch (NumberFormatException ex){
            return 0;
        }
        return odometer;
    }

    public Car newCar(String licensePlate, CarVersion carVersion, CarColors color, Integer odometer) {
        return carDao.createCar(licensePlate, carVersion, color,false ,odometer );
    }

    public Brand newBrand(String name) {
        return brandDao.createBrand(name);
    }

    public Category newCategory(String name) {
        return categoryDao.createCategoryDao(name);
    }

    public CarModel newCarmodel(String name, Category category, Brand brand) {
        return carModelDao.createCarModel(name,category,brand);
    }

    public CarVersion newCarVersion(String versionName, CarModel carModel, String motorization,
                              boolean airConditioning, boolean hydraulicStreering, boolean airbag) {
        return carVersionDao.createCarVersionDao(versionName, carModel, motorization, airConditioning,
                hydraulicStreering, airbag);
    }
}
