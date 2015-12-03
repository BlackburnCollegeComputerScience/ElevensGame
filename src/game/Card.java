/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.Random;
/**
 *
 * @author lucas.burdell
 */
public class Card {
    
    private String suit;
    private String face;
    private static final String[] suits = {"club","diamond","heart","spade"};
    private static final String[] faces = {"Ace", "King", "Queen", "Jack", "10",
        "9", "8", "7", "6", "5", "4", "3", "2"};
    private static final Random random = new Random();
    
    public Card() {
        this(suits[random.nextInt(suits.length)], 
                faces[random.nextInt(faces.length)]);
    }
    
    public Card(int cardNumber) {
        int suit = cardNumber % 4;
        int face = (cardNumber) / 4 - ((cardNumber % 4)==0 ? 1:0);
        System.out.println(cardNumber + " " + face);
        switch (suit) {
            case 0:
                this.suit = "spade";
                break;
            case 1:
                this.suit = "club";
                break;
            case 2: 
                this.suit = "diamond";
                break;
            case 3: 
                this.suit = "heart";
                break;
        }
        this.face = faces[face];
    }
    
    public Card(String suit) {
        this(suit, faces[random.nextInt(faces.length)]);
    }
    
    public Card(String suit, String face) {
        this.suit = suit;
        this.face = face;
    }

    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @return the face
     */
    public String getFace() {
        return face;
    }
    
    
}
