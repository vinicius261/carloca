package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "rents_records")
public class CarRentalsRecords {
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
    private CarReturnSpecifications carReturnSpecifications;

    public CarRentalsRecords(Car car, Costumer costumer, WithdrawalSpecifications withdrawalSpecifications) {
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

    public CarReturnSpecifications getReturnSpecifications() {
        return carReturnSpecifications;
    }

    public void setReturnSpecifications(CarReturnSpecifications carReturnSpecifications) {
        this.carReturnSpecifications = carReturnSpecifications;
    }
}
