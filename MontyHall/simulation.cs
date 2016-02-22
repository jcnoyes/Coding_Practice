/********************************************************************
 * Simulation - runs the simulation of the game show used to calcul-*
 * ate the probability of winning with and without switching the    *
 * doors.                                                           *
 *******************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MontyHall
{
    class simulation
    {
        public bool runSimWithoutSwitching(int s)
        {
            //boolean to see if you won.
            bool win = false;
            randomNumberGen randGen = new randomNumberGen();

            //first pick the winning door, and user choice
            int winningDoor = randGen.getNumber(4, s);
            int userChoice = randGen.getNumber(4, s + s);

            if(winningDoor == userChoice)
            {
                win = true;
            }

            return win;
        }

        public bool runWithSwitching(int s)
        {
            bool win = false;
            randomNumberGen randGen = new randomNumberGen();

            //pick winning door
            int winningDoor = randGen.getNumber(4, s);
            int userChoice = randGen.getNumber(4, s + s);
            int doorShown = 0;

            List<int> losingDoors = new List<int>();

            //place losing doors in array, so Monte Hall will know them
            for(int i = 1; i < 4; i++)
            {
                if(i != winningDoor)
                {
                    losingDoors.Add(i);
                }
            }

            //Monte Hall displays a losing door
            if(userChoice == losingDoors[0])
            {
                //door shown = losingDoors[1]
                doorShown = losingDoors[1];
            }

            else
            {
                //door shown = losingDoor[0]
                doorShown = losingDoors[0];
            }

            //switch door to door that was not shown
            if(doorShown == 2 && userChoice == 1)
            {
                userChoice = 3;
            }
            else if(doorShown == 2 && userChoice == 3)
            {
                userChoice = 1;
            }
            else if(doorShown == 1 && userChoice == 2)
            {
                userChoice = 3;
            }
            else if(doorShown == 1 && userChoice == 3)
            {
                userChoice = 2;
            }
            else if(doorShown == 3 && userChoice == 1)
            {
                userChoice = 2;
            }
            else if(doorShown == 3 && userChoice == 2)
            {
                userChoice = 1;
            }

            //see if user won
            if(userChoice == winningDoor)
            {
                win = true;
            }

            return win;
        }
    }
}
