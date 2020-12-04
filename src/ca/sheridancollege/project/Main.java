/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;



/**
 *
 * @author Shawn
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE GAME");
        
       
                Card[] cards = new Card[52]; 
            
                
                   for (Card.Suit s : Card.Suit.values()) {
                      for (Card.Value r : Card.Value.values()) {
                         int i = 0;
                         cards[i] = new Card(r,s);
                         System.out.println(cards[i].toString());
                         i++;
                          
                          
             
                      }}}}

