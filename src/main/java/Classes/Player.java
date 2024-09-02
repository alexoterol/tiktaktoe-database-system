/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author alexo
 */
public class Player{
    private String name;
    private int games;
    private int gameWins;
    private int rounds;
    private int roundWins;
    private int score;

    public Player(String name, int games, int gameWins, int rounds, int roundWins, int score) {
        this.name = name;
        this.games = games;
        this.gameWins = gameWins;
        this.rounds = rounds;
        this.roundWins = roundWins;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }

    public int getGames() {
        return games;
    }

    public int getGameWins() {
        return gameWins;
    }

    public int getRounds() {
        return rounds;
    }

    public int getRoundWins() {
        return roundWins;
    }

    public int getScore() {
        return score;
    }

    public void addGame() {
        this.games = games + 1;
    }

    public void addGameWins() {
        this.gameWins = gameWins + 1;
    }

    public void addRounds() {
        this.rounds = rounds + 1;
    }

    public void addRoundWins() {
        this.roundWins = roundWins + 1;
    }

    public void addScore() {
        // It depends
    }
}
