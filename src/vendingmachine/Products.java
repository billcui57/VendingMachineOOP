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
public interface Products {
    public int getAmt();
    
    public void addAmt(int add);
    
    public void rmAmt(int rm);
    
    
    public String getName();
    
    public String getDescription();
    
    public Double getPrice();
    
    public void setPrice(Double newPrice);
}
