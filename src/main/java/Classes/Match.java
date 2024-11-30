/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author alexo
 */
import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Round> rounds;  // Lista de rondas
    private Player player1;      // Jugador 1
    private Player player2;      // Jugador 2
    private Player winner;       // Ganador del match

    public Match(Player player1, Player player2) {
        this.rounds = new ArrayList<>();
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startNewRound() {
        Round round = new Round(player1, player2);
        round.playRound();
        rounds.add(round);

        // Actualizar ganador del match
        updateMatchWinner();
    }

    private void updateMatchWinner() {
        int winsPlayer1 = 0;
        int winsPlayer2 = 0;

        for (Round round : rounds) {
            if (round.getWinner() == player1) {
                winsPlayer1++;
            } else if (round.getWinner() == player2) {
                winsPlayer2++;
            }
        }

        if (winsPlayer1 > winsPlayer2) {
            winner = player1;
        } else if (winsPlayer2 > winsPlayer1) {
            winner = player2;
        }
    }

    public Player getWinner() {
        return winner;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    @Override
    public String toString() {
        return "Match between " + player1.getName() + " and " + player2.getName() + ", Winner: " +
               (winner != null ? winner.getName() : "No winner yet");
    }
}
