package ec.edu.espol.tiktaktoe;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button primaryButton;
    @FXML
    private Button exitButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void exitProgram() {
        Platform.exit();
    }
}
