/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author alexo
 */
public class userSelection implements Selection{
    int x;
    int y;

    public userSelection(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    
    @Override
    public void makeSelection() {
        
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
