/*
 * Activity 2.5.2
 *
 * The runner for the PhraseSolverGame
 */

import java.util.Scanner;


public class Runner
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    PhraseSolver p = new PhraseSolver();
    Board b = new Board();
    // Player player1 = new Player();
    // Player player2 = new Player();
    System.out.println("Guess a letter or guess the phrase");
    b.guessLetter(sc.nextLine());
    p.play();
  }

} 
