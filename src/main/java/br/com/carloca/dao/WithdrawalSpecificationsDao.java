package br.com.carloca.dao;

import br.com.carloca.factory.ManagerFactory;
import br.com.carloca.models.FranchiseUnit;
import br.com.carloca.models.CarWithdrawalSpecifications;
import br.com.carloca.util.Util;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;

public class WithdrawalSpecificationsDao {
    private EntityManager entityManager;
    private Util util;

    public WithdrawalSpecificationsDao(){
        this.entityManager = new ManagerFactory().createEntityManager();
        this.util = new Util();
    }

    public CarWithdrawalSpecifications createWithdrawalSpecifications(LocalDate date, Integer odometerRegistration, FranchiseUnit franchiseUnit){
        CarWithdrawalSpecifications carWithdrawalSpecifications = new CarWithdrawalSpecifications(date, odometerRegistration, franchiseUnit);

        util.create(carWithdrawalSpecifications, entityManager);

        return carWithdrawalSpecifications;
    }
}
