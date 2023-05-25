package com.example.project1_0;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;

public class SimulinkApplication extends Application {
	
	private static Parent root;
    public static int HEIGHT = 600;
    public static int WIDTH = 800;
    @Override
    public void start(Stage primaryStage) throws IOException {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Load the HTML file
        webEngine.load(getClass().getResource("Navbar.html").toExternalForm());

        AnchorPane root = new AnchorPane(webView);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        // Load the CSS file
        scene.getStylesheets().add(getClass().getResource("Navbar.css").toExternalForm());

        SceneLoader loader = new SceneLoader("C:\\Users\\Abdelrahman\\Desktop\\MDL-File-Viewer\\project1_0\\src\\main\\resources\\com\\example\\project1_0\\Example.mdl", root);
        loader.parseFile();
        loader.drawScene();

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
               loader.close();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}