/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private String exPhrase = "";
  private int currentLetterValue;
  private int totalLetterValue;
  private int amountSolved;

  /* your code here - constructor(s) */
  public Board()
  {
    phrase = loadPhrase();
    System.out.println("Phrase: " + phrase); //temp test code
    System.out.println("Solved Phrase: " + solvedPhrase);
  }
  
  /* your code here - accessor(s) */
  public int getLetterValue()
  {
    return currentLetterValue;
  }

  public int getTotalLetterValue()
  {
    return totalLetterValue;
  }

  public String getSolved()
  {
    return solvedPhrase;
  }

  public String getPhrase()
  {
    return phrase;
  }

  public String getExSolved()
  {
    return exPhrase;
  }

  public int getAmountSolved()
  {
    return amountSolved;
  }
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  private void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    setLetterValue();
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
        exPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
        exPhrase += tempPhrase.substring(i, i + 1) + " ";
        totalLetterValue += currentLetterValue;
      }
    }  
    
    return tempPhrase;
  }  


  /*
    Description: Will return if the player's guess was found in the phrase or not

    Precondition(s): 
    guess must be a string and be populated
    phrase must be populated
    solved phrase must be populated and have spaces

    Postcondition(s):
    solvedPhrase is populated again
    guessLetter returns a boolean (needs to be stored or used)
  */
  public boolean guessLetter(String guess)
  {
    //boolean that it is used to know if the user's guess is in the phrase
    boolean foundLetter = false;

    //create a string to store either the guess or store _ in the future
    String newSolvedPhrase = "";
    
    //loops through all characters in the string
    for (int i = 0; i < phrase.length(); i++)
    {
      //compares each letter to guess
      if (phrase.substring(i, i + 1).equals(guess))
      {
        //if the letter matches the guess, then add the guess to part of the newSolvedPhrase and prepare for the next character
        newSolvedPhrase += guess + " ";
        amountSolved++;

        //indicates that the guess is in the phrase
        foundLetter = true;
      }
      else
      {
        //if the selected character of the phrase is not the same as the guess, skip that part of the phrase and move on
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
      }
    }
    //update the solvedPhrase after you checked if the guess was in the phrase
    solvedPhrase = newSolvedPhrase;

    //return if the guess is in the phrase or not
    return foundLetter;
  }
} 