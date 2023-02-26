package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.CarModel;
import br.com.carloca.models.CarVersion;
import br.com.carloca.models.Category;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class CategoryDao {
    private EntityManager entityManager;
    private Util util;

    public CategoryDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Category createCategoryDao(String name){
        Category category = new Category(name);

        util.create(category, entityManager);

        return category;
    }
}
