/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tiktaktoe;

import Classes.Game;
import Classes.Player;
import Classes.Selection.BotSelection;
import Classes.Selection.HardSelection;
import Classes.Selection.IASelection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author alexo
 */
public class DifficultySelecterController implements Initializable {

    @FXML
    private Label userName;
    @FXML
    private Label playedGames;
    @FXML
    private Label winGames;
    @FXML
    private Label numberRounds;
    @FXML
    private Label roundsWon;
    @FXML
    private Label sumScore;
    @FXML
    private Label numberRoundsUser;

    private Player user;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = SecondaryController.getPlayer();
        Game.getInstance().setPlayer(user);
        userName.setText(user.getName());
        playedGames.setText(user.getGames()+"");
        winGames.setText(user.getGameWins()+"");
        numberRoundsUser.setText(user.getRounds()+"");
        roundsWon.setText(user.getRoundWins()+"");
        sumScore.setText(user.getScore()+"");
    }    

    @FXML
    private void selectNormalDiff() throws IOException {


        App.setRoot("GameScreen");
    }

    @FXML
    private void selectHardDiff() throws IOException {
        Game.getInstance().setBot(new HardSelection(0,0));
        Game.getInstance().setNumberRounds(Integer.parseInt(numberRounds.getText()));
        App.setRoot("GameScreen");
        
    }

    @FXML
    private void selectIADiff() throws IOException {
        Game.getInstance().setBot(new IASelection(0,0));
        Game.getInstance().setNumberRounds(Integer.parseInt(numberRounds.getText()));
        App.setRoot("GameScreen");
    }

    @FXML
    private void lessRounds() {
        if(Integer.parseInt(numberRounds.getText())>1)
            numberRounds.setText(Integer.parseInt(numberRounds.getText()) - 2 + ""); 
    }

    @FXML
    private void plusRounds() {
        if(Integer.parseInt(numberRounds.getText()) < 25)
        numberRounds.setText(Integer.parseInt(numberRounds.getText()) + 2 + ""); 
    }
}
