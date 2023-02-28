package br.com.carloca.view.registersviews;

import br.com.carloca.controller.NewCarRentalRecordsController;

import java.util.Scanner;

public class CarRentalRecordsView {
    private NewCarRentalRecordsController controller;
    private Scanner scanner;

    public CarRentalRecordsView(){
        this.controller = new NewCarRentalRecordsController();
        this.scanner = new Scanner(System.in);
    }
    public void showView(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                   LOCAÇÃO");

        showMenu();

    }

    private void showMenu() {
        System.out.println("\n\nDigite a opção desejada: \n\n1 - Novo cliente\n2 - Cliente cadastrado\n3 - Devolução");
        System.out.println("------------------------------------------------------------------------");

        int menuOption = controller.getMenuOption(scanner.nextLine());

        if(menuOption == 1){
            NewCostumerView newCostumerView = new NewCostumerView();
            newCostumerView.showView();

        }else if (menuOption == 2) {
            System.out.println("\nDigite o documento do cliente: ");
            NewRentView newRentView = new NewRentView();
            newRentView.showView(scanner.nextLine());
        }else if (menuOption == 3) {
            System.out.println("\nDigite o documento do cliente: ");
            ReturnCarView returnCarView = new ReturnCarView();
            returnCarView.showView(scanner.nextLine());

        }else {
            System.out.println("Escolha um número válido.\n");
            showMenu();
        }
    }
}
