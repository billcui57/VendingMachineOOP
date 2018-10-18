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
public class Drink extends Snack implements Products{
 
    private int volume;
    /**
     * 
     * @param newName name  of the drink
     * @param newDes description of the drink
     * @param newPrice price of the drink
     * @param newCalories calories of the drink
     * @param newAmt amount of drinks available
     * @param newVolume volume of the drink
     */
    public Drink(String newName, String newDes, Double newPrice, int newCalories, int newAmt, int newVolume) {
        super(newName, newDes, newPrice, newAmt, newCalories);
        volume = newVolume;
    }
    
    
    public Drink(){
        Drink temp = new Drink("", "", 0.0, 0, 0, 0);
        temp.randomDrink();
        name = temp.name;
        description = temp.description;
        price = temp.price;
        amt = temp.amt;
        calories = temp.calories;
        
    }
    
    
    public Drink randomDrink(){
        Drink temp = new Drink("", "", 0.0, 0, 0, 0);
        String drinkNames[] = {"Coca Cola", "Sprite", "Nestea", "Canada Dry", "Mug", "Fanta",
            "Diet Coca Cola", "Diet Sprite", "Diet Nestea", "Diet Canada Dry", "Diet Mug",
            "Diet Fanta"};
        String drinkDescriptions[] = {"tastes sweet", "tastes like lemon", "tastes like tea",
            "tastes like ginger", "tastes like toothpaste", "tastes like orange", "tastes sweet", 
            "tastes like lemon", "tastes like tea", "tastes like ginger", "tastes like toothpaste", 
            "tastes like orange"};
                Random ran = new Random();
        temp.name=drinkNames[ran.nextInt(drinkNames.length)];
        temp.description=drinkDescriptions[ran.nextInt(drinkDescriptions.length)];
        temp.price=(double)ran.nextInt(20);
        temp.calories=ran.nextInt(2000);
        temp.amt=ran.nextInt(20);
        
        return temp;
    }
    
    
    
    
    
    
    
}
