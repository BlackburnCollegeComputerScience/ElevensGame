/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import javafx.beans.property.ReadOnlyListWrapper;
import java.util.Iterator;
import java.util.Random;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lucas.burdell
 */
public class Deck {

    
    private ObservableList<Card> cards = javafx.collections.FXCollections.observableList(new ArrayList<>());
    private static final Random random = new Random();

    public Deck() {
        for (int i = 1; i <= 52; i++) {
            Card toAdd = new Card(i);
            System.out.println(toAdd.getFace() + " " + toAdd.getSuit() + " " + i);
            cards.add(toAdd);
        }
    }

    public Deck(int numCards) {
        for (int i = 1; i <= numCards; i++) {
            boolean cardAdded = false;
            Card cardToAdd = null;
            Card newCard = new Card();
            Iterator<Card> iterator = cards.iterator();
            while (iterator.hasNext()) {
                Card cardToCheck = iterator.next();
                if (newCard.getFace().equals(cardToCheck.getFace())
                        && newCard.getSuit().equals(cardToCheck.getFace())) {
                } else {
                    cardToAdd = cardToCheck;
                    cardAdded = true;
                    break;
                }
            }
            if (!cardAdded) {
                cards.add(cardToAdd);
            }
        }
    }
    
    public Deck(ArrayList<Card> cards) {
        Object[] cardArrayAsObjects = cards.toArray();
        for (int i = 0; i < cardArrayAsObjects.length; i++) {
            cards.add((Card) cardArrayAsObjects[i]);
        }
    }
    
    public boolean addCard(Card card) {
        return cards.add(card);
    }
    
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }
 
    public Card takeTopCard() {
        Card card = cards.get(cards.size());
        removeCard(card);
        return card;
    }
    
    public int getDeckSize() {
        return cards.size();
    }
    
    public Card takeRandomCard() {
        Card card = cards.get(random.nextInt(cards.size()));
        removeCard(card);
        return card;
    }
    
    public Deck splitDeck() {
        ArrayList<Card> newCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            newCards.add(cards.get(i));
        }
        return new Deck(newCards);
    }

    /**
     * @return the cards
     */
    public ObservableList<Card> cardsProperty() {
        return cards;
    }
}
