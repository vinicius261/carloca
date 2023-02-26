package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.FranchiseUnit;
import br.com.carloca.models.WithdrawalSpecifications;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;
import java.util.Date;

public class WithdrawalSpecificationsDao {
    private EntityManager entityManager;
    private Util util;

    public WithdrawalSpecificationsDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public WithdrawalSpecifications createWithdrawalSpecifications(Date date, Double odometerRegistration, FranchiseUnit franchiseUnit){
        WithdrawalSpecifications withdrawalSpecifications = new WithdrawalSpecifications(date, odometerRegistration, franchiseUnit);

        util.create(withdrawalSpecifications, entityManager);

        return withdrawalSpecifications;
    }
}
