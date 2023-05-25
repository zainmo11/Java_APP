package com.example.project1_0;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimulinkController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}