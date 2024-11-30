/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDClasses;

import Classes.Player;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

/**
 *
 * @author alexo
 */


public class BDConnection {
    private static final String URL = "jdbc:sqlite:C:\\Users\\alexo\\Documents\\NetBeansProjects\\tiktaktoe-database-system\\src\\main\\java\\BDClasses\\databaseSQLite.db";
    private Connection connection;

    // Conectar a la base de datos
    public void connect() {
        try {
            connection = DriverManager.getConnection(URL);
            if (connection != null) {
                System.out.println("Conectado a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    // Crear la tabla de usuarios si no existe
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT UNIQUE NOT NULL,"
                + "password TEXT NOT NULL,"
                + "score INTEGER DEFAULT 0,"
                + "matches INTEGER DEFAULT 0,"
                + "matches_won INTEGER DEFAULT 0,"
                + "rounds INTEGER DEFAULT 0,"
                + "rounds_won INTEGER DEFAULT 0)";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    // Registrar un nuevo usuario con Base64
    public boolean registerUser(String username, String password) {
        String encodedPassword = encodePassword(password);
        String sql = "INSERT INTO users (name, password) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, encodedPassword);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al registrar el usuario: " + e.getMessage());
            return false;
        }
    }

    // Autenticar un usuario
    public boolean authenticateUser(String username, String password) {
        String sql = "SELECT password FROM users WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedEncodedPassword = rs.getString("password");
                return decodePassword(storedEncodedPassword).equals(password); // Compara la contraseña codificada con la introducida
            }
        } catch (SQLException e) {
            System.err.println("Error de autenticación: " + e.getMessage());
        }
        return false;
    }

    // Codificar la contraseña a Base64
    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    // Decodificar la contraseña desde Base64
    private String decodePassword(String encodedPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        return new String(decodedBytes);
    }

    // Obtener los datos del usuario desde la base de datos
    public Player getUser(String username) {
    String sql = "SELECT * FROM users WHERE name = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            int score = rs.getInt("score");
            int matches = rs.getInt("matches");
            int rounds = rs.getInt("rounds");
            int roundsWon = rs.getInt("rounds_won");
            int matchesWon = rs.getInt("matches_won"); // Obtener matches_won
            return new Player(name, 'X', score, matches, rounds, roundsWon, matchesWon); // Añadir matches_won
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener los datos del usuario: " + e.getMessage());
    }
    return null;
}


    // Actualizar las estadísticas del jugador
    public void updateUserStats(Player player) {
    String sql = "UPDATE users SET score = ?, matches = ?, rounds = ?, rounds_won = ?, matches_won = ? WHERE name = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, player.getScore());
        pstmt.setInt(2, player.getMatches());
        pstmt.setInt(3, player.getRounds());
        pstmt.setInt(4, player.getRoundsWon());
        pstmt.setInt(5, player.getMatchesWon()); // Actualizar matches_won
        pstmt.setString(6, player.getName());
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Error al actualizar las estadísticas: " + e.getMessage());
    }
}


    // Cerrar la conexión a la base de datos
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
