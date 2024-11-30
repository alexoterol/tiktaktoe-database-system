/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author alexo
 */
public class Round {
    private Player player1; // Jugador 1
    private Player player2; // Jugador 2
    private Player winner;  // Ganador de la ronda (puede ser null)
    private boolean isDraw; // Indica si hubo empate

    public Round(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.isDraw = false; // Por defecto, no hay empate
    }

    public void playRound() {
        Game game = Game.getInstance();
        Grid grid = game.getGrid();
        
        // Simulación de lógica para determinar ganador (puedes agregar interacción real)
        if (grid.checkWinner(player1.getSymbol())) {
            this.winner = player1;
        } else if (grid.checkWinner(player2.getSymbol())) {
            this.winner = player2;
        } else if (grid.isDraw()) {
            this.isDraw = true;
        }
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isDraw() {
        return isDraw;
    }

    @Override
    public String toString() {
        if (winner != null) {
            return "Round winner: " + winner.getName();
        } else if (isDraw) {
            return "Round ended in a draw.";
        }
        return "Round in progress.";
    }
}
