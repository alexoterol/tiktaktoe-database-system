package ec.edu.espol.tiktaktoe;

import Classes.Authentication;
import Classes.Player;
import java.io.IOException;
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
    private static Player player;

    @FXML
    private void autenticityButton() throws IOException {
        auth = new Authentication(nameLogIn.getText(), passwordLogIn.getText());
        player = auth.authenticateUser();
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
    
    public static Player getPlayer(){
        return player;
    }
}