/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player{

    private String name; 
    private int coins;
    
    public Player(String name, int coins) {
        this.name = name;
        this.coins = coins;
    }
    public String getName() {
        return name;
    }
    public int getCoin() {
        return coins;
    }
   
    public void setName(String name) {
        this.name = name;
    }
    public void setCoin(int coins) {
        this.coins = coins;
    }
    
}
