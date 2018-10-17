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
    private double profit=0;
    private double expenses;
    /**
     * @param args the command line arguments
     */

    //constructor
    Change c;

    public VendingMachine(int newBankAmt, int numS, int numD) {
        numSnacks = numS;
        numDrinks = numD;
        bank = newBankAmt;
        c = new Change(bank);
        snacks = new Snack[numSnacks];
        drinks = new Drink[numDrinks];

        //initialze snacks in VM
        for (int i = 0; i < numSnacks; i++) {
            snacks[i] = new Snack();
        }

    }

//public int returnChange(){
////return ;
//} 
    public Snack makeSnackSelection(int index) {
        int snackIndex = 0;
        return snacks[index];
    }

    public void stockBank(double money) {

    }

    public void stockSnacks(Snack s, int qty) {
        s.addAmt(qty);
    }
//decrease quantity of snacks in storage
    public Change sellSnacks(Snack x, double payedAmt, int amt) {
            Change temp = new Change(payedAmt);
            temp.findChange(x.getPrice()*amt,payedAmt);
            bank += payedAmt;
            x.rmAmt(amt);
            profit+=payedAmt;
            return temp; 
            
    }
    
    public void buySnacks(Snack s, int amt){
        bank-=(s.getPrice()-1)*amt;
        expenses+=(s.getPrice()-1)*amt;
        s.addAmt(amt);
    }
            
    

}
