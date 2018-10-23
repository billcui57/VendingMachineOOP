/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.Random;

/**
 *
 * @author Bill Cui, Adi Venkatesh
 */
class Snack implements Products {

    protected String name;
    protected String description;
    protected Double price;
    protected int calories;
    protected int amt;

    /**
     * Constructor for set snack 
     * @author Bill Cui
     * @param newName name of the snack
     * @param newDes description of the snack
     * @param newPrice price of the snack
     * @param newCalories calories of the snack
     * @param newAmt amount of snacks available
     */
    public Snack(String newName, String newDes, double newPrice, int newCalories, int newAmt) {
        name = newName;
        description = newDes;
        price = newPrice;
        amt = newAmt;
        calories = newCalories;
    }

    /**new random snack
     * Constructor for random snack
     * @author Bill Cui 
     */
    public Snack(int i) {
        //creates a random temp snack and pastes it to new snack
        Snack temp = new Snack("", "", 0, 0, 0);
        temp = temp.randomSnack(i);
        name = temp.name;
        description = temp.description;
        price = temp.price;
        amt = temp.amt;
        calories = temp.calories;

    }
    
    public Snack(){
        
    }

    /**
     * Creating random values for the variety names, descriptions, etc.
     *@author Bill Cui
     * @return temp, temporary variable to store values
     */
    public Snack randomSnack(int index) {

        //Creates a random snack with random attributes
        Snack temp = new Snack("", "", 0, 0, 0);
        String[] snackNames = {"Mars", "Snickers", "O'Henry", "Aero", "Clif", "Cheetos", "Lay's", "Doritos",
            "Cheetos", "Quakers"};
        String[] snackDescriptions = {"Crunchy", "Chewy", "Sweet", "Yummy", "Yucky", "Cool"};
        Random ran = new Random();
        temp.name = snackNames[index];
        temp.description = snackDescriptions[ran.nextInt(snackDescriptions.length)];
        temp.price = (double) ran.nextInt(20) + 1;
        temp.calories = ran.nextInt(2000) + 1;
        temp.amt = 20;

        return temp;
    }

    /**
     * Setter for newName
     * 
     * @param newName the name to set
     * @author Adi Venkatesh
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Setter for newDes
     *
     * @param newDes the description to set
     * @author Adi Venkatesh
     */
    public void setDescription(String newDes) {
        description = newDes;
    }

    /**
     * Setter for newAmt
     *
     * @param newAmt the amt to set
     * @author Adi Venkatesh
     */
    public void setAmt(int newAmt) {
        amt = newAmt;
    }

    /**
     * Getter for amt
     *
     * @return the amt
     * @author Bill Cui
     */
    public int getAmt() {
        return amt;
    }

    /**
     * Adds amount of that snack with error handling
     * @author Bill Cui
     * @param add amount you are adding
     * @throws vendingmachine.VendingMachineExceptions
     */
   
    public void addAmt(int add) throws VendingMachineExceptions {
        if ((amt + add) > 100) {
            throw new VendingMachineExceptions("Overstocked on " + name + "!");
        } else {
            setAmt(amt + add);
        }
    }

    /**
     * Removes amount of that snack
     * @author Bill Cui
     * @param rm amount you are removing
     * @throws vendingmachine.VendingMachineExceptions
     */
  
    public void rmAmt(int rm) throws VendingMachineExceptions {
        if (amt - rm < 0) {
            throw new VendingMachineExceptions("Not enough of " + name + " in stock!");
        } else {
            System.out.println("hi");
            setAmt(amt - rm);
        }

    }

    /**
     * Getter for name
     *
     * @return the name
     * @author Adi Venkatesh
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for description
     *
     * @return the description
     * @author Adi Venkatesh
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for price
     *
     * @return the price
     * @author Bill Cui
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setter for newPrice
     *
     * @param newPrice the price to set
     * @author Bill Cui
     */
    public void setPrice(Double newPrice) {
        price = newPrice;
    }

    /**
     * Getter for calories
     *
     * @return the calories
     * @author Adi Venkatesh
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Setter for newCalories
     *
     * @param newCalories the calories to set
     * @author Adi Venkatesh
     */
    public void setCalories(int newCalories) {
        calories = newCalories;
    }

}
