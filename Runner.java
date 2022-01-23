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
    Player p1 = new Player();
    Player p2 = new Player();
    p.play(b,p1,p2);
  }

} 
