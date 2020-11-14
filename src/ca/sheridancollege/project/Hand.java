package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author jackh
 */
public class Hand {
    
    private ArrayList<Card> cardsInHand;
    
    
    public ArrayList getCardsInHand() {
     return cardsInHand;   
    }
    
    public void setCardsInHand(ArrayList<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
    
    public ArrayList<Card> subCards(ArrayList<Card> cardsInHand) {
        //Add the code to get some cards from the GroupOfCards class and add it to the players hand
        return cardsInHand;
    }
}
