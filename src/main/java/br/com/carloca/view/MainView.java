package br.com.carloca.view;

import br.com.carloca.controller.MainController;

import java.util.Scanner;

public class MainView {
    private MainController controller;
    private Scanner scanner;

    public MainView(){
        this.controller = new MainController();
        this.scanner = new Scanner(System.in);
    }

    public void showView(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                SISTEMA DE LOCAÇÃO DE CARROS");

        showMenu();

    }

    private void showMenu() {
        System.out.println("\n\nDigite a opção desejada: \n\n1 - Novo registro\n2 - Consultas\n");
        System.out.println("------------------------------------------------------------------------");
       
        int menuOption = controller.getMenuOption(scanner.nextLine());
        
        if(menuOption == 1){
            NewRecordsView newRecordsView = new NewRecordsView();
            newRecordsView.showView();

        } else if (menuOption == 2) {
            DataQueryView dataQueryView = new DataQueryView();
            dataQueryView.showView();

        }else {
            System.out.println("Escolha um número válido.\n");
            showMenu();
        }
    }

}
