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
                if (grid[y][x] == 0) {
                    validMove = true;
                }
            }
        }
    }
    
    private boolean blockPlayer(int[][] grid) {
    // Revisar filas, columnas y diagonales
    for (int i = 0; i < 3; i++) {
        if (checkRowForBlocking(grid, i) || checkColumnForBlocking(grid, i)) {
            return true;
        }
    }

    // Comprobación diagonal principal
    if (checkDiagonalForBlocking(grid, true)) {
        return true;
    }

    // Comprobación diagonal secundaria
    if (checkDiagonalForBlocking(grid, false)) {
        return true;
    }

    return false;
}

private boolean checkRowForBlocking(int[][] grid, int row) {
    for (int col = 0; col < 3; col++) {
        if (grid[row][col] == 0 && (grid[row][(col + 1) % 3] == 1 && grid[row][(col + 2) % 3] == 1)) {
            y = row;
            x = col;
            return true;
        }
    }
    return false;
}

private boolean checkColumnForBlocking(int[][] grid, int col) {
    for (int row = 0; row < 3; row++) {
        if (grid[row][col] == 0 && (grid[(row + 1) % 3][col] == 1 && grid[(row + 2) % 3][col] == 1)) {
            y = row;
            x = col;
            return true;
        }
    }
    return false;
}

private boolean checkDiagonalForBlocking(int[][] grid, boolean isMainDiagonal) {
    int[] indices = isMainDiagonal ? new int[]{0, 1, 2} : new int[]{2, 1, 0};
    for (int i = 0; i < 3; i++) {
        int row = isMainDiagonal ? indices[i] : indices[i];
        int col = indices[i];
        if (grid[row][col] == 0 && (grid[indices[(i + 1) % 3]][indices[(i + 1) % 3]] == 1 && grid[indices[(i + 2) % 3]][indices[(i + 2) % 3]] == 1)) {
            y = row;
            x = col;
            return true;
        }
    }
    return false;
}
}
