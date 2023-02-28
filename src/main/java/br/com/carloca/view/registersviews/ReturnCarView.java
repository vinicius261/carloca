package br.com.carloca.view.registersviews;

import br.com.carloca.controller.registerscontrollers.ReturnCarController;
import br.com.carloca.exceptions.CostumerNotUsingCarException;
import br.com.carloca.exceptions.DateFormatException;
import br.com.carloca.models.*;
import br.com.carloca.view.MainView;

import javax.persistence.NoResultException;
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
        try{
            Costumer costumer = controller.getCostumer(document);

            CarRentalsRecords carRentalsRecords = getCurrentRent(costumer);

            LocalDate date = LocalDate.now();

            Integer odometer = getOdometer();

            FranchiseUnit franchiseUnit = getFranchiseUnit();

            controller.newReturn(date, odometer, franchiseUnit, costumer, carRentalsRecords.getCar());

            System.out.println("Devolução registrada com sucesso.\n\n");
            System.out.println("------------------------------------------------------------------------");
            MainView mainView = new MainView();
            mainView.showView();
        }catch (CostumerNotUsingCarException ex){
            System.out.println(ex.getMessage());
            NewRecordsView newRecordsView =  new NewRecordsView();
            newRecordsView.showView();
        }
    }

    private Integer getOdometer() {
        System.out.println("Digite a nova kilometragem do carro: ");
        return scanner.nextInt();
    }

    private CarRentalsRecords getCurrentRent(Costumer costumer) {
        try {
            controller.getCurrentRent(costumer);
        }catch (NoResultException ex){
            System.out.println("Cliente não está alugando carros.");
            NewRecordsView newRecordsView = new NewRecordsView();
            newRecordsView.showView();
        }
        return controller.getCurrentRent(costumer);
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
