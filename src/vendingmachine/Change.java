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
public class Change {

    private int toonies;
    private int loonies;
    private int quarters;
    private int dimes;
    private int nickels;

    /**
     * Constructor for change
     *
     * @param totalAmt the total amount of change
     */
    public Change(double totalAmt) {

        toonies = (int) (totalAmt / 2);
        totalAmt = totalAmt % 2;
        loonies = (int) (totalAmt / 1);
        totalAmt = totalAmt % 1;
        quarters = (int) (totalAmt / 0.25);
        totalAmt = totalAmt % 0.25;
        dimes = (int) (totalAmt / 0.1);
        totalAmt = totalAmt % 0.1;
        nickels = (int) (totalAmt / 0.05);

    }

    /**
     * Getter for Toonies
     *
     * @return amount of toonies
     */
    public int getToonies() {
        return toonies;
    }

    /**
     * Getter for Loonies
     *
     * @return amount of loonies
     */
    public int getLoonies() {
        return loonies;
    }

    /**
     * Getter for Quarters
     *
     * @return amount of quarters
     */
    public int getQuarters() {
        return quarters;
    }

    /**
     * Getter for Dimes
     *
     * @return amount of dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * Getter for Nickels
     *
     * @return amount of nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * Turns the amount of coins into actual monetary values
     *
     * @return a double of the sum of the amount of coins multiplied by their
     * monetary value
     */
    public double toDouble() {
        return toonies * 2 + loonies * 1 + quarters * 0.25 + dimes * 0.1 + nickels * 0.05;
    }

    /**
     * Adds change
     *
     * @param amt amt of coin
     * @param type coin type
     * @throws vendingmachine.ChangeExceptions
     */
    public void add(String type, int amt) throws ChangeExceptions {
        switch (type) {
            case "Toonie":
                if (toonies + amt >= 0) {
                    toonies += amt;
                } else {
                    throw new ChangeExceptions("Not enough toonies!");
                }
                break;
            case "Loonie":
                if (loonies + amt >= 0) {
                    loonies += amt;
                } else {
                    throw new ChangeExceptions("Not enough loonies!");
                }
                break;
            case "Quarter":
                if (quarters + amt >= 0) {
                    quarters += amt;
                } else {
                    throw new ChangeExceptions("Not enough quarters!");
                }
                break;
            case "Dime":
                if (dimes + amt >= 0) {
                    dimes += amt;
                } else {
                    throw new ChangeExceptions("Not enough dimes!");
                }
                break;
            case "Nickel":
                if (nickels + amt >= 0) {
                    nickels += amt;
                } else {
                    throw new ChangeExceptions("Not enough nickels!");
                }
                break;
        }
    }

    /**
     * Adds 1 of 1 coin type 
     *
     * @param type coin type
     * @throws vendingmachine.ChangeExceptions
     */
    public void add(String type) throws ChangeExceptions {
        add(type, 1);
    }

    /**
     * Adds amt to coin type
     *
     * @param amt amt of coin
     */
    public void add(Change amt) {
        
        toonies += amt.toonies;
        loonies += amt.loonies;
        quarters += amt.quarters;
        dimes += amt.dimes;
        nickels += amt.nickels;
    }

    

    /**
     * Remove change from set coin type and amt
     *
     * @param type coin type
     * @param amt amt of coin
     * @throws vendingmachine.ChangeExceptions prevents having negative number of coins
     */
    public void remove(String type, int amt) throws ChangeExceptions {
        //inverse of add method
        add(type, amt * -1);
    }

    /**
     * Remove change from double
     *
     * @param amt amt of coin
     * @throws vendingmachine.ChangeExceptions prevents having negative number of coins
     */
    public void remove(double amt) throws ChangeExceptions {
        //denominates double and subtracts
        Change temp = new Change(0);
        temp = denominate(amt);
        this.remove(temp);
    }

    /**
     * Remove change from change
     *
     * @param amt amt of coin
     * @throws vendingmachine.ChangeExceptions
     */
    public void remove(Change amt) throws ChangeExceptions {
        //prevents removing too much
        if (toonies - amt.toonies < 0) {
            throw new ChangeExceptions("Not enough toonies!");
        } else if (loonies - amt.loonies < 0) {
            throw new ChangeExceptions("Not enough loonies!");
        } else if (quarters - amt.quarters < 0) {
            throw new ChangeExceptions("Not enough quarters!");
        } else if (dimes - amt.dimes < 0) {
            throw new ChangeExceptions("Not enough dimes!");
        } else if (nickels - amt.nickels < 0) {
            throw new ChangeExceptions("Not enough nickels!");
        } else {
            toonies -= amt.toonies;
            loonies -= amt.loonies;
            quarters -= amt.quarters;
            dimes -= amt.dimes;
            nickels -= amt.nickels;
        }

    }

    /**
     * Converts the change into a string so it is readable
     *
     * @return change value as a string so it can be shown to the user
     */
    public String toString() {
        String change = "Toonies: " + toonies + "\tLoonies: " + loonies
                + "\tQuarters: " + quarters + "\tDimes: " + dimes + "\tNickels: " + nickels;

        return change;
    }

    /**
     * Empty vending machine bank
     */
    public void empty() {
        //sets all to 0
        toonies = 0;
        loonies = 0;
        quarters = 0;
        dimes = 0;
        nickels = 0;
    }

    /**
     * Denominates change
     *
     * @param amt amt of coin
     * @return temp temporary variable for storing values
     */
    public Change denominate(double amt) {
        //denominates change
        Change temp = new Change(0);
        temp.toonies = (int) (amt / 2);
        amt = amt % 2;
        temp.loonies = (int) (amt / 1);
        amt = amt % 1;
        temp.quarters = (int) (amt / 0.25);
        amt = amt % 0.25;
        temp.dimes = (int) (amt / 0.1);
        amt = amt % 0.1;
        temp.nickels = (int) (amt / 0.05);
        return temp;
    }

    /**
     * Finds Change, given vs. total amt of change
     *
     * @param totalAmt the total amount of change
     * @param givenAmt amt of change given by user
     * @throws vendingmachine.ChangeExceptions
     * @return temp temporary variable for storing values
     */
    public Change findChange(double totalAmt, double givenAmt) throws ChangeExceptions {
        //error handling for entering not enough
        if (givenAmt < totalAmt) {
            throw new ChangeExceptions("Did not pay enough!");
        } else {
            //finds change
            Change temp = new Change(0);
            temp = denominate(givenAmt - totalAmt);
            
            return temp;
        }
    }

}
