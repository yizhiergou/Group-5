/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Player {

    public Player(String name, int coins) {
        this.name = name;
        this.coins = coins;
    }

    private String name; //the unique name for this player
    private int coins;
    private ArrayList<Card> hand;
    private String cardsToSub;
    

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name){
        this.name = name;
    }

    Player() {
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
    public void setName(String name){
        this.name = name;
    }
    
      public int getCoins() {
        return coins;
    }
    
    public void setCoins(int coins){
        this.coins = coins;
    }
    
      public ArrayList<Card> getHand(){
        return hand;
    }
      
 
    public void play(){
        
    }

}
