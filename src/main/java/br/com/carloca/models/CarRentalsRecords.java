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
    @OneToOne
    private CarWithdrawalSpecifications carWithdrawalSpecifications;
    @OneToOne
    private CarReturnSpecifications carReturnSpecifications;

    public CarRentalsRecords(Car car, Costumer costumer, CarWithdrawalSpecifications carWithdrawalSpecifications) {
        this.car = car;
        this.costumer = costumer;
        this.carWithdrawalSpecifications = carWithdrawalSpecifications;
    }
    public CarRentalsRecords(){

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

    public CarWithdrawalSpecifications getWithdrawalSpecifications() {
        return carWithdrawalSpecifications;
    }

    public void setWithdrawalSpecifications(CarWithdrawalSpecifications carWithdrawalSpecifications) {
        this.carWithdrawalSpecifications = carWithdrawalSpecifications;
    }

    public CarReturnSpecifications getReturnSpecifications() {
        return carReturnSpecifications;
    }

    public void setReturnSpecifications(CarReturnSpecifications carReturnSpecifications) {
        this.carReturnSpecifications = carReturnSpecifications;
    }
}
