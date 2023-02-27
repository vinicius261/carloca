package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.Category;
import br.com.carloca.models.Complement;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;

public class ComplementDao {
    private EntityManager entityManager;
    private Util util;

    public ComplementDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public Complement createComplement(String inputComplement){
        Complement complement = new Complement(inputComplement);

        util.create(complement, entityManager);

        return complement;
    }
}
