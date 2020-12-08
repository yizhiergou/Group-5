
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author Shawn
 * @modifier Jack Farrell
 */
public class Hand {
    
    static ArrayList<Card> playerHand = new ArrayList<Card>();
	private static ArrayList<Card> oppHand = new ArrayList<Card>();
	static ArrayList<Card> pokerDeck = Game.getPokerDeck();
	
    public ArrayList<Card> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(ArrayList<Card> playerHand) {
		Hand.playerHand = playerHand;
	}

	public ArrayList<Card> getOppHand() {
		return oppHand;
	}

	public void setOppHand(ArrayList<Card> oppHand) {
		Hand.oppHand = oppHand;
	}
	
    public static ArrayList<Card> deal(ArrayList<Card> playerHand){  	
    	playerHand.add(pokerDeck.get(0));//Adds five cards one at a time to the playerHand array list that is used by the player to play the game
    	playerHand.add(pokerDeck.get(1));
    	playerHand.add(pokerDeck.get(2));
    	playerHand.add(pokerDeck.get(3));
    	playerHand.add(pokerDeck.get(4));
    	pokerDeck.remove(0);// Removes the first five cards from the pokerDeck list so they cannot be taken from the pokerDeck once they are a part of the playerHand
    	pokerDeck.remove(0);
    	pokerDeck.remove(0);
    	pokerDeck.remove(0);
    	pokerDeck.remove(0);
    	
    	oppHand.add(pokerDeck.get(0)); //Adds the next five cards from the pokerDeck to the oppHand one at a time so the opponent has a hand to play with
    	oppHand.add(pokerDeck.get(1));
    	oppHand.add(pokerDeck.get(2));
    	oppHand.add(pokerDeck.get(3));
    	oppHand.add(pokerDeck.get(4));
    	pokerDeck.remove(0);//removes those five cards on at a time from the pokerDeck so that they are now only a part of the opponent hand 
    	pokerDeck.remove(0);
    	pokerDeck.remove(0);
    	pokerDeck.remove(0);
    	pokerDeck.remove(0);
    	
    	
        
        System.out.println("You are dealt 5 cards:");
        System.out.println(playerHand);
        System.out.println("Opponent hand: " + oppHand);//FIXME Prints Opponents hand for testing purposes only. Remove in final build
        
        return playerHand;
    }//deal method

    public static ArrayList<Card> subCards(ArrayList<Card> playerHand, String cardSwap) {//Add the code to get some cards from the pokerDeck and add it to the players hand
    	
        for (int i = 0; i < cardSwap.length() && i < playerHand.size(); i++) {
        	
        	int x = cardSwap.charAt(i)-'0';//Converts the 1st digit the player inputs for String to int
        	if(x == 0) { 
        		System.out.println(Hand.playerHand);
        		return playerHand;
        	}else {
        	System.out.println(x);//FIXME TESTING ONLY REMOVE IN FINAL BUILD prints the number that is now converted
        	System.out.println(playerHand.get(x - 1));//FIXME TESTING ONLY REMIOVE IN FINAL BUILD prints the card selected by user
        	
        	pokerDeck.add(playerHand.get(x-1));//Adds the card removed from the playerHand back to the deck
        	playerHand.remove(x -1);//Removes the card at x(the chosen number 1 - 5) minus one(cards numbered 1 - 5, in list as 0 - 4)
        	System.out.println(pokerDeck.get(0));//FIXME TESTING ONLY REMOVE IN FINAL BUILD prints the card that will be added playerHand
        	playerHand.add(pokerDeck.get(0));//Adds a new card from the pokerDeck to the player hand
        	pokerDeck.remove(0);//removes the card from the pokerDeck that was added to the playerHand
        	
        	System.out.println(playerHand);
        	}

        }
        
        return playerHand;
    }
}
