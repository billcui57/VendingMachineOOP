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
 * @author Adi Venkatesh & Bill Cui
 */
public class Display {

    /**
     * Display in order for users to use the vending machine, and to test the
     * machine
     *
     * @param args for the main method
     * @throws vendingmachine.ChangeExceptions
     */
    public static void main(String[] args) throws ChangeExceptions {

        boolean loop;
        int index;
        int amt;
        double paidAmt;
        Change change;
        do {
            DecimalFormat money = new DecimalFormat("$0.00");
            VendingMachine machine = new VendingMachine(1000, 7, 7);
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to Vendobot, want to buy a drink or snack?(d/s)");
            System.out.println(machine.getBank());
            System.out.println(machine.bank.getLoonies());
            loop = false;
            switch (input.next()) {
                case "d":
                    //lists all the drinks
                    listDrinks(machine);
                    System.out.println("Enter in drink index to purchase");
                    //selects drink with entered index
                    index = input.nextInt() - 1;
                    double drinkPrint = machine.getDrink(index).price;
                    System.out.println("Selected " + machine.getDrink(index).name
                            + "\nPrice is " + money.format(drinkPrint)
                            + "\nHow many would you like to buy?");
                    amt = input.nextInt();
                    System.out.println("Your total is " + money.format(drinkPrint * amt) + "\nPlease pay");
                    paidAmt = input.nextDouble();
                    change = machine.sell(machine.getDrink(index), paidAmt, amt);
                    if (machine.successfulTransaction) {
                        System.out.println("Your change is " + change.toString());
                        caloriesComment(machine.getDrink(index).calories * amt);
                    } else {
                        System.out.println("Please try again!");
                        loop = true;
                    }
                    break;
                case "s":
                    listSnacks(machine);
                    System.out.println("Enter in snack index to purchase");
                    index = input.nextInt() - 1;
                    double snackPrint = machine.getSnack(index).price;
                    System.out.println("Selected " + machine.getSnack(index).name
                            + "\nPrice is " + money.format(snackPrint)
                            + "\nHow many would you like to buy?");
                    amt = input.nextInt();
                    System.out.println("Your total is " + money.format(snackPrint * amt) + "\nPlease pay");
                    paidAmt = input.nextDouble();
                    change = machine.sell(machine.getSnack(index), paidAmt, amt);
                    if (machine.successfulTransaction) {
                        System.out.println("Your change is " + change.toString());
                        caloriesComment(machine.getSnack(index).calories * amt);
                    } else {
                        System.out.println("Please try again!");
                        loop = true;
                    }
                    break;
                default:
                    loop = true;
                    break;
            }
            
        } while (loop);

    }

//    public static void main(String[] args) {
//        VendingMachine machine = new VendingMachine(1000,7,7);
//        Scanner input = new Scanner(System.in);
//        System.out.println("Press 1 to buy snacks, Press 2 to buy drinks");
//        
//        
//        int choice = input.nextInt();
//       
//        switch (choice) {
//            case 1:
//                {
//                    System.out.println("Welcome to Vendobot");
//                    listSnacks(machine);
//                    System.out.println("Enter in snack index to purchase");
//                    int index = input.nextInt()-1;
//                    System.out.println("Selected "+ machine.getSnack(index).name +
//                            "\nPrice is $"+machine.getSnack(index).price+
//                            "\nHow many would you like to buy?");
//                    int amt = input.nextInt();
//                    System.out.println("Your total is $"+(machine.getSnack(index).price * amt));
//                    Change change =  machine.sell(machine.getSnack(index),input.nextDouble(), amt);
//                    System.out.println("Your change is " + change.toString());
//                    break;
//                }
//            case 2:
//                System.out.println("Welcome to Vendobot");
//                listDrinks(machine);
//                System.out.println("Enter in drink index to purchase");
//                int index = input.nextInt()-1;
//                System.out.println("Selected "+ machine.getDrink(index).name +
//                        "\nPrice is $"+machine.getDrink(index).price+
//                        "\nHow many would you like to buy?");
//                int amt = input.nextInt();
//                System.out.println("Your total is $"+(machine.getDrink(index).price * amt));
//                Change change =  machine.sell(machine.getDrink(index),input.nextDouble(), amt);
//                System.out.println("Your change is " + change.toString());
//                break;
//            default:
//                System.out.println("Incorrect input, please try again");
//                System.out.println("Press 1 to buy snacks, Press 2 to buy drinks");
//                choice = input.nextInt();
//                break;
//        } 
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
    /**
     * @author Adi Venkatisgh
     * List of all the snacks in the vending machine that are available
     *
     * @param machine instance of VendingMachine
     */
    public static void listSnacks(VendingMachine machine) {
        //lists all the snacks
        System.out.println("Snack Index \t Snack Name \t Snack Description");
        for (int i = 0; i < machine.numSnacks; i++) {
            System.out.println((i + 1) + "\t\t" + machine.getSnack(i).getName() + "\t\t" + machine.getSnack(i).getDescription());
        }
    }

    /**
     * Comment when a person buys a snack or drink in a certain calorie range,
     * from healthy to unhealthy
     *
     * @param calories amt of calories
     */
    public static void caloriesComment(double calories) {
        if (calories < 500) {
            System.out.println("Healthy Snack!");
        } else if ((calories < 1000) && (calories >= 500)) {
            System.out.println("Take it easy on the snacking!");
        } else {
            System.out.println("Don't get shot by a harpoon after that snack!");
        }
    }

//    public static void listDrinks(VendingMachine machine){
//        System.out.println("Drink Index \t Drink Name \t Drink Description");
//        for(int i = 0; i <machine.numDrinks; i++){
//            System.out.println((i+1) + "\t\t" + machine.getDrink(i).getName() + "\t\t" + machine.getDrink(i).getDescription());
//        }
//    }
    /**
     * List of all the drinks in the vending machine that are available
     *
     * @param machine instance of VendingMachine
     */
    public static void listDrinks(VendingMachine machine) {
        System.out.println("Drink Index \t Drink Name \t Drink Description");
        for (int i = 0; i < machine.numDrinks; i++) {
            System.out.println((i + 1) + "\t\t" + machine.getDrink(i).getName() + "\t\t" + machine.getDrink(i).getDescription());
        }
    }

}
