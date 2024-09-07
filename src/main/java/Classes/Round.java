/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;
import java.util.Scanner;
import javafx.application.Platform;

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
        this.currentPlayer = new Random().nextBoolean() ? player_User : player_Bot;
        }
    
    public boolean makeMove(int x, int y, int player) {
        if (gridGame[x][y] == 0) {
            gridGame[x][y] = player;
            return true;
        }
        return false;
    }
    
    public void switchPlayer() {
        currentPlayer = (currentPlayer == player_User) ? player_Bot : player_User;
    }
    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((gridGame[i][0] == gridGame[i][1] && gridGame[i][1] == gridGame[i][2] && gridGame[i][0] != 0) ||
                (gridGame[0][i] == gridGame[1][i] && gridGame[1][i] == gridGame[2][i] && gridGame[0][i] != 0)) {
                return true;
            }
        }
        if ((gridGame[0][0] == gridGame[1][1] && gridGame[1][1] == gridGame[2][2] && gridGame[0][0] != 0) ||
            (gridGame[0][2] == gridGame[1][1] && gridGame[1][1] == gridGame[2][0] && gridGame[0][2] != 0)) {
            return true;
        }
        return false;
    }
    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gridGame[i][j] == 0) return false;
            }
        }
        return true;
    }
    public void printGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gridGame[i][j] == 0) {
                    System.out.print("- ");
                } else if (gridGame[i][j] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }    

    public void startRound() {
        if(!isPlayerTurn()){
            player_Bot.getSelection().makeSelection();
            makeMove(player_Bot.getSelection().getY(), player_Bot.getSelection().getX(), 2);
        }
        printGrid();
    }

    public Player getPlayer_Bot() {
        return player_Bot;
    }
    public boolean isPlayerTurn(){
        return currentPlayer == player_User;
    }
}