package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    private static ArrayList<Cheese> cheeses = new ArrayList<>();
    public static int nextId = 1;

    //getAll
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    //add
    public static void add(Cheese newCheese) {

        cheeses.add(newCheese);
        newCheese.setCheeseId(nextId);
        nextId++;
    }

    //remove
    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    //getById
    public static Cheese getById(int id) {
        Cheese theCheese = null;

        for(Cheese candidateCheese : cheeses) {
            if(candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }

}
