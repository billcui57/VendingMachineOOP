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
private int selectedSnck;
private int selectedDrnk;
    /**
     * @param args the command line arguments
     */
    
    //constructor
Change c;
public VendingMachine(int newBankAmt, int numSnacks,int numDrinks){
    bank = newBankAmt;
    c=new Change(bank);
    snacks = new Snack[numSnacks];
    drinks = new Drink[numDrinks];
    
    //initialze snacks in VM
    snacks[0]= new Snack("Snickers","chewy",2.50,150,10);
    snacks[1]= new Snack("Mars","chewy",2.50,200,10);
    snacks[2]= new Snack("Wonderbar","salty",2.50,300,10);
    snacks[3]= new Snack("KitKat","crunchy",2.50,150,10);
    snacks[4]= new Snack("Aero","sweet",2.50,150,10);
    snacks[5]= new Snack("Smarties","crunchy",2.50,100,10);
    snacks[6]= new Snack("Caramilk","salty",2.50,150,10);
    
    
}

//public int returnChange(){
////return ;
//} 
public Snack makeSelection(String selected){
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


