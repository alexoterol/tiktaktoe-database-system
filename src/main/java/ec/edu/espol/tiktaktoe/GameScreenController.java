/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tiktaktoe;

import Classes.Game;
import Classes.Round;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private Game game;
    private Round currentRound;
    Button[][] buttons = new Button[3][3];
    private int winsBot;
    private int winsUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = Game.getInstance();
        startNewRound();
        userName.setText(game.getPlayer().getName());
        winsBot = 0;
        winsUser = 0;
        setWinLabels();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setMinSize(120, 80);
                gridGame.add(button, col, row);
                buttons[row][col] = button;
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> {
                    try {
                        handleButtonClick(finalRow, finalCol);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }
        }
        Platform.runLater(() -> {
            firstBotCase();
        });
    }
    
    private void handleButtonClick(int row, int col) throws IOException {
        if (buttons[row][col].getText().isEmpty() || buttons[row][col].getText().equals("") ) {
            currentRound.makeMove(row, col, 1);
            buttons[row][col].setText("X");
            currentRound.printGrid();

            validateWinnerRound();
            if(!currentRound.checkWinner()){
                validateRoundDraw();
            }
            if(!(currentRound.checkWinner() || currentRound.checkDraw())){
                 if(currentRound.isPlayerTurn()){
                    currentRound.switchPlayer();
                    currentRound.getPlayer_Bot().getSelection().makeSelection();
                    currentRound.makeMove(currentBotSelectionY(), currentBotSelectionX(), 2);
                    buttons[currentBotSelectionY()][currentBotSelectionX()].setText("O");
                    currentRound.printGrid();

                    validateWinnerRound();
                    validateRoundDraw();
                    }
                
                }
            }
        if(!currentRound.isPlayerTurn()){
            currentRound.switchPlayer();
        }      
    }

    private void startNewRound() {
        game.startNewRound();
        currentRound = game.getRounds().get(game.getRounds().size() - 1);
        clearGrid();
        setWinLabels();
    }

    private void clearGrid() {
        for (Node node : gridGame.getChildren()) {
            if (node instanceof Button) {
                ((Button) node).setText("");
            }
        }
    }

    @FXML
    private void backScreen() throws IOException {
        App.setRoot("Primary");
    }
    
    @FXML
    private void nextScreen() throws IOException {
        App.setRoot("FinalScreen");
    }

    @FXML
    private void spaceSelected(MouseEvent event) {
    }

    private void validateRoundDraw() throws IOException{
        if (currentRound.checkDraw()){
            if(game.getRoundNum()<=game.getNumberRounds()){
                createRound();
                System.out.println("Empate, nueva ronda");
            }else{
                nextScreen();
                System.out.println("Empataron");
                game.getPlayer().addGame();
                game.resetGame();
            }
        }
    }
    
    private void validateWinnerRound() throws IOException{
        if (currentRound.checkWinner()) {
            System.out.println(currentRound.isPlayerTurn()  ? "Jugador gana!" : "Bot gana!");
            if(currentRound.isPlayerTurn()){
                System.out.println("11111111111111");
                game.getPlayer().addRoundWins();
                winsUser += 1;
            }else if(!currentRound.isPlayerTurn()){
                System.out.println("22222222222222222");
                winsBot += 1;
            }
            if(game.getRoundNum()<game.getNumberRounds()){
                createRound();
                System.out.println("Gana, Next Round");
            }else{
                nextScreen();
                if(winsBot==winsUser){
                    System.out.println("Fue un empate");
                    
                }else if(winsBot<winsUser){ 
                    game.getPlayer().addGameWins();
                    System.out.println("Ganaste "+ userName.getText());
                }else{ 
                    System.out.println("Gana el bot");
                }
                game.getPlayer().addGame();
                game.resetGame();
            }
        }
    }
    
    private int currentBotSelectionY(){
        return currentRound.getPlayer_Bot().getSelection().getY();
    }
    
    private int currentBotSelectionX(){
        return currentRound.getPlayer_Bot().getSelection().getX();
    }
    
    private void firstBotCase(){
        currentRound.startRound();
        if(!currentRound.isPlayerTurn()){
            buttons[currentBotSelectionY()][currentBotSelectionX()].setText("O");
            currentRound.switchPlayer();
        }
    }
    
    private void setWinLabels(){
        userRoundsWon.setText(winsUser+"");
        botRoundsWon.setText(winsBot+"");
    }
    
    private void createRound(){
        if(game.getRoundNum()<game.getNumberRounds()){
            startNewRound();
            firstBotCase();
        }
    }
}