package br.com.carloca.util;

import br.com.carloca.exceptions.BooleanChoiceException;
import br.com.carloca.models.Costumer;

import javax.persistence.EntityManager;

public class Util {

    public void create(Object object, EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public int getMenuOption(String input){
        int option = 0;

        try{
            option = Integer.parseInt(input);
        }catch (NumberFormatException ex){
            option = 0;
        }

        return option;
    }

    public boolean getBoolean(String input){
        if(input.equalsIgnoreCase("s")){
            return true;
        } else if (input.equalsIgnoreCase("n")) {
            return false;
        }else{
            throw new BooleanChoiceException("Digite apenas 's' ou 'n'.");
        }
    }
}
