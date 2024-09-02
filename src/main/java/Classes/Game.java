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
    private int[][] gridGame;
    private List<Round> rounds;
    private Player player_User;
    private Player player_Bot;
    private int numberRounds;
    
    private static Game instanceGame;
    
    private Game() {
        this.gridGame = new int[3][3];
        this.rounds = new ArrayList<>();
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
    
    public void setPlayer(Player p){
        this.player_User = p;
    }
    
    public void setBot(){
        //  Complete method
    }
    public int[][] getGridGame(){
        return this.gridGame;
    }
    
    public void startNewRound() {
        Round round = new Round(player_User, player_Bot);
        rounds.add(round);
    }
    
    public List<Round> getRounds() {
        return rounds;
    }
    
    public void resetGame() {
        this.gridGame = new int[3][3];
        this.rounds.clear();
        this.numberRounds = 0;
    }
}
