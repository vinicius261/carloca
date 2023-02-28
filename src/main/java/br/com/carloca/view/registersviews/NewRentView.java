package br.com.carloca.view.registersviews;

import br.com.carloca.controller.NewRentController;
import br.com.carloca.exceptions.DateFormatException;
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
        Costumer costumer = controller.getCostumer(document);

        Car car = getAvailableCar();

        CarWithdrawalSpecifications withdrawalSpecifications = getWithdrawalSpecifications(car.getOdometer());

        controller.newRent(car, costumer, withdrawalSpecifications);

        System.out.println("Aluguel registrado com sucesso.\n\n");
        System.out.println("------------------------------------------------------------------------");
        MainView mainView = new MainView();
        mainView.showView();
    }

    private Car getAvailableCar() {
        showAvailableCars();

        System.out.println("Digite a placa de um carro da lista: ");

        return controller.getAvailableCar(scanner.nextLine().toUpperCase());
    }

    private CarWithdrawalSpecifications getWithdrawalSpecifications(Integer odometer) {
        LocalDate date = getDate();

        FranchiseUnit franchiseUnit = getFranchiseUnit();

        return controller.newWithdrawalSpecifications(date, odometer, franchiseUnit);
    }

    public LocalDate getDate(){
        LocalDate date;

        System.out.println("Insira a data de retirada no formato AAAA-MM-DD: ");
        try {
            date = controller.getDate(scanner.nextLine());
        }catch (DateFormatException ex){
            System.out.println(ex.getMessage());
            date = getDate();
        }
        return date;
    }

    private FranchiseUnit getFranchiseUnit() {
        showFranchiseUnits();
        System.out.println("\nInsira o número da unidade em que o carro será retirado: ");
        return controller.getFranchiseUnit(scanner.nextInt());
    }

    private void showFranchiseUnits() {
        List<FranchiseUnit> franchiseUnits = controller.showFranchiseUnits();
        franchiseUnits.forEach(franchiseUnit -> System.out.println(franchiseUnit.getId() +
                " - " + franchiseUnit.getName()));
    }

    private void showAvailableCars() {
        List<Car> cars = controller.getAvailableCars();
        cars.forEach(car -> System.out.println(car.getLicensePlate() + " - " +
                car.getCarVersion().getName()+ " - " + car.getCarVersion().getName() ));
    }
}
