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
public class botHardSelection  implements Selection{
    private int x;
    private int y;
    
    @Override
    public void makeSelection() {
        int[][] board = Game.getInstance().getGridGame();
        boolean moveMade = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 2;
                    if (checkWinner(board, 2)) {
                        x = i;
                        y = j;
                        moveMade = true;
                        board[i][j] = 0; 
                        break;
                    }
                    board[i][j] = 0; 
                }
            }
            if (moveMade) break;
        }
        if (!moveMade) {
            Random rand = new Random();
            do {
                x = rand.nextInt(3);
                y = rand.nextInt(3);
            } while (board[x][y] != 0);
        }
    }
    private boolean checkWinner(int[][] board, int player) {
        // Verifica si el jugador especificado ha ganado con el tablero actual
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return y;
    }
    
}
