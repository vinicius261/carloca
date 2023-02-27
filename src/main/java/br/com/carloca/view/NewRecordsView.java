package br.com.carloca.view;

import br.com.carloca.controller.CarRentalRecordsController;

import java.util.Scanner;

public class NewRecordsView {
    private CarRentalRecordsController controller;
    private Scanner scanner;

    public NewRecordsView(){
        this.controller = new CarRentalRecordsController();
        this.scanner = new Scanner(System.in);
    }
    public void showView() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                NOVO REGISTRO");

        showMenu();
    }

    private void showMenu() {
        System.out.println("\n\nDigite o número da opção desejada: \n\n1 - Novo aluguel\n2 - Novo carro" +
                "\n\nOu qualquer tecla para voltar ao menu anterior.");
        System.out.println("------------------------------------------------------------------------");

        int menuOption = controller.getMenuOption(scanner.nextLine());

        if(menuOption == 1){
            CarRentalRecordsView carRentalRecordsView = new CarRentalRecordsView();
            carRentalRecordsView.showView();

        } else if (menuOption == 2) {
            NewCarView newCarView = new NewCarView();
            newCarView.showView();

        }else {
            MainView mainView = new MainView();
            mainView.showView();
        }
    }
}
