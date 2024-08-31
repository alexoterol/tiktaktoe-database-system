package ec.edu.espol.tiktaktoe;

import Classes.Authentication;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private TextField nameLogIn;
    @FXML
    private TextField passwordLogIn;
    @FXML
    private Button secondaryButton;
    
    private Authentication auth;

    @FXML
    private void autenticityButton() throws IOException {
        // Auth method creating auth class
        auth = new Authentication(nameLogIn.getText(), passwordLogIn.getText());
        auth.authenticateUser();
        App.setRoot("difficultySelecter");
    }

    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("registration");
    }

    @FXML
    private void backScreen() throws IOException {
        App.setRoot("primary");
    }
}