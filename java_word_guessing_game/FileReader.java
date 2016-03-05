package wordguess;

/*******************************************************************************
 * FileReader - reads the file containing the words that will be used in the   *
 * word game.                                                                  *
 ******************************************************************************/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *
 * @author Joseph Noyes
 */
public class FileReader {
    public void readFile()
    {
        //create input stream and buffered reader
        InputStream IS = WordGuess.class.getResourceAsStream("words.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(IS));
        
        //get an instance of the Dictionary
        Dictionary words = Dictionary.getDictionary();
        
        //start reading the file and placing the words in the dictionary
        try{
            String line;
            //while line read is not null
            while((line = reader.readLine()) != null)
            {
                //add to dictionary
                words.addToList(line);
            }
            
            //update the word count
            words.updateWC();
        }
        catch(IOException e)
        {
            
        }
    }
}
