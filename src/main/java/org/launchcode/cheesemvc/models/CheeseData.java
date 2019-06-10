package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

//this class handles storage and access to our data - won't use with databases
public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<Cheese>(); //creates a new list

    //getAll
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    //add
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    //remove
    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id); //uses method to remove cheese by id and not name
        cheeses.remove(cheeseToRemove);
    }


    //getById
    public static Cheese getById(int id) {
        Cheese theCheese = null; //initializes the var to return null if nothing is found

        for (Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }
        return theCheese; //returning Cheese obj
    }

}
