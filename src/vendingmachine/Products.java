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
    
    
    public String getName();
    
    public String getDescription();
    
    public Double getPrice();
    
    /**
     * @param newPrice Setter for newPrice
     */
    public void setPrice(Double newPrice);
}
