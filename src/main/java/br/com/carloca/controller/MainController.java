package br.com.carloca.controller;

import br.com.carloca.util.Util;

public class MainController {
    private Util util;

    public MainController(){
        this.util = new Util();
    }
    public int getMenuOption(String input) {
        return util.getMenuOption(input);
    }
}
