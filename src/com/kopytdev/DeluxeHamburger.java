package com.kopytdev;

import java.util.LinkedHashMap;

public class DeluxeHamburger extends Burger {
    private LinkedHashMap<String, Double> availableAdditions;
    public DeluxeHamburger(String breadRollType, double basePrice) {
        super(breadRollType, basePrice, "Deluxe Hamburger", 2);
        this.availableAdditions = super.getAvailableAdditions();
        pickAdditions();
    }

    public void pickAdditions() {
        availableAdditions.put("chips", 4.0);
        availableAdditions.put("drinks", 4.0);
        super.pickAdditions("chips", "drinks");
        availableAdditions.remove("chips", 4.0);
        availableAdditions.remove("drinks", 4.0);
    }

    public LinkedHashMap<String, Double> getAvailableAdditions() {
        return availableAdditions;
    }
}