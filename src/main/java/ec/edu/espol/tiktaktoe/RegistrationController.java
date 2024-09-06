/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tiktaktoe;

import Classes.DataBase.Register;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alexo
 */
public class RegistrationController implements Initializable {

    @FXML
    private TextField nameNewUser;
    @FXML
    private TextField passwrdNewUser;
    
    private Register register;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToLogIn() throws IOException {
        register = new Register(nameNewUser.getText(), passwrdNewUser.getText());
        register.saveUser();
        App.setRoot("secondary");
    }

    @FXML
    private void exitButton() {
        Platform.exit();
    }
    
}
