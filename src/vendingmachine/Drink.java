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
public class Drink extends Snack implements Products{

    int volume;
    public Drink(String newName, String newDes, Double newPrice, int newAmt, int newVolume) {
        super(newName, newDes, newPrice, newAmt);
        volume = newVolume;
    }
    
    
    
    
    
    
    
}
