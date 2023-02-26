package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Brand;
import br.com.carloca.models.CarModel;
import br.com.carloca.models.Category;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class CarModelDao {
    private EntityManager entityManager;
    private Util util;

    public CarModelDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public CarModel createCarModel(String name, Category category, Brand brand){
        CarModel carModel = new CarModel(name, category, brand);

        util.create(carModel, entityManager);

        return carModel;
    }
}
