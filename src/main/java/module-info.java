module ec.edu.espol.tiktaktoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.tiktaktoe to javafx.fxml;
    exports ec.edu.espol.tiktaktoe;
}
