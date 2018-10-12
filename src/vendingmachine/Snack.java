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
    
    public Snack(String newName,String newDes,Double newPrice){
        name= newName;
        description = newDes;
        price=newPrice;
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
