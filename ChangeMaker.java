/*
 * Program asks for a total amount the user owes and then the total amount that
 * they paid.  Then the program calculates what the user gets back in change and
 * what type of coins/dollar bills they get back.
 */
package changemaker;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Joseph Noyes
 */
public class ChangeMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initialize some variables
        double amountPaid = 0.0;
        double amountOwed = 0.0;
        boolean valid = false;
        boolean done = false;
        int restart = 1;
        List<String> coinList = new ArrayList();
        List<Double> coinValues = new ArrayList();
        List<Integer> numberOf = new ArrayList();
        Scanner reader = new Scanner(System.in);
        
        initializeLists(coinList, coinValues, numberOf);

        //greet the user and get the input
        System.out.println("Hello, welcome to the change maker program.");
        while (done == false) {
            while (valid == false) {
                System.out.print("\nPlease enter the amount you owe:  ");
                amountOwed = reader.nextDouble();

                System.out.print("Now enter the total amount you paid: ");
                amountPaid = reader.nextDouble();

                //check to see if user entered valid data
                if (amountPaid < amountOwed) {
                    valid = false;
                    System.out.println("\nInvaild data, please make sure the amount");
                    System.out.println("you paid is greater than the amount you owe.");
                    pressEnterToContinue();
                } //allow exit of while loop
                else {
                    valid = true;
                }
            }
            
            //call the function to do the math and bring the correct change back
            calculateChange(coinValues, numberOf, amountOwed, amountPaid);
            
            //call function to print the results
            printResults(numberOf, coinList);
            
            System.out.println("\nWould you like to restart? 1 yes, 2 no");
            restart = reader.nextInt();
            
            if(restart != 1)
            {
                done = true;
            }
            else{
                done = false;
                valid = false;
            }
            
        }

    }

    /**
     * Function to do a simple press enter to continue to allow the user to see
     * output and press enter when they are ready to begin execution again.
     */
    public static void pressEnterToContinue() {
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {

        }
    }
    
    /**
     * Function to initialize the coin names and values to their lists
     * @param coinNames - list that will hold the coin names
     * @param values - list that will hold the coin values4
     * @param numb - holds the number of coins of each type needed to make change
     */
    public static void initializeLists(List<String> coinNames, List<Double> values,
            List<Integer> numb)
    {
        //add coin/dollar bill names
        coinNames.add("pennies");
        coinNames.add("nickles");
        coinNames.add("dimes");
        coinNames.add("quarters");
        coinNames.add("one dollar bills");
        coinNames.add("five dollar bills");
        coinNames.add("ten dollar bills");
        coinNames.add("twenty dollar bills");
        
        //add the values
        values.add(0.01);
        values.add(0.05);
        values.add(0.10);
        values.add(0.25);
        values.add(1.00);
        values.add(5.00);
        values.add(10.00);
        values.add(20.00);
        
        //initialize number list to all 0's
        for(int i = 0; i < coinNames.size(); i++)
        {
            numb.add(0);
        }
    }
    /**
     * Function that calculates the amount of change owed, and how many of each
     * type of coin needs to be returned to the user.
     * @param values - values of each coin
     * @param number - number of coins returned to the user
     * @param total - amount the object costs
     * @param paid - amount the user paid
     */
    public static void calculateChange(List<Double> values, 
            List<Integer> number, double total, double paid)
    {
        //see how much change the user gets back
        double changeOwed = paid - total;
        changeOwed = Math.round(changeOwed * 100.0)/100.0;
        System.out.println("\nTotal change to give back: " + changeOwed + "\n");
        
        //use the greedy algorithm to get the best results, start with the
        //largest coin and end with the smallest.
        for(int i = values.size()-1; i >= 0; i--)
        {
            double currentValue = values.get(i);
            int iterator = 0;
            while(currentValue <= changeOwed)
            {
                changeOwed = changeOwed - currentValue;
                changeOwed = Math.round(changeOwed * 100.0)/100.0;
                iterator++;
            }
            
            //place the iterator (number of type of coin) in number.
            number.set(i, iterator);
        }
    }
    
    /**
     * Function that prints the results
     * @param number - Number of each coin type that was calculated
     * @param names - List of the names of each coin type
     */
    public static void printResults(List<Integer> number, List<String> names)
    {
        //for loop to print out each element
        for(int i = number.size()-1; i >=0;  i--)
        {
            System.out.println("Number of " + names.get(i) + " needed is " + 
                    number.get(i));
        }
    }
}
