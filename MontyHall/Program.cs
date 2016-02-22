/********************************************************************
 * Monty Hall Problem Simulation - Program uses random numbers to   *
 * pick doors, one with a prize, two with goats.  The computer      *
 * chooses one of the three, one with a goat is revealed, program   *
 * will run simulations of switching to the one that wasn't revealed*
 * and not switching.  Should show that the probability of winning  *
 * from switching is 2/3 and not switching is only 1/3.             *
 *******************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MontyHall
{
    class Program
    {
        //main program, starts here
        static void Main(string[] args)
        {
            bool win = false;
            bool continueExecution = true;
            int numberOfWinnings = 0;
            simulation sim = new simulation();
            randomNumberGen rg = new randomNumberGen();

            //get the consoleInterface, display welcome screen
            consoleInterface ic = consoleInterface.getInterface();
            ic.displayWelcome();

            //conitnue while user wants to
            while (continueExecution == true)
            {
                numberOfWinnings = 0;
                //start simulation of not switching doors
                ic.startWithoutSwitching();

                for (int i = 0; i < 10000; i++)
                {
                    int seed = rg.getNumber(100, i + Environment.TickCount);
                    win = sim.runSimWithoutSwitching(seed);

                    if (win == true)
                    {
                        numberOfWinnings += 1;
                    }

                }

                //calculate ratio which should be around 1/3
                double withoutSwitchingRatio = numberOfWinnings / 10000.0;

                //Displays results and resets numberOfWinnings variable
                ic.resultsWithoutSwitching(numberOfWinnings, withoutSwitchingRatio);
                numberOfWinnings = 0;

                //start simulation with switching
                ic.startWithSiwtching();

                for (int i = 0; i < 10000; i++)
                {
                    int seed = rg.getNumber(100, i + Environment.TickCount);
                    win = sim.runWithSwitching(seed);

                    if (win == true)
                    {
                        numberOfWinnings += 1;
                    }
                }

                //calculate ratio which should be around 2/3
                double withSwitchingRatio = numberOfWinnings / 10000.0;

                //Displays results
                ic.resultsWithSwitching(numberOfWinnings, withSwitchingRatio);
                continueExecution = ic.compareRatio(withoutSwitchingRatio, withSwitchingRatio);
            }
        }
    }
}
