/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;




import java.util.ArrayList;
import java.util.Scanner;

/**
	* The class that models your game. You should create a more specific child of this class and instantiate the methods
	* given.
	*
 	* @author dancye
 	* @author Paul Bonenfant Jan 2020
 	* @Modifier Jack Farrell
*/
public class Game {

	    private final String name;//the title of the game
	    private ArrayList<Player> players;// the players of the game
            
	    
		
		
	    public Game(String name) {
	        this.name = name;
	        players = new ArrayList();
	    }

   

	    /**
	     * @return the name
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * @return the players of this game
	     */
	    public ArrayList<Player> getPlayers() {
	        return players;
	    }

	    /**
	     * @param players the players of this game
	     */
	    public void setPlayers(ArrayList<Player> players) {
	        this.players = players;
	    }
            
            public static void deck(){
                Card[] cards = new Card[52]; 
            
                
                   for (Card.Suit s : Card.Suit.values()) {
                      for (Card.Value r : Card.Value.values()) {
                         int i = 0;
                         cards[i] = new Card(r,s);
                         System.out.println(cards[i].toString());
                         i++;
                    
                }
            }
         }
            

	    /**
	     * Play the game. This might be one method or many method calls depending on your game.
	     */
	    public static void play() {
	    	System.out.println("Hello and welcome to world poker stars tournament a game by Shawn, Zenan, and Jack");
	    	System.out.println("Plaese enter your name: ");
	    	Scanner userIn = new Scanner(System.in);
	    	String playerName = userIn.nextLine();//FIXME Set player name with setName method
	    	
	    	System.out.println("Hello " + playerName + ". Would you like to read the rules before you start?(Y/N)");
	    	String rulesChoice = userIn.nextLine();
	    	
	    	if(rulesChoice.equalsIgnoreCase("Y") || rulesChoice.equalsIgnoreCase("y")) {
	    		System.out.println("This is a game of five card draw poker. The goal of the game is to have a hand of higher value than your opponent.\n"
	    				+ "The higher number cards are worth more, and the face card in order of lowest to highest are Jack, Queen, King, and Ace being the higest.\n"
	    				+ "Your hand increases in value if you have certain cards. The order of those hands from lowest to highest is: \n"
	    				+ "One Pair, Two Pair, Three of a Kind,Straight(Five Cards in Sequence),Full house (Three of a Kind and one Pair), Four of a Kind, \n"
	    				+ "Straight Flush (Five Cards in sequence and all in the same suit), and Royal Flush (Ace, King, Queen, Jack, Ten all in the same suit). \n"
	    				+ "At the beggining of each round, you are dealt five cards, then you may return any or all of those cards for new ones from the deck. \n"
	    				+ "Then, you may bet coins based on how confident you are that your hand will beat your opponent. Once any betting is finished, \n"
	    				+ "the cards are revealed. If your hand is more valuable then your opponents, then you win and you get your coins back and any that \n"
	    				+ "your opponent bet. You may then chose to play another round or leave the table.");
	    	}
	    	System.out.println("Okay now lets get started");
	    	//Deal cards
	    	
	    	
	    }

	    /**
	     * When the game is over, use this method to declare and display a winning player.
	     */
	    public void declareWinner(){
                
            }

}//end clas
