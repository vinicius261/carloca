package br.com.carloca.models;

import br.com.carloca.enums.CarColors;

import javax.persistence.*;

@Entity
@Table(name = "rents_records")
public class RentsRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Costumer costumer;
    @ManyToOne
    private WithdrawalSpecifications withdrawalSpecifications;
    @ManyToOne
    private ReturnSpecifications returnSpecifications;

    public RentsRecords(Car car, Costumer costumer, WithdrawalSpecifications withdrawalSpecifications) {
        this.car = car;
        this.costumer = costumer;
        this.withdrawalSpecifications = withdrawalSpecifications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public WithdrawalSpecifications getWithdrawalSpecifications() {
        return withdrawalSpecifications;
    }

    public void setWithdrawalSpecifications(WithdrawalSpecifications withdrawalSpecifications) {
        this.withdrawalSpecifications = withdrawalSpecifications;
    }

    public ReturnSpecifications getReturnSpecifications() {
        return returnSpecifications;
    }

    public void setReturnSpecifications(ReturnSpecifications returnSpecifications) {
        this.returnSpecifications = returnSpecifications;
    }
}
