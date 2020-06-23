package com.kopytDev;

public class Hamburger extends Burger {

    public Hamburger(String breadRollType) {
        super(breadRollType);
    }

    public Hamburger(String breadRollType, double basePrice) {
        super(breadRollType, basePrice, "Hamburger", 4);
    }
}