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
class Snack {
    private String name;
    private String description;
    private Double price;
    private int amt;
    
    public Snack(String newName,String newDes,Double newPrice,int newAmt){
        name= newName;
        description = newDes;
        price=newPrice;
        amt=newAmt;
    }
    
    
    public int getAmt(){
        return amt;
    }
    
    public void addAmt(int add){
        amt+=add;
    }
    
    public void rmAmt(int rm){
        amt-=rm;
    }
    
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public void setPrice(Double newPrice){
        price = newPrice;
    }
    
    
    
}
