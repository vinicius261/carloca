package br.com.carloca.controller;

import br.com.carloca.util.Util;

public class CarRentalRecordsController {
    private Util util;

    public CarRentalRecordsController(){
        this.util = new Util();
    }
    public int getMenuOption(String input) {
        return util.getMenuOption(input);
    }
}
