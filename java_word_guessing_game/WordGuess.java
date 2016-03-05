/*******************************************************************************
 * wordguess - a simple program that parses a file and obtains words that will *
 * be used in a simple console-based word guessing game.  The user will be able*
 * to have 5 wrong letter guesses.  After 5 wrong letter guesses, the game will*
 * end.                                                                        *
 ******************************************************************************/
package wordguess;

import java.io.IOException;

/**
 *
 * @author Joseph Noyes
 */
public class WordGuess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //start off by reading wordbank file
        FileReader FR = new FileReader();
        FR.readFile();
        
        //get an instance of the Game
        Game g = new Game();
        
        //greet the user
        System.out.println("Hello, and welcome to the word guessing game!");
        System.out.println("Press enter to continue...");
        try {
        System.in.read();
        } catch (IOException e) {

        }
        //start the loop for the game using boolean playing
        boolean playing = true;
        
        while(playing == true)
        {
            playing = g.playGame();
        }
        
        //display an exit
        System.out.println("Thanks for playing!");
    }
    
}
