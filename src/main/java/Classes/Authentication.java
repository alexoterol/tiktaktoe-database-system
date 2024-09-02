/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author alexo
 */
public class Authentication {
    //DataBase
    private String name;
    private String password;

    public Authentication(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public Player authenticateUser(){
        // Search at database and return player if exist.
        int games = 0;
        int gameWins = 0;
        int rounds = 0;
        int roundWins = 0;
        int score = 0;
        return new Player(name, games, gameWins, rounds, roundWins, score);// Player with atributes at database
    }
}
