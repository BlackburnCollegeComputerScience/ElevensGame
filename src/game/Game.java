/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.util.ArrayList;
import java.util.Random;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 *
 * @author lucas.burdell
 */
public class Game {

    
    //Model variables

    private int playerTokens;
    private int playerScore;
    private int dealerScore;

    private final Deck gameDeck;
    public final Deck playerDeck;
    public final Deck dealerDeck;
    
    //Variables for the controller
    public final SimpleIntegerProperty playerTokensProperty;
    public final SimpleIntegerProperty playerScoreProperty;
    public final SimpleIntegerProperty dealerScoreProperty;
    

    public Game() {
        //Initialize game vars
        gameDeck = new Deck();
        playerTokens = 10;
        playerScore = 0;
        dealerScore = 0;
        playerDeck = new Deck(0);
        dealerDeck = new Deck(0);
        
        //link properties
        playerTokensProperty = new SimpleIntegerProperty(playerTokens);
        playerScoreProperty = new SimpleIntegerProperty(playerScore);
        dealerScoreProperty = new SimpleIntegerProperty(dealerScore);     
    }
    

    public void draw() {
        Card c = gameDeck.takeRandomCard();
        playerDeck.addCard(c);
    }
}
