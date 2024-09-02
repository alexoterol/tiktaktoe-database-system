/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;

/**
 *
 * @author alexo
 */
public class Round {
    private int[][] gridGame;
    private Player currentPlayer;
    private Player player_User;
    private Player player_Bot;

    public Round(Player player_User, Player player_Bot) {
        this.gridGame = Game.getInstance().getGridGame();
        this.player_User = player_User;
        this.player_Bot = player_Bot;
        if(new Random().nextBoolean()) currentPlayer=player_User;
        else this.currentPlayer = player_Bot;
    }
    
    public void playMove(Selection select) {
        if (gridGame[select.getY()][select.getX()] == 0) {
            gridGame[select.getY()][select.getX()] = (currentPlayer == player_User) ? 1 : 2;
            if (checkWinner()) {
                System.out.println("Player " + (currentPlayer == player_User ? "User" : "Bot") + " wins!");
            } else if (checkDraw()) {
                System.out.println("The game is a draw!");
            } else {
                switchPlayer();

                // Lógica adicional para el bot si es necesario
            }
        }
    }
    
    
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player_User) ? player_Bot : player_User;
    }
    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (gridGame[i][0] == gridGame[i][1] && gridGame[i][1] == gridGame[i][2] && gridGame[i][0] != 0) return true;
            if (gridGame[0][i] == gridGame[1][i] && gridGame[1][i] == gridGame[2][i] && gridGame[0][i] != 0) return true;
        }
        if (gridGame[0][0] == gridGame[1][1] && gridGame[1][1] == gridGame[2][2] && gridGame[0][0] != 0) return true;
        if (gridGame[0][2] == gridGame[1][1] && gridGame[1][1] == gridGame[2][0] && gridGame[0][2] != 0) return true;
        return false;
    }
    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gridGame[i][j] == 0) return false;
            }
        }
        return true;
    }
}
