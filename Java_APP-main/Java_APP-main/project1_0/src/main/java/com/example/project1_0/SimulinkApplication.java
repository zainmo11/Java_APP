package com.example.project1_0;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class SimulinkApplication extends Application {
	
	public static Parent root;
    public static int HEIGHT = 600;
    public static int WIDTH = 900;

    @Override
    public void start(Stage primaryStage) throws IOException {

        root = (Parent)FXMLLoader.load(this.getClass().getResource("SimulinkApplication.fxml"));
        String iconPath = "file:///C:/Users/zyn66/Desktop/project1_0/My%20project-1%20(1).png";
        Image icon = new Image(iconPath);
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("AxZ Simulink");

        Scene scene = new Scene(root, WIDTH, HEIGHT);


        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (SimulinkController.fileSelected)
                    SimulinkController.loader.close();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}