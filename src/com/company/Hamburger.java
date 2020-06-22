package com.company;

public class Hamburger extends Burgers {

    public Hamburger(String breadRollType) {
        super(breadRollType);
    }

    public Hamburger(String breadRollType, double basePrice) {
        super(breadRollType, basePrice, "Hamburger", 4);
    }
}