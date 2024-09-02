/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tiktaktoe;

import Classes.Game;
import Classes.Round;
import Classes.userSelection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author alexo
 */
public class GameScreenController implements Initializable {

    @FXML
    private Label userName;
    @FXML
    private Label userRoundsWon;
    @FXML
    private Label botRoundsWon;
    @FXML
    private GridPane gridGame;
    @FXML
    private Button btn00;
    @FXML
    private Button btn01;
    @FXML
    private Button btn02;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private Button btn20;
    @FXML
    private Button btn21;
    @FXML
    private Button btn22;
    
    private Game game;
    private Round currentRound;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = Game.getInstance();
        game.startNewRound();
        currentRound = game.getRounds().get(game.getRounds().size()-1);
        clearGrid();
        userName.setText(game.getPlayer().getName());
    }    

    @FXML
    private void spaceSelected(MouseEvent event) {
        
    }

    @FXML
    private void backScreen() throws IOException {
        // Cancel current game and add +1 in user Rounds and user Games
        App.setRoot("Primary");
    }

    @FXML
    private void btn00(ActionEvent event) {
        currentRound.playMove(new userSelection(0,0));
        btn00.setText("X");

    }

    @FXML
    private void btn01(ActionEvent event) {
        currentRound.playMove(new userSelection(1,0));
        btn01.setText("X");
    }

    @FXML
    private void btn02(ActionEvent event) {
        currentRound.playMove(new userSelection(2,0));
        btn02.setText("X");
    }

    @FXML
    private void btn10(ActionEvent event) {
        currentRound.playMove(new userSelection(0,1));
        btn10.setText("X");
    }

    @FXML
    private void btn11(ActionEvent event) {
        currentRound.playMove(new userSelection(1,1));
        btn11.setText("X");
    }

    @FXML
    private void btn12(ActionEvent event) {
        currentRound.playMove(new userSelection(2,1));
        btn12.setText("X");
    }

    @FXML
    private void btn20(ActionEvent event) {
        currentRound.playMove(new userSelection(0,2));
        btn20.setText("X");
    }

    @FXML
    private void btn21(ActionEvent event) {
        currentRound.playMove(new userSelection(1,2));
        btn21.setText("X");
    }

    @FXML
    private void btn22(ActionEvent event) {
        currentRound.playMove(new userSelection(2,2));
        btn22.setText("X");
    }
    
    private void handleStartButton() {
        game.resetGame();
        game.startNewRound();
    }
    
    private void clearGrid(){
        btn00.setText("");
        btn01.setText("");
        btn02.setText("");
        btn10.setText("");
        btn11.setText("");
        btn12.setText("");
        btn20.setText("");
        btn21.setText("");
        btn22.setText("");
    }
}
