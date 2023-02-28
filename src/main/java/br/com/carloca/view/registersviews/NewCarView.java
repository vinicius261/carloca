package br.com.carloca.view.registersviews;

import br.com.carloca.controller.NewCarController;
import br.com.carloca.enums.CarColors;
import br.com.carloca.models.*;
import br.com.carloca.util.Util;

import java.util.Scanner;

public class NewCarView {
    private NewCarController controller;
    private Scanner scanner;

    public NewCarView(){
        this.controller = new NewCarController();
        this.scanner = new Scanner(System.in);
    }
    public void showView() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                NOVO CARRO");

        newCar();
    }

    private void newCar() {
        Brand brand = getBrand();

        Category category = getCategory();

        CarModel carModel = getCarModel(brand, category);

        String versionName = getVersionName();

        String motorization = getMotorization();

        System.out.println("Para as próximas perguntas digite 's' se carro tiver ou 'n' caso não tenha o opcional: ");

        boolean airConditioning = getOptionals(scanner.nextLine());
        boolean hydraulicStreering = getOptionals(scanner.nextLine());
        boolean airbag = getOptionals(scanner.nextLine());


        CarVersion carVersion = new CarVersion(versionName, carModel, motorization,
                airConditioning, hydraulicStreering, airbag);

        System.out.println("Digite a placa do carro: ");
        String licensePlate = scanner.nextLine();

        CarColors carColor = colorChoice();

        System.out.println("Digite a kilometragem do carro: ");
        Integer odometer = controller.getKm();

        Car car = new Car(licensePlate, carVersion, carColor, false, odometer);

        controller.newCar(car);

        System.out.println("Carro cadastrado com sucesso");
    }

    public boolean getOptionals(String input){
        Util util = new Util();
        return util.getBoolean(scanner.nextLine());
    }
    private String getMotorization() {
        System.out.println("Digite a motorização do carro: ");
        String motorization = scanner.nextLine();
        return motorization;
    }

    private String getVersionName() {
        System.out.println("Digite a versão do carro: ");
        String versionName = scanner.nextLine();
        return versionName;
    }

    private CarModel getCarModel(Brand brand, Category category) {
        System.out.println("Digite o modelo do carro: ");
        CarModel carModel = new CarModel(scanner.nextLine(), category, brand);
        return carModel;
    }

    private Category getCategory() {
        System.out.println("Digite a categoria do carro: ");
        Category category = new Category(scanner.nextLine());
        return category;
    }

    private Brand getBrand() {
        System.out.println("Digite a marca do carro: ");
        Brand brand = new Brand(scanner.nextLine());
        return brand;
    }

    private CarColors colorChoice() {
        CarColors carColor;
        System.out.println("Se o carro for branco digite 'w', se for prata digite 's', se for preto 'b': ");
        switch (scanner.nextLine()){
            case "w":
                return CarColors.WHITE;
            case "s":
                return CarColors.SILVER;
            case "b":
                return CarColors.BLACK;
            default:
                System.out.println("Escolha uma cor válida");
                 carColor = colorChoice();
        }
        return carColor;
    }
}
