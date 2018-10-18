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
    
    
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(1000,7,7);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vendobot");
        listSnacks(machine);
        System.out.println("Enter in snack index to purchase");
        int index = input.nextInt()-1;
        System.out.println("Selected "+ machine.getSnack(index).name + 
                "\nPrice is $"+machine.getSnack(index).price+
                "\nHow many would you like to buy?");
        int amt = input.nextInt();
        System.out.println("Your total is $"+(machine.getSnack(index).price * amt));
        Change change =  machine.sell(machine.getSnack(index),input.nextDouble(), amt);
        System.out.println("Your change is " + change.toString());
        
    }

    public static void listSnacks(VendingMachine machine) {
        System.out.println("Snack Index \t Snack Name \t Snack Description" );
        for (int i = 0; i < machine.numSnacks; i++) {
            System.out.println((i + 1) + "\t\t" + machine.getSnack(i).getName() + "\t\t" + machine.getSnack(i).getDescription());
        }

    }

    

}
