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
public class BotSelection extends Selection{
    
    public BotSelection(int x, int y) {
        super(x, y);
    }
    
    public void makeSelection(){
        int[][] grid = Game.getInstance().getGridGame();
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
