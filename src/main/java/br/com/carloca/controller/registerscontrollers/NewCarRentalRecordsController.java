package br.com.carloca.controller.registerscontrollers;

import br.com.carloca.util.Util;

public class NewCarRentalRecordsController {
    private Util util;

    public NewCarRentalRecordsController(){
        this.util = new Util();
    }
    public int getMenuOption(String input) {
        return util.getMenuOption(input);
    }
}
