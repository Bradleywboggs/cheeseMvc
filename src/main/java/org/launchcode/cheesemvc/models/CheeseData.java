package org.launchcode.cheesemvc.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CheeseData {
    public static void add(ArrayList<Cheese> cheeses, Cheese newCheese, String cheeseName, String cheeseDescription) {
        newCheese = new Cheese(cheeseName, cheeseDescription);
        cheeses.add(newCheese);
    }

    public static void remove(ArrayList<Cheese> cheeseList, ArrayList<Cheese> cheeses) {
        for (Cheese cheese : cheeseList) {
            for (int i = 0; i < cheeses.size(); i++) {
                if (cheeses.get(i).getName().equals(cheese.getName())) {
                    cheeses.remove(cheeses.get(i));
                }
            }
        }
    }
}
