package com.kopytDev;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Burger {
    private static LinkedHashMap<String, Double> availableAdditions = new LinkedHashMap<>();
    private LinkedHashMap<String, Double> pickedAdditions = new LinkedHashMap<>();
    private String breadRollType;
    private String meat;
    private double basePrice;
    private int maxAdditions;
    private double finalPrice;
    private String name;

    public Burger(String breadRollType) {
        this.name = "Just a burger";
        this.breadRollType = breadRollType;
        this.meat = "Beef";
        this.maxAdditions = 4;
        this.basePrice = 8;
        this.finalPrice = basePrice;

        String[] items = {"lettuce", "tomato", "cucumber", "corn", "peas", "onion rings", "gherkins", "onions"};
        double[] prices = {1.0, 1.5, 1.5, 1.5, 2.0, 3.0, 2.0, 1.0};

        for (int i = 0; i < items.length; i++) {
            availableAdditions.put(items[i], prices[i]);
        }
    }

    public Burger(String breadRollType, double basePrice, String name, int maxAdditions) {
        this(breadRollType);
        this.name = name;
        this.maxAdditions = maxAdditions;
        this.basePrice = basePrice;
        this.finalPrice = basePrice;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    private void setBreadRollType(String breadRollType) {
        this.breadRollType = breadRollType;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getName() {
        return name;
    }

    public LinkedHashMap<String, Double> getAvailableAdditions() {
        return availableAdditions;
    }

    public int getMaxAdditions() {
        return maxAdditions;
    }

    public LinkedHashMap<String, Double> getPickedAdditions() {
        return pickedAdditions;
    }

    public void printPickedAdditions() {
        if (pickedAdditions.size() == 0) {
            System.out.println("No additions picked.");
        } else {
            for (Map.Entry<String, Double> stringDoubleEntry : pickedAdditions.entrySet()) {
                try {
                    String setKey = stringDoubleEntry.getKey();
                    double setValue = stringDoubleEntry.getValue();
                    System.out.println(setKey + " : " + setValue);

                } catch (NullPointerException e) {
                    System.out.printf("Line %d caused an error check input.", e.getStackTrace()[0].getLineNumber());
                }
            }
        }
    }

    public void printFinalPrice() {

        System.out.println("Base price is " + this.basePrice + ", you picked: ");
        printPickedAdditions();
        System.out.println(". . . which totals at: " + finalPrice);
    }

    public void pickAdditions(String @NotNull ... args) {
        if (pickedAdditions.size() + args.length <= maxAdditions) {
            for (String pickedItem : args) {
                if (availableAdditions.containsKey(pickedItem)) {
                    pickedAdditions.put(pickedItem.toLowerCase(), availableAdditions.get(pickedItem.toLowerCase()));
                    finalPrice += availableAdditions.get(pickedItem);
                } else {
                    System.out.printf("Item \"%s\" not found.%n", pickedItem);
                }
            }
        } else {
            System.out.printf("Too many items picked, please remove %d item(s).%n",
                    pickedAdditions.size() - args.length + maxAdditions);
        }
    }

    public void removeAdditions(String @NotNull ... args) {
        if (pickedAdditions.size() > 0) {
            if (pickedAdditions.size() - args.length >= 0) {
                for (String pickedItem : args) {
                    if (availableAdditions.containsKey(pickedItem)) {
                        pickedAdditions.remove(pickedItem.toLowerCase(), availableAdditions.get(pickedItem.toLowerCase()));
                        finalPrice -= availableAdditions.get(pickedItem);
                    } else {
                        System.out.printf("Item \"%s\" not found.%n", pickedItem);
                    }
                }
            } else {
                System.out.printf("Only %d addition(s) picked, cannot remove %d.%n", pickedAdditions.size(), args.length);
            }
        } else {
            System.out.println("Cannot remove any additions, since none are added.");
        }
    }
}
