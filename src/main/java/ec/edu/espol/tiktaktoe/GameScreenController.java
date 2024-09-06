/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tiktaktoe;

import Classes.Game;
import Classes.Round;
import Classes.Selection.Selection;
import Classes.Selection.UserSelection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = Game.getInstance();
        startNewRound();
        userName.setText(game.getPlayer().getName());
        Platform.runLater(() -> {
            for(int i = 0 ; i < game.getNumberRounds() ; i++){
                game.startNewRound();
                startNewRound();
                game.getRounds().get(game.getRounds().size()-1).startRound();
            }
        });
    }


    // Iniciar nueva ronda y actualizar la vista
    private void startNewRound() {
        game.startNewRound();
        currentRound = game.getRounds().get(game.getRounds().size() - 1);
        clearGrid();
        
    }

    @FXML
    private void btn00(ActionEvent event) {
        playerMove(0, 0, btn00);
    }

    @FXML
    private void btn01(ActionEvent event) {
        playerMove(0, 1, btn01);
    }

    @FXML
    private void btn02(ActionEvent event) {
        playerMove(0, 2, btn02);
    }

    @FXML
    private void btn10(ActionEvent event) {
        playerMove(1, 0, btn10);
    }

    @FXML
    private void btn11(ActionEvent event) {
        playerMove(1, 1, btn11);
    }

    @FXML
    private void btn12(ActionEvent event) {
        playerMove(1, 2, btn12);
    }

    @FXML
    private void btn20(ActionEvent event) {
        playerMove(2, 0, btn20);
    }

    @FXML
    private void btn21(ActionEvent event) {
        playerMove(2, 1, btn21);
    }

    @FXML
    private void btn22(ActionEvent event) {
        playerMove(2, 2, btn22);
    }

    private void playerMove(int row, int col, Button btn) {
        Selection userSelection = new UserSelection(row, col);
        game.getPlayer().setSelection(userSelection);
//        currentRound.playMove(game.getPlayer());
        btn.setText("X");
        updateBotMove();
    }

    private void updateBotMove() {
//        currentRound.playMove(game.getPlayer_Bot());
//        Selection botSelection = game.getPlayer_Bot().getSelection();
//        Platform.runLater(() -> modifyButtonText(gridGame, botSelection.getY(), botSelection.getX(), "O"));
    }

    private void modifyButtonText(GridPane gridPane, int row, int col, String newText) {
//        gridPane.getChildren().forEach(node -> {
//            Integer nodeRow = GridPane.getRowIndex(node);
//            Integer nodeCol = GridPane.getColumnIndex(node);
//            if (nodeRow != null && nodeCol != null && nodeRow == row && nodeCol == col) {
//                if (node instanceof Button) {
//                    ((Button) node).setText(newText);
//                }
//            }
//        });
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
    private void spaceSelected(MouseEvent event) {
//        Node clickedNode = (Node) event.getSource();
//        Integer row = GridPane.getRowIndex(clickedNode);
//        Integer col = GridPane.getColumnIndex(clickedNode);
//
//        if (row != null && col != null) {
//            // Lógica para manejar la selección del espacio
//            game.getPlayer().setSelection(new userSelection(row, col));
//            currentRound.playMove(game.getPlayer());
//            modifyButtonText(gridGame, row, col, "O");
//
//            // Mueve el bot después del jugador
//            updateBotMove();}
    }
}
