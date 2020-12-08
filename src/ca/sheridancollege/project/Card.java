/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {

    public enum Suit {HEARTS, 
                      DIAMONDS, 
                      SPADES, 
                      CLUBS};
    
    public enum Value {ACE, 
                       TWO, 
                       THREE, 
                       FOUR, 
                       FIVE, 
                       SIX, 
                       SEVEN, 
                       EIGHT, 
                       NINE, 
                       TEN, 
                       JACK, 
                       QUEEN, 
                       KING}
    
    private Suit suit;
    private Value value;
    private Player own;
    
    
    public Player getOwn() {
        return own;
    }

    public void setOwn(Player own) {
        this.own = own;
    }
   
    
    public Card(Value value, Suit suit) {
         this.value = value;
         this.suit = suit;
    }
    
    public Card(){
        suit = null;
        value = null;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    
     
     @Override
    public String toString(){
        
        return value + " of " + suit;
    }
    
   
}
     
   

    

