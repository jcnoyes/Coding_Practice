/********************************************************************
 * random number generator used for the Monty Hall problem.  Gets a *
 * random number to use to select a door, the prizes, etc.  Tries   *
 * to be as random as possible by using different seeds.            *
 *******************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MontyHall
{
    class randomNumberGen
    {
        public int getNumber(int highValue, int s)
        {
            //have a random number generator used to choose doors
            Random rand = new Random(s);

            int random = rand.Next(1, highValue);
            return random;
        }
    }
}
