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
     * 
     * @param totalAmt the total amount of change
     */
    public Change(double totalAmt){
        
        toonies=(int)(totalAmt/2);
        totalAmt=totalAmt%2;
        loonies=(int)(totalAmt/1);
        totalAmt=totalAmt%1;
        quarters=(int)(totalAmt/0.25);
        totalAmt=totalAmt%0.25;
        dimes=(int)(totalAmt/0.1);
        totalAmt=totalAmt%0.1;
        nickels=(int)(totalAmt/0.05);
        
    }
    

    
    /**
     * 
     * @param amt amt of coin
     * @param type coin type
     */
    public void add(String type,int amt){
        switch(type){
            case "Toonie":
                toonies+=amt;
                break;
            case "Loonie":
                loonies+=amt;
                break;
            case "Quarter":
                quarters+=amt;
                break;
            case "Dime":
                dimes+=amt;
                break;
            case "Nickel":
                nickels+=amt;
                break;
        }
    }
    
    /**
     * 
     * @param type coin type
     */
    public void add(String type){
        add(type,1);
    }
    
    /**
     * 
     * @param amt amt of coin
     */
    public void add(Change amt){
        toonies+=amt.toonies;
        loonies+=amt.loonies;
        quarters+=amt.quarters;
        dimes+=amt.dimes;
        nickels+=amt.nickels;
    }
    
    
    public double getAmt(){
        return toonies*2+loonies*1+quarters*0.25+dimes*0.1+nickels*0.05;
    }
    
    /**
     * 
     * @param type coin type
     * @param amt amt of coin
     */
    public void remove(String type, int amt){
        add(type,amt*-1);
    }
    
    /**
     * 
     * @param amt amt of  coin
     */
    public void remove(double amt){
        Change temp = new Change(0);
        temp = denominate(amt);
        toonies-=temp.toonies;
        loonies-=temp.loonies;
        quarters-=temp.quarters;
        dimes-=temp.dimes;
        nickels-=temp.nickels;
    }
    
    public String toString(){
        String change = "Toonies: " + toonies +"\tLoonies: " + loonies + 
                "\tQuarters: " + quarters +"\tDimes: " + dimes +"\tNickels: " + nickels;
        
        return change;
    }
    
    public void empty(){
        toonies=0;
        loonies=0;
        quarters=0;
        dimes=0;
        nickels=0;
    }
    
    /**
     * 
     * @param amt amt of coin
     * @return temp
     */
    public Change denominate(double amt){
        Change temp = new Change(0);
        temp.toonies=(int)(amt/2);
        amt=amt%2;
        temp.loonies=(int)(amt/1);
        amt=amt%1;
        temp.quarters=(int)(amt/0.25);
        amt=amt%0.25;
        temp.dimes=(int)(amt/0.1);
        amt=amt%0.1;
        temp.nickels=(int)(amt/0.05);
        return temp;
    }
    
    /**
     * 
     * @param totalAmt 
     * @param givenAmt amt of change given by user
     * @return temp
     */
    public Change findChange(double totalAmt,double givenAmt){
        Change temp = new Change(0);
        temp = denominate(givenAmt-totalAmt);
        return temp;
    }
    
    
    
}
