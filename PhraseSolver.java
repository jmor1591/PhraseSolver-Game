/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */

  /* your code here - constructor(s) */
  public PhraseSolver()
  {
    Player p1 = new Player();
    Player p2 = new Player();
    boolean solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      Object currentObject;
      if (currentPlayer == 1) {
        currentObject = p1;
      }
      else if (currentPlayer == 2) {
        currentObject = p2;
      }
      /* your code here - game logic */
    b.printSolved();
    System.out.println("Guess a letter or guess the phrase");
    String guess = input.nextLine();
    if (guess.length() == 1) {
      if (b.guessLetter(guess) && guess.length() == 1 && !currentObject.getPastGuesses().contains(guess)) {
        System.out.println("Good job!" + p1.getName() + "guessed a letter correctly!");
        currentObject.addPoints(b.getLetterValue());
        b.printSolved();
    }
    
      
      /* your code here - determine how game ends */
      solved = true; 
    } 
  }
}
}