/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author alexo
 */
public class Player {
    private String name;  // Nombre del jugador
    private char symbol;  // Símbolo del jugador ('X' o 'O')
    private int score;    // Puntos acumulados
    private int matches;  // Total de partidos jugados
    private int rounds;   // Total de rondas jugadas
    private int matches_won; // Partidos ganados
    private int rounds_won;  // Rondas ganadas

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
        this.matches = 0;
        this.rounds = 0;
        this.matches_won = 0;
        this.rounds_won = 0;
    }

    public Player(String name, char symbol, int score, int matches, int rounds, int matches_won, int rounds_won) {
        this.name = name;
        this.symbol = symbol;
        this.score = score;
        this.matches = matches;
        this.rounds = rounds;
        this.matches_won = matches_won;
        this.rounds_won = rounds_won;
    }
    
    

    // Getter para el nombre del jugador
    public String getName() {
        return name;
    }

    // Getter para el símbolo del jugador
    public char getSymbol() {
        return symbol;
    }

    // Método para realizar una selección
    public Selection makeMove(int row, int col) {
        return new Selection(row, col);
    }

    // Método para actualizar el score cuando el jugador gana una ronda
    public void winRound() {
        score += 10;
        rounds_won++;
        rounds++;
    }

    // Método para actualizar el score cuando el jugador gana un match
    public void winMatch() {
        score += 100;
        matches_won++;
        matches++;
    }

    public int getScore() {
        return score;
    }

    public int getMatches() {
        return matches;
    }

    public int getRounds() {
        return rounds;
    }

    public int getMatchesWon() {
        return matches_won;
    }

    public int getRoundsWon() {
        return rounds_won;
    }

    @Override
    public String toString() {
        return "Player[name=" + name + ", symbol=" + symbol + ", score=" + score + ", matches=" + matches + ", rounds=" + rounds + ", matches_won=" + matches_won + ", rounds_won=" + rounds_won + "]";
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void setMatchesWon(int matches_won) {
        this.matches_won = matches_won;
    }

    public void setRoundsWon(int rounds_won) {
        this.rounds_won = rounds_won;
    }
}

