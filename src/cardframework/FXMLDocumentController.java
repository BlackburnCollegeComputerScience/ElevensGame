/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardframework;

import game.Card;
import game.Deck;
import game.Game;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author lucas.burdell
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private FlowPane playerPlayPane;
    @FXML
    private TextField playerScoreField;
    @FXML
    private FlowPane dealerPlayPane;
    @FXML
    private TextField dealerScoreField;
    @FXML
    private TextField tokensField;
    @FXML
    private Button hitButton;
    @FXML
    private Button stayButton;
    @FXML
    private Button quitButton;
    
    private Game currentGame;
    private ChangeListener<Number> tokensListener;
    private ChangeListener<Number> playerScoreListener;
    private ChangeListener<Number> dealerScoreListener;
    private ChangeListener<ArrayList> gameDeckListener;
    private ListChangeListener<Card> playerDeckListener;
    private ListChangeListener<Card> dealerDeckListener;
    
    
    public void updatePlayerCards() {
        playerPlayPane.getChildren().clear();
        for (Object o : currentGame.playerDeck.cardsProperty().toArray()) {
            Card c = (Card) o;
            ImageView cardView = new ImageView();
            String path = "/resources/" + c.getFace() + "." + c.getSuit() + ".png";
            //System.out.println(path);
            URL is = getClass().getResource(path);
            //System.out.println(is);
            cardView.setImage(
                    new Image(is.toExternalForm()));
            playerPlayPane.getChildren().add(cardView);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentGame = new Game();
        tokensField.setText("tokens: " + currentGame.playerTokensProperty.get());
        tokensListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, 
                    Number oldValue, Number newValue) {
                tokensField.setText("tokens: " + newValue);
            }
        };
        currentGame.playerTokensProperty.addListener(tokensListener);
        
        playerDeckListener = new ListChangeListener<Card>() {
            
            @Override
            public void onChanged(ListChangeListener.Change<? extends Card> c) {
                updatePlayerCards();
            }
        };
        
        currentGame.playerDeck.cardsProperty().addListener(playerDeckListener);
        
        dealerDeckListener = new ListChangeListener<Card>() {
            
            @Override
            public void onChanged(ListChangeListener.Change<? extends Card> c) {
                updatePlayerCards();
            }
        };
        
        currentGame.dealerDeck.cardsProperty().addListener(dealerDeckListener);
       
        hitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("BUTTON PRESSED");
                currentGame.draw();
            }
            
        });
    }   
    

}
