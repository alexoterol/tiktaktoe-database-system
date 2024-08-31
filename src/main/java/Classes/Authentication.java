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
    String name;
    String password;

    public Authentication(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public boolean authenticateUser(){
        // Search at database and return true if exist.
        return true;
    }
    
    
}
