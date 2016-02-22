/********************************************************************
 * Console interface for Monty Hall Program.  Directly interacts    *
 * With the user.                                                   *
 *******************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MontyHall
{
    class consoleInterface
    {
        //implemented as a singleton
        private static consoleInterface singleton = null;
        private string stars =
        "**************************************************";

        //private constructor
        private consoleInterface()
        {

        }

        public static consoleInterface getInterface()
        {
            if (singleton == null)
            {
                singleton = new consoleInterface();
            }

            return singleton;
        }

        //function to explain to the user what the program is about
        public void displayWelcome()
        {
            Console.WriteLine("Welcome to the Monty Hall Problem!");
            Console.WriteLine(stars);
            Console.WriteLine("This program simulates the Monty Hall Problem from ");
            Console.Write("the game show Let's Make a Deal!\n");
            Console.WriteLine(stars);
            consoleInterface.pressEnterToContinue();
        }

        /*function to display information about doing the simulation
         * without switching the doors */
        public void startWithoutSwitching()
        {
            Console.WriteLine("Starting simulation without switching doors");
            Console.WriteLine("Running 10000 times...");
            Console.WriteLine(stars);
        }

        public void startWithSiwtching()
        {
            Console.WriteLine("Starting simulation with switching doors");
            Console.WriteLine("Running 10000 times...");
            Console.WriteLine(stars);
        }

        public void resultsWithoutSwitching(int winnings, double ratio)
        {
            Console.WriteLine("Results for not switching:");
            Console.WriteLine(stars);
            Console.WriteLine("Number of winnings: " + winnings);
            Console.WriteLine("Winning ratio = " + ratio);

            //press enter to continue
            pressEnterToContinue();
        }

        public void resultsWithSwitching(int winnings, double ratio)
        {
            Console.WriteLine("Results for switching:");
            Console.WriteLine(stars);
            Console.WriteLine("Number of winnings: " + winnings);
            Console.WriteLine("Winning ratio = " + ratio);

            //press enter to continue
            pressEnterToContinue();
        }

        public bool compareRatio(double noSwitch, double withSwitch)
        {
            bool continueExecution = false;
            Console.WriteLine("Ratio without switching doors: " + noSwitch);
            Console.WriteLine("Ratio with switching doors:    " + withSwitch);
            Console.WriteLine(stars);

            //asks user if they want to contine
            Console.WriteLine("Would you like to run the simulation again?");
            Console.Write("1 = yes, anything else = no: ");
            String userInput = Console.ReadLine();

            //clear the screen
            Console.Clear();

            //convert string to number
            if(userInput == "")
            {
                userInput = "0";
            }
            int input = Convert.ToInt32(userInput);

            if(input == 1)
            {
                continueExecution = true;
            }

            return continueExecution;
        }

        /*function that makes the user press enter to continue before
        * program continues execution. */
        private static void pressEnterToContinue()
        {
            Console.WriteLine("Press enter to continue...");
            Console.ReadKey();
            Console.Clear();
        }
    }
}
