/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Fiona
 */
public class VendingMachine {
Snack[] snacks;
Drink[] drinks;
public int bank;
public int moneyIn;
    /**
     * @param args the command line arguments
     */
    
    //constructor
Change c;
public void VendingMachine(int newBankAmt, int numSnacks,int numDrinks){
    bank = newBankAmt;
    c=new Change(bank);
    snacks = new Snack[numSnacks];
    drinks = new Drink[numDrinks];
    
}

public int returnChange(){

}
public void makeSelection(){
    
}
public void insertMoney(int amt){
    bank+=amt;
}
public void stockBank(double money){
    
}

public void stockSnacks(Snack s, int qty){
    s.addAmt(qty);
}

}


