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
    public Change sell(Snack x, double payedAmt) {
            Change temp = new Change(payedAmt);
            temp.findChange(x.getPrice(),payedAmt);
            bank += payedAmt;
            x.rmAmt(1);
            profit+=payedAmt;
            return temp; 
        
    }
    

}
