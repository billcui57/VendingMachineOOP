/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Bill Cui
 */
public interface Products {
    public int getAmt();
    
    /**
     * Vending machine needs to have an addAmt
     * @param add amount you are adding
     * @throws vendingmachine.VendingMachineExceptions 
     */
    public void addAmt(int add)throws VendingMachineExceptions;
    
    /**
     * Vending machine needs to have a rmAmt
     * @param rm amount you are removing
     * @throws vendingmachine.VendingMachineExceptions
     */
    public void rmAmt(int rm)throws VendingMachineExceptions;
    
    
    /**
     * Getter for name
     * @return name
     */
    public String getName();
    
    /**
     * Getter for description
     * @return description
     */
    public String getDescription();
    
    /**
     * Getter for price
     * @return price
     */
    public Double getPrice();
    
    /**
     * Setter for price
     * @param newPrice Setter for newPrice
     */
    public void setPrice(Double newPrice);
    
    
    //The reason why there were no setters for name and description is that snack names and descriptions are concrete,
    //to have diff name is to create a new snack
}
