/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tiktaktoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author alexo
 */
public class FinalScreenController implements Initializable {

    @FXML
    private Label finalResult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playAgain(ActionEvent event) throws IOException {
        // update dataUser in database
        App.setRoot("DifficultySelecter");
    }

    @FXML
    private void initialScreen(ActionEvent event) throws IOException {
        // update datauser in database
        // delete current user session
        App.setRoot("primary");
    }

    @FXML
    private void exitBtn() {
        Platform.exit();
    }
    
}
