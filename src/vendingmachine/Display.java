/*


 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Adi Venkatesh
 */
public class Display {

    DecimalFormat f = new DecimalFormat("#0.00");

    public static void main(String[] args) throws ChangeExceptions {
        
        boolean loop;
        int index;
        int amt;
        double paidAmt;
        Change change;
        do {
            VendingMachine machine = new VendingMachine(1000, 7, 7);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vendobot, want to buy a drink or snack?(d/s)");
            loop=false;
            switch (input.next()) {
                case "d":
                    listDrinks(machine);
                    System.out.println("Enter in drink index to purchase");
                    index = input.nextInt() - 1;
                     System.out.println("Selected " + machine.getDrink(index).name
                            + "\nPrice is $" + machine.getDrink(index).price
                            + "\nHow many would you like to buy?");
                     amt = input.nextInt();
                    System.out.println("Your total is $" + (machine.getDrink(index).price * amt) +"\nPlease pay" );
                   
                    paidAmt = input.nextDouble();
                    change = machine.sell(machine.getDrink(index), paidAmt, amt);
                    if (machine.successfulTransaction) {
                        System.out.println("Your change is " + change.toString());
                    } else {
                        System.out.println("Please try again!");
                        loop=true;
                    }
                    break;
                case "s":
                    listSnacks(machine);
                    System.out.println("Enter in snack index to purchase");
                    index = input.nextInt() - 1;
                    System.out.println("Selected " + machine.getSnack(index).name
                            + "\nPrice is $" + machine.getSnack(index).price
                            + "\nHow many would you like to buy?");
                    amt = input.nextInt();
                    System.out.println("Your total is $" + (machine.getSnack(index).price * amt) +"\nPlease pay");
                    paidAmt = input.nextDouble();
                   change = machine.sell(machine.getSnack(index), paidAmt, amt);
                    if (machine.successfulTransaction) {
                        System.out.println("Your change is " + change.toString());
                    } else {
                        System.out.println("Please try again!");
                        loop=true;
                    }
                    break;
                default:
                    loop = true;
                    break;
            }
        } while (loop);

    }

//    public static void CashorCoins(Scanner i){
//        boolean cycle;
//        
//        do{
//            cycle=true;
//            switch(i.nextLine()){
//                case "cash":
//                    System.out.println("cash");
//                    break;
//                case "coins":
//                    System.out.println("coins");
//                    break;
//            }
//        }while(cycle==true);
//    }
    
    
    
    public static void listSnacks(VendingMachine machine) {
        System.out.println("Snack Index \t Snack Name \t Snack Description");
        for (int i = 0; i < machine.numSnacks; i++) {
            System.out.println((i + 1) + "\t\t" + machine.getSnack(i).getName() + "\t\t" + machine.getSnack(i).getDescription());
        }
    }
    
    public static void listDrinks(VendingMachine machine){
        System.out.println("Drink Index \t Drink Name \t Drink Description");
        for (int i = 0; i < machine.numDrinks; i++) {
            System.out.println((i + 1) + "\t\t" + machine.getDrink(i).getName() + "\t\t" + machine.getDrink(i).getDescription());
        }
    }

}
