package org.launchcode.cheesemvc.models;

import java.util.HashMap;

public class Cheese {

    private static String name;
    private static String description;
    private static HashMap<String, String> cheeses = new HashMap<>();

    public static HashMap<String, String> getCheeseList(){
        return cheeses;
    }

    public static void setTheCheese(String cheeseName, String cheeseDesc) {
        name = cheeseName;
        description = cheeseDesc;
        cheeses.put(name, description);
    }
    public static void removeThatCheese(String cheese) {
        cheeses.remove(cheese);
    }
}
