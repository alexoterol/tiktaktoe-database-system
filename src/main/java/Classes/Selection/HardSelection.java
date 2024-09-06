/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Selection;

import Classes.Game;
import java.util.Random;

/**
 *
 * @author alexo
 */
public class HardSelection extends BotSelection{
    
    public HardSelection(int x, int y) {
        super(x, y);
    }

    @Override
    public void makeSelection() {
        int [][] grid = Game.getInstance().getGridGame();
        if (!blockPlayer(grid)) {
            Random rand = new Random();
            boolean validMove = false;

            while (!validMove) {
                x = rand.nextInt(3);
                y = rand.nextInt(3);
                if (grid[x][y] == 0) {
                    validMove = true;
                }
            }
        }
    }
    
    private boolean blockPlayer(int[][] grid) {
        // Revisar filas y columnas
        for (int i = 0; i < 3; i++) {
            // Revisar filas
            if (grid[i][0] == 1 && grid[i][1] == 1 && grid[i][2] == 0) {
                x = i; y = 2; return true;
            }
            if (grid[i][0] == 1 && grid[i][1] == 0 && grid[i][2] == 1) {
                x = i; y = 1; return true;
            }
            if (grid[i][0] == 0 && grid[i][1] == 1 && grid[i][2] == 1) {
                x = i; y = 0; return true;
            }

            // Revisar columnas
            if (grid[0][i] == 1 && grid[1][i] == 1 && grid[2][i] == 0) {
                x = 2; y = i; return true;
            }
            if (grid[0][i] == 1 && grid[1][i] == 0 && grid[2][i] == 1) {
                x = 1; y = i; return true;
            }
            if (grid[0][i] == 0 && grid[1][i] == 1 && grid[2][i] == 1) {
                x = 0; y = i; return true;
            }
        }

        // Revisar diagonales
        if (grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 0) {
            x = 2; y = 2; return true;
        }
        if (grid[0][0] == 1 && grid[1][1] == 0 && grid[2][2] == 1) {
            x = 1; y = 1; return true;
        }
        if (grid[0][0] == 0 && grid[1][1] == 1 && grid[2][2] == 1) {
            x = 0; y = 0; return true;
        }

        if (grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 0) {
            x = 2; y = 0; return true;
        }
        if (grid[0][2] == 1 && grid[1][1] == 0 && grid[2][0] == 1) {
            x = 1; y = 1; return true;
        }
        if (grid[0][2] == 0 && grid[1][1] == 1 && grid[2][0] == 1) {
            x = 0; y = 2; return true;
        }

        return false;
    }
}
