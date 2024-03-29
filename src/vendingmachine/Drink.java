/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.Random;

/**
 *
 * @author Adi Venkatesh
 */
public class Drink extends Snack implements Products {

    private int volume;

    /**
     * Constructor for specified drink
     * @param newName name of the drink
     * @param newDes description of the drink
     * @param newPrice price of the drink
     * @param newCalories calories of the drink
     * @param newAmt amount of drinks available
     * @param newVolume volume of the drink
     */
    public Drink(String newName, String newDes, Double newPrice, int newCalories, int newAmt, int newVolume) {
        super(newName, newDes, newPrice, newCalories, newAmt);
        volume = newVolume;
    }

    /**
     * 
     * Creates a random drink
     * @param i
     */
    public Drink(int i) {
        //new random drink
        Drink temp = new Drink("", "", 0.0, 0, 0, 0);
        //creates a random drink with random attributes
        temp = temp.randomDrink(i);
        name = temp.name;
        description = temp.description;
        price = temp.price;
        amt = temp.amt;
        calories = temp.calories;

    }

    /**
     * Creating random values for the variety names, descriptions, etc.
     *
     * @return temp, temporary drink variable to store values
     */
    public Drink randomDrink(int index) {
        Drink temp = new Drink("", "", 0.0, 0, 0, 0);
        //selects from an array of names and descriptions to create random attributes 
        String drinkNames[] = {"Coca Cola", "Sprite", "Nestea", "Canada Dry", "Mug", "Fanta",
            "Diet Coca Cola", "Diet Sprite", "Diet Nestea", "Diet Canada Dry", "Diet Mug",
            "Diet Fanta"};
        String drinkDescriptions[] = {"tastes sweet", "tastes like lemon", "tastes like tea",
            "tastes like ginger", "tastes like toothpaste", "tastes like orange", "tastes sweet",
            "tastes like lemon", "tastes like tea", "tastes like ginger", "tastes like toothpaste",
            "tastes like orange"};
        Random ran = new Random();
        temp.name = drinkNames[index];
        temp.description = drinkDescriptions[ran.nextInt(drinkDescriptions.length)];
        temp.price = (double) ran.nextInt(20) + 1;
        temp.calories = ran.nextInt(2000) + 1;
        temp.amt = 20;

        return temp;
    }

    /**
     * Getter for Volume
     *
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Setter for newVolume
     *
     * @param newVolume the volume to set
     */
    public void setVolume(int newVolume) {
        volume = newVolume;
    }

}
