/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataBase;

/**
 *
 * @author alexo
 */
public class Register {
    // Database
    private String name;
    private String password;

    public Register(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public boolean saveUser(){
        // en database registrar apropiadamente
        // Search at database and return true if exist.
        return true;
    }
}