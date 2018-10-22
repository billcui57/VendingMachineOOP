/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 * This throws an exception when the vending machine has an issue with snacks or
 * drinks
 *
 * @author Bill Cui
 */
public class VendingMachineExceptions extends Exception {

    /**
     * @param message the user receives when a problem is encountered
     */
    public VendingMachineExceptions(String message) {
        super(message);
    }

}
