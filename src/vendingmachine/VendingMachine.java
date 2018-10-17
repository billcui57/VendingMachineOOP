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
public int numSnacks;
public int numDrinks;
private int selectedSnck;
private int selectedDrnk;
    /**
     * @param args the command line arguments
     */
    
    //constructor
Change c;
public VendingMachine(int newBankAmt, int numS,int numD){
    numSnacks=numS;
    numDrinks=numD;
    bank = newBankAmt;
    c=new Change(bank);
    snacks = new Snack[numSnacks];
    drinks = new Drink[numDrinks];
    
    
    //initialze snacks in VM
    for(int i=0;i<numSnacks;i++){
        snacks[i]=new Snack();
    }
    
    
}



//public int returnChange(){
////return ;
//} 
public Snack makeSnackSelection(String selected){
    int snackIndex=0;
    switch(selected){
        case "Snickers":
            snackIndex=0;
            break;
            case "Mars":
                snackIndex=1;
            break;
            case "Wonderbar":
                snackIndex=2;
            break;
            case "KitKat":
                snackIndex=3;
            break;
            case "Aero":
                snackIndex=4;
            break;
            case "Smarties":
                snackIndex=5;
            break;
            case "Caramilk":
                snackIndex=6;
            break;

            
    } 
    return snacks[snackIndex];
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


