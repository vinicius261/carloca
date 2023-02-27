package br.com.carloca.view;

import br.com.carloca.controller.NewCostumerController;
import br.com.carloca.models.Costumer;

import java.util.Scanner;

public class NewCostumerView {
    private NewCostumerController controller;
    private Scanner scanner;

    public NewCostumerView(){
        this.controller = new NewCostumerController();
        this.scanner = new Scanner(System.in);
    }
    public void showView(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                NOVO CLIENTE");

        registerCostumer();

    }

    private void registerCostumer() {

        String name = getName();

        String document = getDocument();

        String zipcode = getZipcode();

        String street = getStreet();

        String complement = getComplement();

        Costumer costumer = controller.registerCostumer(name, document, zipcode, street, complement);

        System.out.println("\nCliente cadastrado com sucesso, redirecionando para NOVO ALUGUEL\n");
        System.out.println("------------------------------------------------------------------------\n");

        NewRentView newRentView = new NewRentView();
        newRentView.showView(costumer.getDocument());
    }

    private String getComplement() {
        System.out.println("\n\nDigite o complemento ou deixe em branco:\n");
        String complement = scanner.nextLine();
        return complement;
    }

    private String getStreet() {
        System.out.println("\n\nDigite a rua:\n");
        String street = scanner.nextLine();
        return street;
    }

    private String getZipcode() {
        System.out.println("\n\nDigite o CEP:\n");
        String zipcode = scanner.nextLine();
        return zipcode;
    }

    private String getDocument() {
        System.out.println("\n\nDigite o documento:\n");
        String document = scanner.nextLine();
        return document;
    }

    private String getName() {
        System.out.println("\n\nDigite o nome:\n");
        String name = scanner.nextLine();
        return name;
    }
}
