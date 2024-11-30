/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.tiktaktoe.database.system;

import BDClasses.BDConnection;
import Classes.Game;
import Classes.Grid;
import Classes.Match;
import Classes.Player;
import Classes.Selection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author alexo
 */

public class TiktaktoeDatabaseSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Player currentPlayer; // Usuario logueado
    private static int userWins = 0; // Partidas ganadas por el usuario
    private static int botWins = 0; // Partidas ganadas por el bot
    private static BDConnection dbConnection = new BDConnection(); // Conexión a la base de datos

    public static void main(String[] args) {
        dbConnection.connect(); // Conectar a la base de datos
        dbConnection.createTable(); // Crear la tabla de usuarios si no existe

        while (true) {
            System.out.println("Bienvenido a TicTacToe");
            System.out.println("1. Sign In");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Selecciona una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    signIn();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.out.println("Gracias por jugar. ¡Adiós!");
                    dbConnection.closeConnection(); // Cerrar la conexión antes de salir
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void signIn() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        if (dbConnection.authenticateUser(username, password)) {
            System.out.println("Inicio de sesión exitoso.");
            currentPlayer = dbConnection.getUser(username); // Obtener el usuario desde la base de datos
            gameMenu();
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    private static void register() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Repite la contraseña: ");
        String confirmPassword = scanner.nextLine();

        if (password.equals(confirmPassword)) {
            if (dbConnection.registerUser(username, password)) {
                System.out.println("Registro exitoso.");
            } else {
                System.out.println("Error al registrar usuario.");
            }
        } else {
            System.out.println("Las contraseñas no coinciden.");
        }
    }

    private static void gameMenu() {
        while (true) {
            System.out.println("1. Stats");
            System.out.println("2. New Game");
            System.out.println("3. Exit");
            System.out.print("Selecciona una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    showStats();
                    break;
                case "2":
                    newGame();
                    break;
                case "3":
                    System.out.println("Volviendo al menú principal...");
                    dbConnection.updateUserStats(currentPlayer); // Guardar las estadísticas del usuario antes de salir
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void showStats() {
        System.out.println("Estadísticas de " + currentPlayer.getName());
        System.out.println("Puntaje: " + currentPlayer.getScore());
        System.out.println("Partidos jugados: " + currentPlayer.getMatches());
        System.out.println("Rondas jugadas: " + currentPlayer.getRounds());
        System.out.println("Partidos ganados: " + currentPlayer.getMatchesWon());
        System.out.println("Rondas ganadas: " + currentPlayer.getRoundsWon());
        System.out.println();
    }

    private static void newGame() {
        System.out.println("Selecciona la dificultad:");
        System.out.println("1. Easy");
        System.out.println("2. Hard");
        System.out.print("Opción: ");
        String difficulty = scanner.nextLine();

        System.out.print("Elige el número de rondas (1-15): ");
        int rounds = Integer.parseInt(scanner.nextLine());

        Match match = new Match(currentPlayer, new Player("Bot", 'O'));

        for (int i = 0; i < rounds; i++) {
            System.out.println("Ronda " + (i + 1) + " de " + rounds);
            playRound(match);
            Game.getInstance().resetGrid(); // Reiniciar el tablero después de cada ronda
        }

        // Actualizar el resultado del Match
        if (userWins > botWins) {
            System.out.println("¡GANASTE!");
            currentPlayer.winMatch(); // El jugador gana el match
        } else {
            System.out.println("PERDISTE");
        }

        System.out.println("1. Try Again");
        System.out.println("2. Exit");
        System.out.print("Selecciona una opción: ");
        String option = scanner.nextLine();

        if (option.equals("1")) {
            newGame();
        }
    }

    private static void playRound(Match match) {
        Game game = Game.getInstance();
        Grid grid = game.getGrid();
        Player bot = new Player("Bot", 'O');
        Player user = currentPlayer;

        while (true) {
            grid.printBoard();

            System.out.print("Selecciona fila (0-2): ");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.print("Selecciona columna (0-2): ");
            int col = Integer.parseInt(scanner.nextLine());

            if (!grid.makeSelection(new Selection(row, col), user.getSymbol())) {
                System.out.println("Movimiento inválido. Intenta nuevamente.");
                continue;
            }

            // Verificar si el jugador gana
            if (grid.checkWinner(user.getSymbol())) {
                System.out.println("¡Ganaste esta ronda!");
                user.winRound(); // Sumar puntos por ganar ronda
                userWins++;
                return;
            }

            // Movimiento del bot (movimiento aleatorio)
            makeBotMove(grid, bot);

            // Verificar si el bot gana
            if (grid.checkWinner(bot.getSymbol())) {
                System.out.println("El bot ganó esta ronda.");
                bot.winRound(); // Sumar puntos por ganar ronda
                botWins++;
                return;
            }

            // Verificar empate
            if (grid.isDraw()) {
                System.out.println("Empate.");
                return;
            }
        }
    }

    private static void makeBotMove(Grid grid, Player bot) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (grid.makeSelection(new Selection(row, col), bot.getSymbol())) {
                break;
            }
        }
    }
}
