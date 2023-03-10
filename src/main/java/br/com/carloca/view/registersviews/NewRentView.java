package br.com.carloca.view.registersviews;

import br.com.carloca.controller.registerscontrollers.NewFranchiseController;
import br.com.carloca.controller.registerscontrollers.NewRentController;
import br.com.carloca.exceptions.*;
import br.com.carloca.models.Car;
import br.com.carloca.models.CarWithdrawalSpecifications;
import br.com.carloca.models.Costumer;
import br.com.carloca.models.FranchiseUnit;
import br.com.carloca.view.MainView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class NewRentView {
    private NewRentController controller;
    private Scanner scanner;

    public NewRentView(){
        this.controller = new NewRentController();
        this.scanner = new Scanner(System.in);
    }
    public void showView(String input){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                NOVA LOCAÇÃO");

        newRent(input);

    }

    private void newRent(String document) {
        try {
            Costumer costumer = controller.getCostumer(document);
            Car car = getAvailableCar();

            CarWithdrawalSpecifications withdrawalSpecifications = getWithdrawalSpecifications(car.getOdometer());

            controller.newRent(car, costumer, withdrawalSpecifications);

            System.out.println("Aluguel registrado com sucesso.\n\n");
            System.out.println("------------------------------------------------------------------------");
            MainView mainView = new MainView();
            mainView.showView();

        }catch (CostumerIsUsinCarException | CostumerNotFoundException ex) {
            System.out.println(ex.getMessage());
            CarRentalRecordsView carRentalRecordsView = new CarRentalRecordsView();
            carRentalRecordsView.showView();
        }
    }

    private Car getAvailableCar() {
        showAvailableCars();

        System.out.println("Digite a placa de um carro da lista: ");

        return controller.getAvailableCar(scanner.nextLine().toUpperCase());
    }

    private CarWithdrawalSpecifications getWithdrawalSpecifications(Integer odometer) {
        LocalDate date = LocalDate.now();

        FranchiseUnit franchiseUnit = getFranchiseUnit();

        return controller.newWithdrawalSpecifications(date, odometer, franchiseUnit);
    }

    private FranchiseUnit getFranchiseUnit() {
        try{
            showFranchiseUnits();
            System.out.println("\nInsira o número da unidade em que o carro será retirado: ");
            return controller.getFranchiseUnit(scanner.nextInt());
        }catch (NoFranchiseException ex){
            NewFranchiseController franchiseController =  new NewFranchiseController();
            return franchiseController.createFranchise();
        }
    }

    private void showFranchiseUnits() {
        try{
            List<FranchiseUnit> franchiseUnits = controller.showFranchiseUnits();
            franchiseUnits.forEach(franchiseUnit -> System.out.println(franchiseUnit.getId() +
                    " - " + franchiseUnit.getName()));
        }catch (NoFranchiseException ex){
            throw  new NoFranchiseException();
        }

    }

    private void showAvailableCars() {
        try {
            List<Car> cars = controller.getAvailableCars();

            cars.forEach(car -> System.out.println(car.getLicensePlate() + " - " +
                    car.getCarVersion().getCarModel().getName() + " - " + car.getCarVersion().getName()));

        }catch (NoAvailableCarsException ex){
            System.out.println(ex.getMessage());

            MainView mainView = new MainView();
            mainView.showView();
        }
    }
}
