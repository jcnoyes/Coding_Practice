/**
 * *****************************************************************************
 * Game - the main game in which the user plays. Displays _ for each letter, *
 * allows the user to guess each letter and allows for 5 wrong letters. *
 * ****************************************************************************
 */
package wordguess;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Joseph Noyes
 */
public class Game {

    boolean playGame() {
        //variables needed
        boolean keepPlaying = true;
        boolean canGuess = true;
        boolean gameOver = false;
        boolean won = false;
        Scanner reader = new Scanner(System.in);
        int numbOfGuesses = 5;

        //list of letter guesses
        String letterGuesses = null;

        //obtain the dictionary
        Dictionary wordBank = Dictionary.getDictionary();
        int wordCount = wordBank.getWC();

        //make a random number between 0 and word count - 1
        Random randGen = new Random();
        int rnumber = randGen.nextInt(wordCount);

        //get a word from the dictionary, this will be the word to guess
        String guessWord = wordBank.getWord(rnumber);

        System.out.println("A word has been choosen!");

        //Display underscores for each letter, and spaces for spaces
        int wordLength = guessWord.length();
        printGuesses(wordLength, guessWord, letterGuesses);

        //now asks the user for guesses
        while (canGuess == true) {
            System.out.print("Please guess a letter: ");
            String guess = reader.next();
            
            //if the user guess was not in the word
            if (guessWord.contains(guess) == false) {
                //wrong guess, take away number of guesses user has
                numbOfGuesses--;
            }
               
            //let the user know which letters they guessed already
            if (letterGuesses == null) {
                letterGuesses = guess;
            } else {
                letterGuesses = letterGuesses.concat(guess);
            }
            
            //if they used up the guesses, exit loop
            if (numbOfGuesses == 0) {
                canGuess = false;
                gameOver = true;
            }

            //print the word and blank lines, if no more blank lines, user won
            won = printGuesses(wordLength, guessWord, letterGuesses);
            
            //if won, leave loop
            if (won == true) {
                canGuess = false;
            }
            
            //display the letters guessed so far
            if (letterGuesses != null) {
                System.out.print("Letters guessed so far: ");
                System.out.println(letterGuesses);
            }

        }
        
        //if won, display a messsage saying they won
        if(won == true)
        {
            System.out.println("\nCongratulations!  You won!");
        }
        
        //tell the user they lost, display the word
        else if(gameOver == true)
        {
            System.out.println("\nYou used up all your letter guesses.");
            System.out.println("Sorry but the word was " + guessWord);
        }
        
        //ask user if they want to keep playing
        System.out.println("\nWould you like to continue playing?");
        System.out.println("1 for yes, 2 for no");
        
        //read in user's answer
        int userChoice = reader.nextInt();
        if(userChoice != 1)
        {
            keepPlaying = false;
        }

        //return value to see if they should keep going
        return keepPlaying;
    }

    //function to print the _, spaces, and letters user has guessed that is in
    //the word
    private static boolean printGuesses(int length, String guessWord,
            String guesses) {
        boolean contains;
        boolean won = true;
        
        //for each letter in the word, see if it matches a letter the user
        //guessed
        for (int i = 0; i < length; i++) {
            contains = false;
            if (guessWord.charAt(i) != ' ') {
                if (guesses != null) {
                    for (int j = 0; j < guesses.length(); j++) {
                        if (guesses.charAt(j) == guessWord.charAt(i)) {
                            contains = true;
                        }
                    }
                }

                //if letter wasn't there, print a _
                if (contains == false) {
                    won = false;
                    System.out.print("_ ");
                }
                //if letter was there, print it instead of _
                else {
                    System.out.print(guessWord.charAt(i));
                }
            } else {  //print out a space
                System.out.print("  ");
            }
        }
        System.out.println(); //print a new line
        return won;  //if no _ user won, return true

    }

}
