/*******************************************************************************
 * Dictionary - a container class that holds all the possible word values that *
 * could be used in the word guessing program.                                 *
 ******************************************************************************/
package wordguess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph Noyes
 */
public class Dictionary {
    //implemented as a singleton
    private static Dictionary wordBank = null;
    private final static List<String> wordList = new ArrayList();
    private static int wordCount;
    
    //private constructor
    private Dictionary()
    {
        
    }
    
    //function to get the dictionary
    public static Dictionary getDictionary()
    {
        if(wordBank == null)
        {
            wordBank = new Dictionary();
        }
        
        return wordBank;
    }
    
    //function to add a word to the list
    public void addToList(String w)
    {
        wordList.add(w);
    }
    
    //function to update the word count
    public void updateWC()
    {
        wordCount = wordList.size();
    }
    
    //function to get the word count
    public int getWC()
    {
        return wordCount;
    }
    
    //function to get a word from the dictionary
    public String getWord(int i)
    {
        String obtainedWord = wordList.get(i);
        return obtainedWord;
    }
   
}
