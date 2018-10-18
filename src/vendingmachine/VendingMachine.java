/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Fiona Whitfield
 */
public class VendingMachine {

    private Snack[] snacks;
    private Drink[] drinks;
    public int bank;
    public int moneyIn;
    public int numSnacks;
    public int numDrinks;
    private int selectedSnck;
    private int selectedDrnk;
    private double profit=0;
    private double expenses;
    Change c;
    

    //constructor
    /**
     * This constructor takes in the bank value and the number of products
     * and initializes them in the VM
     * @param newBankAmt the updated amount of money in the bank
     * @param numS the number of snacks in the vending machine
     * @param numD the number of drinks in the vending machine
     */
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

    /**
     * This method returns the snack being chosen for purchase
     * @param index the position of the snack in the array
     * @return the name of snack being purchased
     */
    public Snack makeSnackSelection(int index) {
        return snacks[index];
    }
    
        /**
     * This method returns the drink being chosen for purchase
     * @param index the position of the drink in the array
     * @return the name of drink being purchased
     */
    public Drink makeDrinkSelection(int index) {
        return drinks[index];
    }

    /**
     * This method adds the VM money to the bank
     * @param money the value being added to bank
     */
    public void stockBank(double money) {
bank+=money;
    }
/**
 * This method adds updated the stock in VM
 * @param s the specific snack being added to VM
 * @param qty the amount of the snack being added to VM
 */
    public void stockSnacks(Snack s, int qty) {
        s.addAmt(qty);
    }
    
    /**
 * This method adds updated the stock in VM
 * @param s the specific drink being added to VM
 * @param qty the amount of the drink being added to VM
 */
    public void stockDrinks(Drink s, int qty) {
        s.addAmt(qty);
    }
    /**
     * This method decreases the quantity of snacks in storage
     * @param x the snack being purchased
     * @param payedAmt the money payed to VM
     * @param amt the amount of snack being bought
     * @return returns the change due to the customer
     */
    public Change sellSnacks(Snack x, double payedAmt, int amt) {
            Change temp = new Change(0);
            temp=temp.findChange(x.getPrice()*amt,payedAmt);
            bank += payedAmt;
            x.rmAmt(amt);
            profit+=payedAmt;
            return temp; 
            
    }
        /**
     * This method decreases the quantity of drinks in storage
     * @param x the drink being purchased
     * @param payedAmt the money payed to VM
     * @param amt the amount of drinks being bought
     * @return returns the change due to the customer
     */
    public Change sellDrinks(Drink x, double payedAmt, int amt) {
            Change temp = new Change(0);
            temp=temp.findChange(x.getPrice()*amt,payedAmt);
            bank += payedAmt;
            x.rmAmt(amt);
            profit+=payedAmt;
            return temp; 
            
    }
    /**
     * This method updates the bank after buying snacks to fill the VM 
     * 
     * @param s this is the snacks being bought
     * @param amt the amount of snacks being bought
     */
    public void buySnacks(Snack s, int amt){
        bank-=(s.getPrice()-1)*amt;
        expenses+=(s.getPrice()-1)*amt;
        s.addAmt(amt);
    }
    
       /**
     * This method updates the bank after buying drinks to fill the VM 
     * 
     * @param s this is the drinks being bought
     * @param amt the amount of drinks being bought
     */
    public void buyDrinks(Drink s, int amt){
        bank-=(s.getPrice()-1)*amt;
        expenses+=(s.getPrice()-1)*amt;
        s.addAmt(amt);
    }
            
    

}
