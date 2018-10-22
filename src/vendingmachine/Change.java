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
    

    public int getToonies(){
        return toonies;
    }
    
    public int getLoonies(){
        return loonies;
    }
    
    public int getQuarters(){
        return quarters;
    }
    
    public int getDimes(){
        return dimes;
    }
    
    public int getNickels(){
        return nickels;
    }
    
    public double toDouble(){
        return toonies*2+loonies*1+quarters*0.25+dimes*0.1+nickels*0.05;
    }
    
    /**
     * 
     * @param amt amt of coin
     * @param type coin type
     */
    public void add(String type,int amt) throws ChangeExceptions{
        switch(type){
            case "Toonie":
                if(toonies+amt>=0){
                toonies+=amt;
                }else{
                     throw new ChangeExceptions("Not enough toonies!");
                }
                break;
            case "Loonie":
                if(loonies+amt>=0){
                loonies+=amt;
                }else{
                     throw new ChangeExceptions("Not enough loonies!");
                }
                break;
            case "Quarter":
                if(quarters+amt>=0){
                quarters+=amt;
                }else{
                     throw new ChangeExceptions("Not enough quarters!");
                }
                break;
            case "Dime":
                if(dimes+amt>=0){
                dimes+=amt;
                }else{
                     throw new ChangeExceptions("Not enough dimes!");
                }
                break;
            case "Nickel":
                if(nickels+amt>=0){
                nickels+=amt;
                }else{
                     throw new ChangeExceptions("Not enough nickels!");
                }
                break;
        }
    }
    
    /**
     * 
     * @param type coin type
     */
    public void add(String type) throws ChangeExceptions{
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
    public void remove(String type, int amt) throws ChangeExceptions{
        add(type,amt*-1);
    }
    
    /**
     * 
     * @param amt amt of  coin
     */
    public void remove(double amt) throws ChangeExceptions{
        Change temp = new Change(0);
        temp = denominate(amt);
        this.remove(temp);
    }
    
    public void remove(Change amt) throws ChangeExceptions{
        
        if(toonies-amt.toonies<0){
            throw new ChangeExceptions("Not enough toonies!");
        }else if(loonies-amt.loonies<0){
            throw new ChangeExceptions("Not enough loonies!");
        }else if(quarters-amt.quarters<0){
            throw new ChangeExceptions("Not enough quarters!");
        }else if(dimes-amt.dimes<0){
            throw new ChangeExceptions("Not enough dimes!");
        }else if(nickels-amt.nickels<0){
            throw new ChangeExceptions("Not enough nickels!");
        }else{
            toonies-=amt.toonies;
        loonies-=amt.loonies;
        quarters-=amt.quarters;
        dimes-=amt.dimes;
        nickels-=amt.nickels;
        }
        
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
    public Change findChange(double totalAmt,double givenAmt) throws ChangeExceptions{
        
        if(givenAmt<totalAmt){
            throw new ChangeExceptions("Did not pay enough!");
        }else{
        Change temp = new Change(0);
        temp = denominate(givenAmt-totalAmt);
        return temp;
        }
    }
    
    
    
    
}
