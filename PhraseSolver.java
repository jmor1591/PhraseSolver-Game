/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  int turn = 1;
  int currentPlayer = 1;

  /* your code here - constructor(s) */
  public PhraseSolver()
  {
    //Player p1 = new Player();
    //Player p2 = new Player();
    boolean solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void advanceTurn()
  {
    turn++;
    if (turn % 2 == 1) {
      currentPlayer = 1;
    }
    else {
      currentPlayer = 2;
    }
    System.out.println();
  }

  public void play(Board board, Player a, Player b)
  {
    boolean solved = false;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      Player currentObject = null;
      if (currentPlayer == 1) {
        currentObject = a;
      }
      else if (currentPlayer == 2) {
        currentObject = b;
      }
      /* your code here - game logic */
    System.out.println("It is " + currentObject.getName() + "'s turn.");
    System.out.println("Points: " + currentObject.getPoints());
    System.out.println(board.getSolved());
    System.out.println("Guess a letter or guess the phrase");
    int changed = board.getAmountSolved();
    String guess = input.nextLine();
    if (guess.length() == 1) {
      if (board.guessLetter(guess) && !currentObject.getPastGuesses().contains(guess)) {
        int bonus = (board.getAmountSolved() - changed) * board.getLetterValue();
        System.out.println("Good job! " + currentObject.getName() + " guessed a letter correctly! and will receive " + bonus + " points!");
        currentObject.addPoints(bonus);
        System.out.println(board.getSolved());
      }
      
      else if (board.guessLetter(guess) && currentObject.getPastGuesses().contains(guess)) {
        System.out.println("You already guessed " + guess + ".");
        System.out.println("Try again.");
        turn++;
      }

      else {
        System.out.println("Sucks to be you! " + guess + " was not in the phrase.");
      }
      
      currentObject.addGuess(guess);
      if (currentPlayer == 1) {
        a = currentObject;
      }
      else if (currentPlayer == 2) {
        b = currentObject;
      }
      /* your code here - determine how game ends */
      if (board.getSolved().equals(board.getExSolved())) {
        solved = true;
      }
      else {
        advanceTurn();
      }
      
    }

    else {
      if (board.getPhrase().equals(guess)) {
        System.out.println("Congratulations! You guessed the phrase correctly!");
        System.out.println("You will now receive " + (board.getTotalLetterValue() - a.getPoints() - b.getPoints()) + " points");
        currentObject.addPoints(board.getTotalLetterValue() - a.getPoints() - b.getPoints());
        solved = true;
      }
      else {
        System.out.println("Womp womp. You didn't guess the phrase correctly.");
        advanceTurn();
      }
    }
  }

  Player winner;
  if (a.getPoints() > b.getPoints()) {
    winner = a;
  }
  else if (b.getPoints() > a.getPoints()) {
    winner = b;
  }
  else {
    winner = null;
  }

  if (winner != null) {
    System.out.println("The winner is......." + winner.getName() + "! With " + winner.getPoints() + " points!");
  }
  else {
    System.out.println("A tie?!? No one wins!");
  }
  }
}