/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package Classes;

import Classes.Selection.Selection;
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
    private int roundNum;
    
    private static Game instanceGame;
    
    private Game() {
        this.rounds = new ArrayList<>();
        this.player_Bot = new Player("Bot", 0,0,0,0,0);
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
    
    public void setBot(Selection s){
        player_Bot.setStrategy(s);
    }
    
    public int[][] getGridGame(){
        return this.gridGame;
    }
    
    public void startNewRound() {
        Round round = new Round(player_User, player_Bot);
        rounds.add(round);
        roundNum += 1;
        this.gridGame = new int[3][3];
        player_User.addRounds();
    }
    
    public List<Round> getRounds() {  // ENCAPTULATE COLLECTION
        return rounds;
    }
    
    public void resetGame() {
        this.gridGame = new int[3][3];
        this.rounds.clear();
        this.numberRounds = 0;
        this.roundNum = 0;
    }

    public int getNumberRounds() {
        return numberRounds;
    }

    public void setNumberRounds(int numberRounds) {
        this.numberRounds = numberRounds;
    }

    public int getRoundNum() {
        return roundNum;
    }
    
}
