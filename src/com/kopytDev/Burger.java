package com.company;

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

    public Burgers(String breadRollType) {
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

    public Burgers(String breadRollType, double basePrice, String name, int maxAdditions) {
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

    public double getBasePrice() {
        return basePrice;
    }

    private void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    private void setFinalPrice(double price) {
        finalPrice += price;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
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

    public void pickAdditions(String... args) {
        try {
            if (args.length <= maxAdditions) {
                for (String pickedItem : args) {
                    if (availableAdditions.containsKey(pickedItem)) {
                        pickedAdditions.put(pickedItem.toLowerCase(), availableAdditions.get(pickedItem.toLowerCase()));
                        finalPrice += availableAdditions.get(pickedItem);
                    } else {
                        System.out.printf("Item \"%s\" not found.%n", pickedItem);
                    }
                }
            } else {
                System.out.println("Too many items picked!");
            }
        } catch (NullPointerException e) {
            System.out.println("Line " + e.getStackTrace()[0].getLineNumber() + " caused an error, check input");
        }
    }

    public void removeAdditions(String... args) {
        try {
            for (String pickedItem : args) {
                if (pickedAdditions.size() > 0) {
                    if (availableAdditions.containsKey(pickedItem)) {
                        pickedAdditions.remove(pickedItem.toLowerCase(), availableAdditions.get(pickedItem.toLowerCase()));
                        finalPrice -= availableAdditions.get(pickedItem);
                    } else {
                        System.out.printf("Item \"%s\" not found.%n", pickedItem);
                    }
                } else {
                    System.out.println("Cannot remove an addition, since none are added.");
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Line " + e.getStackTrace()[0].getLineNumber() + " caused an error, check input");
        }
    }
}
