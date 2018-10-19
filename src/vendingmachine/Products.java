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
    
    public void addAmt(int add)throws VendingMachineExceptions;
    
    public void rmAmt(int rm)throws VendingMachineExceptions;
    
    
    public String getName();
    
    public String getDescription();
    
    public Double getPrice();
    
    public void setPrice(Double newPrice);
}
