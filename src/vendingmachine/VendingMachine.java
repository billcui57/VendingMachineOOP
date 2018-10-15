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
Snack[] snacks = new Snack[10];
public int bank;
public int moneyIn;
public int[] snackQty;
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        // TODO code application logic here
        for(int i=0;i<snacks.length;i++){
            
        }
    }
    //constructor
public void VendingMachine(){
    
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


