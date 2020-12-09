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
        * @Modifier Shawn Pattullo
*/
public class Game {

	    private String name;//the title of the game
	    private Player[] players;// the players of the game
	    private static ArrayList<Card> pokerDeck;
	    boolean playerValid = false;
	    boolean oppValid = false; 
	    boolean playerValid1 = false; 
	    boolean oppValid1 = false;
	    boolean playerValid2 = false;
	    boolean oppValid2 = false;
	    boolean playerValid3 = false; 
	    boolean oppValid3 = false;

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
	    	boolean contPlay = false;
	    	
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|**********************************************************|");
            System.out.println("|*** HELLO AND WELCOME TO WORLD POKER STARS TOURNAMENT! ***|");
            System.out.println("|**********************************************************|"
                    	   + "\n|********************* A Game By: *************************|"
                    	   + "\n|**************** Shawn, Zenan, and Jack ******************|");
            System.out.println("|**********************************************************|");
            System.out.println("|----------------------------------------------------------|");
            
            do {
            System.out.print("\nPlease enter your name: \n> ");
	    	Scanner userIn = new Scanner(System.in);
	    	createPlayers();
	    	
	    	System.out.println(". Would you like to read the rules before you start?(Y/N)");
	    	String rulesChoice = userIn.nextLine();
	    	
	    	if(rulesChoice.equalsIgnoreCase("Y") || rulesChoice.equalsIgnoreCase("y")) {
	    		System.out.println("This is a game of five card draw poker. The goal of the game is to have a hand of higher value than your opponent.\n"
	    				+ "The higher number cards are worth more, and the face card in order of lowest to highest are Jack, Queen, King, and Ace being the highest.\n"
	    				+ "Your hand increases in value if you have certain cards. The order of those hands from lowest to highest is: \n"
	    				+ "One Pair, Two Pair, Three of a Kind,Full house (Three of a Kind and one Pair), Four of a Kind, \n"
	    				+ "At the beginning of each round, you are dealt five cards, then you may return any or all of those cards for new ones from the deck. \n"
	    				+ "Then, you may bet coins based on how confident you are that your hand will beat your opponent. Once any betting is finished, \n"
	    				+ "the cards are revealed. If your hand is more valuable then your opponents, then you win and you get your coins back and any that \n"
	    				+ "your opponent bet. You may then chose to play another round or leave the table.\n");
	    	}
	    	System.out.println("Okay now lets get started \n");
	    	
	    	deck();//creates the pokerDeck
                System.out.println("Shuffling deck before we begin!");
               Collections.shuffle(pokerDeck);// Shuffles the deck to have the cards in random order
                
           
                System.out.println("Dealing cards");
            	
                Hand.deal(Hand.playerHand);//deals 5 cards to the player and 5 to Bob
                
                System.out.println("Please enter the cards you wish to substitue(Numbered 1-5, 0 if none)");
                String cardSwap = userIn.nextLine();
                Hand.subCards(Hand.playerHand, cardSwap);
                
                Player.betting();
                
                
                
                playerFour(playerValid);
                oppFour(oppValid);
                
                playerfullHouse(playerValid1);
                oppfullHouse(oppValid1);
                
                playerThreeOfKind(playerValid2);
                oppThreeOfKind(oppValid2);
                
                playerTwoPair(playerValid3);
                oppTwoPair(oppValid3);
                
                declareWinner(playerValid, oppValid, playerValid1, oppValid1, playerValid2, oppValid2, playerValid3, oppValid3);
                
                System.out.println("Would you like to play again?(Y/N");
                String userCont = userIn.nextLine();
                if (userCont.equalsIgnoreCase("Y") || (userCont.equalsIgnoreCase("y"))) {
                	contPlay = true;
                }
                	contPlay = false;
      
            } while (contPlay = true && contPlay != false); 
	    	System.out.println("Thank you for playing");
	    }//Play method
	//-----------------------------------------------------------------------------------------------------
	//FOUR OF A KIND      
	public boolean playerFour(boolean playerValid){
	        if (Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()
	                && Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()) {
	            return playerValid = true;
	        } else if (Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()
	                && Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue()) {
	            return playerValid = true;
	        }
	        return  playerValid = false;
	}

	public boolean oppFour(boolean oppValid){        
	        if (Hand.oppHand.get(0).getValue() == Hand.oppHand.get(1).getValue()
	                && Hand.oppHand.get(1).getValue() == Hand.oppHand.get(2).getValue()
	                && Hand.oppHand.get(2).getValue() == Hand.oppHand.get(3).getValue()) {
	            return oppValid = true;
	        } else if (Hand.oppHand.get(1).getValue() == Hand.oppHand.get(2).getValue()
	                && Hand.oppHand.get(2).getValue() == Hand.oppHand.get(3).getValue()
	                && Hand.oppHand.get(3).getValue() == Hand.oppHand.get(4).getValue()) {
	            return oppValid = true;
	        }
	        return  oppValid = false;
	    }
	//--------------------------------------------------------------------------------------------------
	//FULLHOUSE
	public boolean playerfullHouse(boolean playerValid1) {
	        if (Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()
	                && Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue()) {
	            if (Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue()) {

	                return playerValid1 = true;
	            }
	             }else if(Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()){
	            if(Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()
	                && Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue()){
	                return playerValid1 = true;
	            }

	        }
	        return playerValid1 = false;
	    }

	public boolean oppfullHouse(boolean oppValid1) {
	        if (Hand.oppHand.get(0).getValue() == Hand.oppHand.get(1).getValue()
	                && Hand.oppHand.get(1).getValue() == Hand.oppHand.get(2).getValue()) {
	            if (Hand.oppHand.get(3).getValue() == Hand.oppHand.get(4).getValue()) {

	                return oppValid1 = true;
	            }
	             }else if(Hand.oppHand.get(0).getValue() == Hand.oppHand.get(1).getValue()){
	            if(Hand.oppHand.get(2).getValue() == Hand.oppHand.get(3).getValue()
	                && Hand.oppHand.get(3).getValue() == Hand.oppHand.get(4).getValue()){
	                return oppValid1 = true;
	            }

	        }
	        return oppValid1 = false;
	    }
	//------------------------------------------------------------------------------------------------------------
	//THREE OF KIND
	public boolean playerThreeOfKind(boolean playerValid2){
	        if ((Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()
	                && Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue())
	                || (Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue())
	                || (Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()
	                && Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue())){
	        return playerValid2 = true;
	        }
	        return playerValid2 = false;
	    }
	public boolean oppThreeOfKind(boolean oppValid2){
	        if ((Hand.oppHand.get(0).getValue() == Hand.oppHand.get(1).getValue()
	                && Hand.oppHand.get(1).getValue() == Hand.oppHand.get(2).getValue())
	                || (Hand.oppHand.get(1).getValue() == Hand.oppHand.get(2).getValue()
	                && Hand.oppHand.get(2).getValue() == Hand.oppHand.get(3).getValue())
	                || (Hand.oppHand.get(2).getValue() == Hand.oppHand.get(3).getValue()
	                && Hand.oppHand.get(3).getValue() == Hand.oppHand.get(4).getValue())){
	        return oppValid2 = true;
	        }
	        return oppValid2 = false;
	    }
	//-----------------------------------------------------------------------------------------------------------
	//TWO OF A KIND
	public boolean playerTwoPair(boolean playerValid3) {
	        if (Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue()
	                && Hand.playerHand.get(2).getValue() == Hand.playerHand.get(3).getValue()){
	            return playerValid3 = true;
	        }


	            else if((Hand.playerHand.get(1).getValue() == Hand.playerHand.get(2).getValue())&&
	            (Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue())){
	                return playerValid3 = true;
	            }

	           else if((Hand.playerHand.get(0).getValue() == Hand.playerHand.get(1).getValue())&&
	            (Hand.playerHand.get(3).getValue() == Hand.playerHand.get(4).getValue())){
	                return playerValid3 = true;
	            }else

	        return playerValid3 = false;
	    }  

	public boolean oppTwoPair(boolean oppValid3) {
	        if (Hand.oppHand.get(0).getValue() == Hand.oppHand.get(1).getValue()
	                && Hand.oppHand.get(2).getValue() == Hand.oppHand.get(3).getValue()){
	            return oppValid3 = true;
	        }


	            else if((Hand.playerHand.get(1).getValue() == Hand.oppHand.get(2).getValue())&&
	            (Hand.playerHand.get(3).getValue() == Hand.oppHand.get(4).getValue())){
	                return oppValid3 = true;
	            }

	           else if((Hand.oppHand.get(0).getValue() == Hand.oppHand.get(1).getValue())&&
	            (Hand.oppHand.get(3).getValue() == Hand.oppHand.get(4).getValue())){
	                return oppValid3 = true;
	            }else

	        return oppValid3 = false;
	    }

	            	public void declareWinner(boolean playerValid, boolean playerValid1, boolean playerValid2, boolean playerValid3, 
	            			boolean oppValid, boolean oppValid1, boolean oppValid2, boolean oppValid3){
	            	                
	            	    System.out.println("lets see who wins!");
	            	                //playerValid - FOUR OF A KIND
	            	                //playerValid1 - FULL HOUSE
	            	                //playerValid2 - THREE OF KIND
	            	                //playerValid3 - TWO PAIR
	            	                
	            	                //Four of a kind player win
	            	                if (playerValid == true && oppValid == false || 
	            	                    playerValid == true && oppValid2 == true ||
	            	                    playerValid == true && oppValid3 == true ||
	            	                    playerValid == true && oppValid2 == false ||
	            	                    playerValid == true && oppValid3 == false ||
	            	                    playerValid == true && oppValid1 == false) {
	            	                    
	            	                    System.out.println("YOU WIN WITH FOUR OF A KIND!");
	            	                }
	            	                
	            	                if (playerValid1 == true && oppValid1 == false ||
	            	                    playerValid1 == true && oppValid == true || 
	            	                    playerValid1 == true && oppValid2 == true ||
	            	                    playerValid1 == true && oppValid3 == true ||
	            	                    playerValid1 == true && oppValid == false || 
	            	                    playerValid1 == true && oppValid2 == false ||
	            	                    playerValid1 == true && oppValid3 == false) {
	            	                    
	            	                    System.out.println("YOU WIN WITH A FULL HOUSE!");
	            	                    
	            	                }
	            	                if (playerValid2 == true && oppValid2 == false ||
	            	                        playerValid2 == true && oppValid1 == false ||
	            	                        playerValid2 == true && oppValid == false ||
	            	                        playerValid2 == true && oppValid3 == false ||
	            	                        playerValid2 == true && oppValid3 == true) {
	            	                    
	            	                    System.out.println("YOU WIN WITH A THREE OF A KIND!");
	            	                    
	            	                }
	            	                if (playerValid3 == true && oppValid3 == false ||
	            	                    playerValid3 == true && oppValid1 == false ||
	            	                    playerValid3 == true && oppValid2 == false ||
	            	                    playerValid3 == true && oppValid == false) {
	            	                    
	            	                    System.out.println("YOU WIN WITH A TWO OF A PAIR!");        
	            	                    
	            	                }
	            	                
	            	                
	            	                System.out.println("Congratulations, you win");
	            	} 
	            	            
}//end class
