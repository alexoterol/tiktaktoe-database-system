/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexo
 */
public class Game {
    private List<Round> rounds;
    private Player player_User;
    private Player player_Bot;
    private int numberRounds;
    
    private static Game instanceGame;
    
    private Game() {
        
    }
    
    public static Game getInstance(){
        if (instanceGame == null){
            instanceGame = new Game();
        }
        return instanceGame;
    }
    
    public Player getPlayer(){
        return player_User;
    }
    
    public void setBot(){
        // Lógica para jugar con un bot específico
    }
}
