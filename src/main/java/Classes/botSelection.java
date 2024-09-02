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
public class botSelection implements Selection {
    private static final Random RANDOM = new Random();
    private int x;
    private int y;
    
    @Override
    public void makeSelection() {
        x = RANDOM.nextInt(3);
        y = RANDOM.nextInt(3);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
}
