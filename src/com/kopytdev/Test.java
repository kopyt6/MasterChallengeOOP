package com.kopytdev;

public class Test {
    public static void main(String[] args) {

        Hamburger burger1 = new Hamburger("Brown");
        burger1.pickAdditions("lettuce", "tomato");
        System.out.println(burger1.getName());
        System.out.println(burger1.getPickedAdditions());
        System.out.println();

        HealthyBurger hb = new HealthyBurger(8);
        hb.pickAdditions("lettuce", "tomato", "gherkins", "corn", "onions");
        hb.printFinalPrice();
        System.out.println(hb.getName());

        DeluxeHamburger deluxeHamburger = new DeluxeHamburger("White", 8);
        deluxeHamburger.printPickedAdditions();
        System.out.println(deluxeHamburger.getName());

        Hamburger burger = new Hamburger("White", 8);
        burger.pickAdditions("lettuce", "tomato", "onion rings");
        burger.printPickedAdditions();

        burger.removeAdditions("onion rings", "lettuce", "tomato");
        System.out.println("Picked additions: ");
        burger.printPickedAdditions();
        System.out.println("*****************");
        burger.pickAdditions("gherkins");
        System.out.println("Picked additions: ");

        burger.pickAdditions("cucumber", "peas", "onion rings", "lettuce");
        burger.removeAdditions("cucumber", "peas");
        burger.printPickedAdditions();
    }
}
