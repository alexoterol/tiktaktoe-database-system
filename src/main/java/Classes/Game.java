/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package Classes;

/**
 *
 * @author alexo
 */
public class Game {
    private static Game instance; // Instancia única de Game
    private Grid grid;            // Única instancia de Grid

    private Game() {
        this.grid = new Grid(); // Instancia única del Grid
    }

    // Método para obtener la instancia única de Game
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Grid getGrid() {
        return grid;
    }

    public void resetGrid() {
        this.grid = new Grid(); // Reinicia el tablero para nuevos juegos
    }
}

