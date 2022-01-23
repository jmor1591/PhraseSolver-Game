/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name = ""; 
  private int points = 0;
  private String pastGuesses = "";
  /* your code here - constructor(s) */ 
  public Player()
  {
    System.out.println("What is your name?: ");
    setName();
    System.out.println("Welcome to the game "+ getName() + ". Your point value is " + getPoints());
  }

  public Player(String name)
  {
    setName(name);
    System.out.println("Welcome to the game "+ getName() + ". Your point value is " + getPoints());
  }

  public String getName()
  {
    return name;
  }
  
  public void setName()
  {
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
  }

  public void setName(String inputName)
  {
    name = inputName;
  }

  public int getPoints()
  {
    return points;
  }
  /* your code here - accessor(s) */
  
  public String getPastGuesses() 
  {
    return pastGuesses;
  }
  /* your code here - mutator(s) */
  
  public void addGuess(String guess)
  {
    pastGuesses += guess;
  }

  public void addPoints(double bonus)
  {
    points += bonus;
  }
  
  
}