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
    
    
    public void botMove() {
        player_Bot.getSelection();
        Random rand = new Random();
        boolean validMove = false;
        while (!validMove) {
            int x = rand.nextInt(3);
            int y = rand.nextInt(3);
            if (gridGame[x][y] == 0) {
                makeMove(x, y, 2); // Bot es el jugador 2
                validMove = true;
            }
        }
    }
    public void startRound() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            printGrid();
            if (currentPlayer == player_User) {
                // Turno del jugador
                System.out.println("Jugador (X), elige fila y columna (0, 1, 2): ");
                
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (makeMove(x, y, 1)) {
                    if (checkWinner()) {
                        printGrid();
                        System.out.println("¡El jugador gana!");
                        gameRunning = false;
                    } else if (checkDraw()) {
                        printGrid();
                        System.out.println("¡Es un empate!");
                        gameRunning = false;
                    } else {
                        switchPlayer();
                    }
                } else {
                    System.out.println("Movimiento inválido. Inténtalo de nuevo.");
                }
            } else {
                // Turno del bot
                System.out.println("Turno del bot (O): ");
                botMove();
                if (checkWinner()) {
                    printGrid();
                    System.out.println("¡El bot gana!");
                    gameRunning = false;
                } else if (checkDraw()) {
                    printGrid();
                    System.out.println("¡Es un empate!");
                    gameRunning = false;
                } else {
                    switchPlayer();
                }
            }
        }

        scanner.close();
    }
    
    
    
}
//    private void makeBotMove() {
//    if (currentPlayer == player_Bot) {
//        boolean validMove = false;
//        while (!validMove) {
//            player_Bot.getSelection().makeSelection(); 
//            Selection botSelection = player_Bot.getSelection();
//
//            if (gridGame[botSelection.getY()][botSelection.getX()] == 0) {
//                playMove(player_Bot); 
//                validMove = true;
//                System.out.println("Bot made a move.");
//            }
//        }
//    }
//}
//    private void switchPlayer() {
//        currentPlayer = (currentPlayer == player_User) ? player_Bot : player_User;
//    }
//    private boolean checkWinner() {
//        for (int i = 0; i < 3; i++) {
//            if (gridGame[i][0] == gridGame[i][1] && gridGame[i][1] == gridGame[i][2] && gridGame[i][0] != 0) return true;
//            if (gridGame[0][i] == gridGame[1][i] && gridGame[1][i] == gridGame[2][i] && gridGame[0][i] != 0) return true;
//        }
//        if (gridGame[0][0] == gridGame[1][1] && gridGame[1][1] == gridGame[2][2] && gridGame[0][0] != 0) return true;
//        if (gridGame[0][2] == gridGame[1][1] && gridGame[1][1] == gridGame[2][0] && gridGame[0][2] != 0) return true;
//        return false;
//    }
//    private boolean checkDraw() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (gridGame[i][j] == 0) return false; 
//            }
//        }
//        return true;  
//    }