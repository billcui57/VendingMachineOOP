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
    
   
    protected int numSnacks;
    protected int numDrinks;


 

    public boolean successfulTransaction=true;
    private double profits=0;
    private double expenses=0;
    Change bank;
    

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
        
        bank = new Change(newBankAmt);
        snacks = new Snack[numSnacks];
        drinks = new Drink[numDrinks];

        //initialze snacks in VM
        for (int i = 0; i < numSnacks; i++) {
            snacks[i] = new Snack(i);
            drinks[i] = new Drink(i);
            
        }
        
    }

    /**
     * This method returns the snack being chosen for purchase
     * @param index the position of the snack in the array
     * @return the name of snack being purchased
     */
    public Snack getSnack(int index) {
        return snacks[index];
    }
    
        /**
     * This method returns the drink being chosen for purchase
     * @param index the position of the drink in the array
     * @return the name of drink being purchased
     */
    public Drink getDrink(int index) {
        return drinks[index];
    }

    
    /**
     * Gets bank amt
     * @return bank 
     */
    public Change getBank(){
        return bank;
    }
    
    /**
     * This method adds money to the bank
     * @param money the value being added to bank
     */
    public void stockBank(Change money) {
        bank.add(money);
    }
    
    /**
     * Add 1 of money type to bank
     * @param type coin type
     * @throws ChangeExceptions for removing too much
     */
    public void stockBank(String type) throws ChangeExceptions {
        bank.add(type);
    }
    
    /**
     * Add any amt of money type to bank
     * @param type coin type
     * @param amt amt of coin
     * @throws ChangeExceptions for removing too much 
     */
    public void stockBank(String type, int amt) throws ChangeExceptions{
        bank.add(type, amt);
    }
/**
 * This method adds updated the stock in VM
 * @param s the specific snack being added to VM
 * @param qty the amount of the snack being added to VM
 */
    public void stock(Snack s, int qty) throws VendingMachineExceptions {
        s.addAmt(qty);
    }
    
    /**
 * This overload method adds the updated stock in VM
 * @param s the specific drink being added to VM
 * @param qty the amount of the drink being added to VM
 */
    public void stock(Drink s, int qty) throws VendingMachineExceptions {
        s.addAmt(qty);
    }
    /**
     * This method decreases the quantity of snacks in storage through selling it
     * @param x the snack being purchased
     * @param payedAmt the money payed to VM
     * @param amt the amount of snack being bought
     * @return returns the change due to the customer
     */
    public Change sell(Snack x, double payedAmt, int amt) throws ChangeExceptions {
            Change temp = new Change(0);
            //finds change due
            temp=temp.findChange(x.getPrice()*amt,payedAmt);
            //adds given amt to bank
            bank.add(bank.denominate(payedAmt));
            //removes change due from bank (can throw change exception from removing coin type that is already at amt 0)
            bank.remove(temp);
            
            //removes stock with error handling (prevents removing already empty snack)
            try{
            x.rmAmt(amt);
            }catch(VendingMachineExceptions e){
                successfulTransaction=false;
                System.out.println(e.getMessage());
            }
            //adds to profit
            profits+=(payedAmt-temp.toDouble());
            return temp; 
            
    }
        /**
     * This overload method decreases the quantity of drinks in storage
     * @param x the drink being purchased
     * @param payedAmt the money payed to VM
     * @param amt the amount of drinks being bought
     * @return returns the change due to the customer
     */
    
    public Change sell(Drink x, double payedAmt, int amt) throws ChangeExceptions {
            Change temp = new Change(0);
            temp=temp.findChange(x.getPrice()*amt,payedAmt);
            bank.add(bank.denominate(payedAmt));
            //same commenting as overloaded method
            bank.remove(temp);
            
            try{
            x.rmAmt(amt);
            }catch(VendingMachineExceptions e){
                successfulTransaction=false;
                System.out.println(e.getMessage());
            }
            profits+=(payedAmt-temp.toDouble());
            return temp; 
            
    }
    /**
     * This method updates the bank after buying snacks to fill the VM 
     * 
     * @param s this is the snacks being bought
     * @param amt the amount of snacks being bought
     */
    public void buy(Snack s, int amt) throws VendingMachineExceptions, ChangeExceptions{
        //removes money from bank and adds to expenses
        bank.remove((s.getPrice()-1)*amt);
        expenses+=(s.getPrice()-1)*amt;
        this.stock(s, amt);
    }
    
       /**
     * This overload method updates the bank after buying drinks to fill the VM 
     * 
     * @param s this is the drinks being bought
     * @param amt the amount of drinks being bought
     */
    public void buy(Drink s, int amt) throws VendingMachineExceptions, ChangeExceptions{
        bank.remove((s.getPrice()-1)*amt);
        expenses+=(s.getPrice()-1)*amt;
        this.stock(s, amt);
    }
    /**
     * Gets income that the vending machine brings in
     * @return the result of the net income formula
     */       
    public double getNetIncome(){
        //returns the net income
        return profits-expenses;
    }
    

}
