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

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public ArrayList<Card> getPlayersDeck() {
        return pokerDeck;
    }

    public void setPlayersDeck(ArrayList<Card> playersDeck) {
        this.pokerDeck = playersDeck;
    }
            private ArrayList<Card> pokerDeck;
            private ArrayList<Card> playerHand;
            private ArrayList<Card> oppHand;
            
            
	    
		
		
	   
            
            public void deck(){
                
                   for(Suit suit : Suit.values()) {
			for(Value value : Value.values()) {
				pokerDeck.add(new Card(value, suit));
                                
                               
                               
                                play();
         }
       }
    }
            

	    /**
	     * Play the game. This might be one method or many method calls depending on your game.
	     */
	    public void play() {
	    	System.out.println("Hello and welcome to world poker stars tournament a game by Shawn, Zenan, and Jack");
	    	System.out.println("Plaese enter your name: ");
	    	Scanner userIn = new Scanner(System.in);
	    	String playerName = userIn.nextLine();//FIXME Set player name with setName method
                Player play1 = new Player();
                play1.setName(playerName);
                play1.setCoins(10);
	    	
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
	    	System.out.println("Okay now lets get started \n");
                //Deal cards
                createPlayers();
                
                System.out.println("Shuffling deck before we begin!");
                Collections.shuffle(pokerDeck);
                
                System.out.println("Dealing cards");
                deal();
                
                
                
                
                System.out.println("You are dealt 5 cards:");
	    	
	    	
	    }
            private void deal(){
                
                
                
                    for (int i = 0; i > 5; i++) {

                        playerHand.add(pokerDeck.get(i));
                        pokerDeck.remove(i);
                        System.out.println(playerHand.get(i));
                    }
                    for (int j = 0; j > 5; j++) {

                        oppHand.add(pokerDeck.get(j));
                        pokerDeck.remove(j);
                        System.out.println(oppHand.get(j));
                    }
                    
                    
                }
                
//                while(!pokerDeck.isEmpty()){
//                    
//                    pokerDeck.get(0).setOwn(players[playerIn]);
//                    pokerDeck.get(1).setOwn(players[playerIn]);
//                    pokerDeck.get(2).setOwn(players[playerIn]);
//                    pokerDeck.get(3).setOwn(players[playerIn]);
//                    pokerDeck.get(4).setOwn(players[playerIn]);
//                    
//                    System.out.println(players);
                    
             

             

            
           
	
		public void createPlayers(){
                    
	}//getPlayers method
	    /**
	     * When the game is over, use this method to declare and display a winning player.
	     */
	    public void declareWinner(){
                
            }

}//end clas
