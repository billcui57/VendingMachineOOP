/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author 348848128
 */
class Snack implements Products {

    private String name;
    private String description;
    private Double price;
    private int calories;
    private int amt;

    public Snack(String newName, String newDes, Double newPrice, int newCalories, int newAmt) {
        name = newName;
        description = newDes;
        price = newPrice;
        amt = newAmt;
    }
    
      /**
     * @param newName the name to set
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * @param newDes the description to set
     */
    public void setDescription(String newDes) {
        description = newDes;
    }

    /**
     * @param newAmt the amt to set
     */
    public void setAmt(int newAmt) {
        amt = newAmt;
    }

    /**
     * @return the amt
     */
    public int getAmt() {
        return amt;
    }


    public void addAmt(int add) {
        setAmt(amt + add);
    }

    public void rmAmt(int rm) {
        setAmt(amt - rm);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param newPrice the price to set
     */
    public void setPrice(Double newPrice) {
        price = newPrice;
    }

    /**
     * @return the calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * @param newCalories the calories to set
     */
    public void setCalories(int newCalories) {
        calories = newCalories;
    }

  

}
