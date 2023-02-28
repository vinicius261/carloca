package br.com.carloca.view.dataquerysviews;

import br.com.carloca.controller.dataqueryscontrollers.DataQueryController;
import br.com.carloca.models.Car;
import br.com.carloca.models.CarReturnSpecifications;
import br.com.carloca.models.CarWithdrawalSpecifications;
import br.com.carloca.models.Costumer;
import br.com.carloca.view.MainView;
import br.com.carloca.view.registersviews.NewCostumerView;
import br.com.carloca.view.registersviews.NewRentView;
import br.com.carloca.view.registersviews.ReturnCarView;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Scanner;

public class DataQueryView {
    private DataQueryController controller;
    private Scanner scanner;
    public DataQueryView(){
        this.controller = new DataQueryController();
        this.scanner = new Scanner(System.in);
    }
    public void showView(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                CONSULTAS DE CARROS");

        showMenu();

        MainView mainView = new MainView();
        mainView.showView();
    }

    private void showMenu() {
        System.out.println("\n\nPara ver dados de um carro digite sua placa,\n" +
                "ou aperte qualquer tecla para listar os carros.");

        showCars(scanner.nextLine());

        System.out.println("------------------------------------------------------------------------");
    }

    private void showCars(String licensePlate) {
        Car wantedCar;

        try {
            wantedCar = controller.getCar(licensePlate);
        }catch (NoResultException ex){
            wantedCar = null;
        }

        while (wantedCar == null) {
            System.out.println("\n\nCarro não encontrado.\n\n");
            List<Car> cars = controller.getCars();

            cars.forEach(car -> System.out.println(car.getLicensePlate() + " - " +
                    car.getCarVersion().getCarModel().getName() + " - " + car.getCarVersion().getName()));

            System.out.println("Digite a placa do carro que deseja consultar: ");
            licensePlate = scanner.nextLine();
            wantedCar = controller.getCar(licensePlate);
        }

        showCarData(wantedCar);
    }

    private void showCarData(Car car) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                DADOS DO CARRO\n\n");

        System.out.println(car.getLicensePlate()+ "  -  "+ car.getCarVersion().getCarModel().getName()+
                "  -  " +car.getCarVersion().getName()+"\n\n");

        System.out.println("Kilometragem do carro: "+ car.getOdometer()+"\n\n");

        showCostumersPerCar(car);
    }

    private void showCostumersPerCar(Car car) {
        List<Costumer> costumers = controller.getCostumersPerCar(car);
        List<CarWithdrawalSpecifications> withdrawals = controller.getWithdrawalsPerCar(car);
        List<CarReturnSpecifications> returns = controller.getReturnsPerCar(car);


        for(int i = 0; i < costumers.size() ; i++){
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Cliente: " + costumers.get(i).getDocument() + " - " + costumers.get(i).getName());
            System.out.println("Local de retirada: " + withdrawals.get(i).getFranchiseUnit().getName());
            try{
                System.out.println("Local de devolução: " + returns.get(i).getFranchiseUnit().getName());
                System.out.println("Kilometragem rodada: " + controller.getKmPerRent(withdrawals.get(i), returns.get(i)));
            }catch (RuntimeException ex){
                System.out.println("Aguardando devolução.");
            }
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
}
