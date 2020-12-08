/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Player {

    private String name; //the unique name for this player
    private static int coins;
    private ArrayList<Card> hand;
    private String cardsToSub;
    

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
      public static int getCoins() {
        return coins;
    }
    
    public void setCoins(int coins) {
        Player.coins = coins;
    }
    
      public ArrayList<Card> getHand() {
        return hand;
    }
      
      static double[] betting() {
    	  double[] coinsAndPot = new double[2];
    	  boolean betPlaced = false;
    	  double pot = 0;
    	  Scanner userIn = new Scanner(System.in);
      	  System.out.println("You have " + Player.getCoins() + " coins. Would you like to place a bet? (Y/N)");
    	  String playBetChoice = userIn.nextLine();
    	  
    	  if (playBetChoice.equalsIgnoreCase("Y") || playBetChoice.equalsIgnoreCase("y")) {
    		  
    		  do {
    		System.out.println("How many coins would you like to bet? ");
    		int betCoins = userIn.nextInt();
    		if (betCoins > coins) {
    			System.out.println("Sorry you do not have enough coins to place that bet");
    		} 
    		else {
    			coins = coins - betCoins;
    			double oppBet = (int)Math.random() * 5 + 1;
    			pot = betCoins + oppBet;
    			System.out.println("You have place your bet of " + betCoins + " coins. Your coin total is now " + coins + " coins. If you win you will recieve " + pot 
    					+ " coins");
    			System.out.println("Your opponennt has bet " + oppBet);
    			betPlaced = true;
    			coinsAndPot[0] = coins;
    			coinsAndPot[1] = pot;
    			return coinsAndPot;
    			}
    		  } while(betPlaced == false && betPlaced != true);
    	  }
    	  coinsAndPot[0] = coins;
    	  coinsAndPot[1] = 0;
    	  return coinsAndPot;
      }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
//    public void play() {
//	}

}
