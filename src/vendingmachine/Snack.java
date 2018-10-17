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

    private String name;
    private String description;
    private Double price;
    private int calories;
    private int amt;

    /**
     * @author Bill Cui
     * @param newName name of the snack
     * @param newDes description of the snack
     * @param newPrice price of the snack
     * @param newCalories calories of the snack
     * @param newAmt amount of snacks available
     */
    public Snack(String newName,String newDes, double newPrice, int newCalories, int newAmt) {
        name = newName;
        description = newDes;
        price = newPrice;
        amt = newAmt;
        calories=newCalories;
    }
    
    /**
     * @author Bill Cui
     * new random snack
     */
    public Snack() {
        Snack temp = new Snack("","",0,0,0);
        temp=randomSnack();
        name = temp.name;
        description = temp.description;
        price = temp.price;
        amt = temp.amt;
        calories = temp.calories;
        
    }
    
    public Snack randomSnack(){
        
        Snack temp = new Snack("","",0,0,0);
        String[] snackNames = {"Mars","Snickers","O'Henry","Aero","Clif","Cheetos","Lay's","Doritos",
        "Cheetos","Quakers"};
        String[] snackDescriptions = {"Crunchy","Chewy","Sweet","Yummy","Yucky","Cool"};
        Random ran = new Random();
        temp.name=snackNames[ran.nextInt(snackNames.length)];
        temp.description=snackDescriptions[ran.nextInt(snackDescriptions.length)];
        temp.price=(double)ran.nextInt(20);
        temp.calories=ran.nextInt(2000);
        temp.amt=ran.nextInt(20);
        
        return temp;
    }
    
    
    
    
      /**
     * @param newName the name to set
     * @author Adi Venkatesh
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * @param newDes the description to set
     * @author Adi Venkatesh
     */
    public void setDescription(String newDes) {
        description = newDes;
    }

    /**
     * @param newAmt the amt to set
     * @author Adi Venkatesh
     */
    public void setAmt(int newAmt) {
        amt = newAmt;
    }

    /**
     * @return the amt
     * @author Bill Cui
     */
    public int getAmt() {
        return amt;
    }

/**
 * @author Bill Cui
 * @param add amount you are adding
 */
    public void addAmt(int add) {
        setAmt(amt + add);
    }

 /**
  * @author Bill Cui
  * @param rm amount you are removing
  */
    public void rmAmt(int rm) {
        setAmt(amt - rm);
    }

    /**
     * @return the name
     * @author Adi Venkatesh
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     * @author Adi Venkatesh
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the price
     * @author Bill Cui
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param newPrice the price to set
     * @author Bill Cui
     */
    public void setPrice(Double newPrice) {
        price = newPrice;
    }

    /**
     * @return the calories
     * @author Adi Venkatesh
     */
    public int getCalories() {
        return calories;
    }

    /**
     * @param newCalories the calories to set
     * @author Adi Venkatesh
     */
    public void setCalories(int newCalories) {
        calories = newCalories;
    }

  

}
