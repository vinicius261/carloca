package br.com.carloca.view.registersviews;

import br.com.carloca.controller.registerscontrollers.ReturnCarController;
import br.com.carloca.exceptions.DateFormatException;
import br.com.carloca.models.*;
import br.com.carloca.view.MainView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReturnCarView {
    private ReturnCarController controller;
    private Scanner scanner;

    public ReturnCarView(){
        this.controller = new ReturnCarController();
        this.scanner = new Scanner(System.in);
    }

    public void showView(String document){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                   DEVOLUÇÃO");

        newReturn(document);
    }

    private void newReturn(String document) {
        Costumer costumer = controller.getCostumer(document);

        CarRentalsRecords carRentalsRecords = getCurrentRent(costumer);

        LocalDate date = getDate();

        Integer odometer = getOdometer();

        FranchiseUnit franchiseUnit = getFranchiseUnit();

        controller.newReturn(date, odometer, franchiseUnit, costumer, carRentalsRecords.getCar());

        System.out.println("Devolução registrada com sucesso.\n\n");
        System.out.println("------------------------------------------------------------------------");
        MainView mainView = new MainView();
        mainView.showView();
    }

    private Integer getOdometer() {
        System.out.println("Digite a nova kilometragem do carro: ");
        return scanner.nextInt();
    }

    private CarRentalsRecords getCurrentRent(Costumer costumer) {
        return controller.getCurrentRent(costumer);
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
        System.out.println("\nInsira o número da unidade em que o carro foi devolvido: ");
        return controller.getFranchiseUnit(scanner.nextInt());
    }

    private void showFranchiseUnits() {
        List<FranchiseUnit> franchiseUnits = controller.showFranchiseUnits();
        franchiseUnits.forEach(franchiseUnit -> System.out.println(franchiseUnit.getId() +
                " - " + franchiseUnit.getName()));
    }
}
