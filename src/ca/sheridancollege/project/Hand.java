
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Shawn
 * @modifier Jack Farrell
 */
public class Hand {
    
    private static ArrayList<Card> playerHand;
	private static ArrayList<Card> oppHand;
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
	
    public static void deal(){
    	System.out.println(pokerDeck);
    	do {
    	for (int i = 0; i > 5; i++) {
            playerHand.add(pokerDeck.get(i));
            pokerDeck.remove(i);
            System.out.println(playerHand.get(i));
        }
    	} while(playerHand.size() < 5);
    	
    	System.out.println(pokerDeck);
    	
        for (int j = 0; j > 5; j++) {
            oppHand.add(pokerDeck.get(j));
            pokerDeck.remove(j);
            System.out.println(oppHand.get(j));
        }
        
        System.out.println("You are dealt 5 cards:");
    }//deal method

    public ArrayList<Card> subCards(ArrayList<Card> cardsInHand) {
        //Add the code to get some cards from the GroupOfCards class and add it to the players hand
        return cardsInHand;
    }
}
