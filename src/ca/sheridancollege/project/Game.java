/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;



import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import ca.sheridancollege.project.Player;

/**
	* The class that models your game. You should create a more specific child of this class and instantiate the methods
	* given.
	*
 	* @author dancye
 	* @author Paul Bonenfant Jan 2020
 	* @Modifier Jack Farrell
*/
public class Game {

	    private String name;//the title of the game
	    private Player[] players;// the players of the game
	    private static ArrayList<Card> pokerDeck;

		public Player[] getPlayers() {
			return players;
		}// getPlayers method

		public void setPlayers(Player[] players) {
			this.players = players;
		}// setPlayers method

		public static ArrayList<Card> getPokerDeck() {
			return pokerDeck;
		}// getPokerDeck method

		public void setPokerDeck(ArrayList<Card> pokerDeck) {
			Game.pokerDeck = pokerDeck;
		}// setPokerDeck method
    
    public void deck(){
    	for(Suit suit : Suit.values()) {
			for(Value value : Value.values()) {
				pokerDeck.add(new Card(value, suit));  
         }
       }
    }//deck method
    

    
	public void createPlayers(){	    	
		Scanner userIn = new Scanner(System.in);
		String playerName = userIn.nextLine();
        Player play1 = new Player(playerName);
        	play1.setName(playerName);
        	play1.setCoins(10);
    Player opponent = new Player("Bob");
    	opponent.setCoins(10);
    	
    System.out.println("Hello " + play1.getName());
}//createPlayers method
	
	public Game() {//Game method used to create a game object that runs the game
		pokerDeck = new ArrayList<>();
		Hand.playerHand = new ArrayList<>();
		play();
	}//Game method

	    /**
	     * Play the game. This might be one method or many method calls depending on your game.
	     */
	    public void play() {
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|**********************************************************|");
            System.out.println("|*** HELLO AND WELCOME TO WORLD POKER STARS TOURNAMENT! ***|");
            System.out.println("|**********************************************************|"
                    	   + "\n|********************* A Game By: *************************|"
                    	   + "\n|**************** Shawn, Zenan, and Jack ******************|");
            System.out.println("|**********************************************************|");
            System.out.println("|----------------------------------------------------------|");
    	System.out.print("\nPlease enter your name: \n> ");
	    	Scanner userIn = new Scanner(System.in);
	    	createPlayers();

//FIXME Commented out rules to expedite the testing process. Uncomment in final version
	    	
//	    	System.out.println(". Would you like to read the rules before you start?(Y/N)");
//	    	String rulesChoice = userIn.nextLine();
//	    	
//	    	if(rulesChoice.equalsIgnoreCase("Y") || rulesChoice.equalsIgnoreCase("y")) {
//	    		System.out.println("This is a game of five card draw poker. The goal of the game is to have a hand of higher value than your opponent.\n"
//	    				+ "The higher number cards are worth more, and the face card in order of lowest to highest are Jack, Queen, King, and Ace being the highest.\n"
//	    				+ "Your hand increases in value if you have certain cards. The order of those hands from lowest to highest is: \n"
//	    				+ "One Pair, Two Pair, Three of a Kind,Straight(Five Cards in Sequence),Full house (Three of a Kind and one Pair), Four of a Kind, \n"
//	    				+ "Straight Flush (Five Cards in sequence and all in the same suit), and Royal Flush (Ace, King, Queen, Jack, Ten all in the same suit). \n"
//	    				+ "At the beginning of each round, you are dealt five cards, then you may return any or all of those cards for new ones from the deck. \n"
//	    				+ "Then, you may bet coins based on how confident you are that your hand will beat your opponent. Once any betting is finished, \n"
//	    				+ "the cards are revealed. If your hand is more valuable then your opponents, then you win and you get your coins back and any that \n"
//	    				+ "your opponent bet. You may then chose to play another round or leave the table.");
//	    	}
	    	System.out.println("Okay now lets get started \n");
	    	
	    	deck();//creates the pokerDeck
                System.out.println("Shuffling deck before we begin!");
               Collections.shuffle(pokerDeck);// Shuffles the deck to have the cards in random order
                
           
                System.out.println("Dealing cards");
            	
                Hand.deal(Hand.playerHand);//deals 5 cards to the player and 5 to Bob
                
                System.out.println(Hand.playerHand.size());
                
                System.out.println("Please enter the cards you wish to substitue(Numbered 1-5, 0 if none)");
                String cardSwap = userIn.nextLine();
                Hand.subCards(Hand.playerHand, cardSwap);
                
                Player.betting();
                
                if(four()) {
                	System.out.println("WOW four of a kind");
                } else if (threeOfKind()) {
                	System.out.println("Cool three of a kind");
                } else if (twoPair()) {
                	System.out.println("neat two pair");
                }

	    	
	    }//Play method
	    private boolean four(){
	        if (Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()
	                && Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()) {
	            return true;
	            
	        } else if (Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()
	                && Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue()) {
	            return true;
	        }
	        return false;

	    }// four method
	    
	           private boolean threeOfKind(){
	        if ((Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()
	                && Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue())
	                || (Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue())
	                || (Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()
	                && Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue())){
	        return true;
	        }
	        return false;
	    }//threeOfKind method
	           
	           private boolean twoPair() {
	        if (Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()){
	            return true;
	        }
	            else if((Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue())&&
	            (Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue())){
	                return true;
	            }

	           else if((Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue())&&
	            (Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue())){
	                return true;
	            }else

	        return false;
	    }// twoPair method
	
	    /**
	     * When the game is over, use this method to declare and display a winning player.
	     */
	    public void declareWinner(){
                
            }

}//end class
