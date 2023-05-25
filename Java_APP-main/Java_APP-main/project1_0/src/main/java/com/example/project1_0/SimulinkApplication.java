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
	
	private static Parent root;
    public static int HEIGHT = 600;
    public static int WIDTH = 800;
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(SimulinkApplication.class.getResource("SimulinkApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String iconPath = "file:///C:/Users/zyn66/Desktop/project1_0/My%20project-1%20(1).png";
        Image icon = new Image(iconPath);
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("AxZ Simulink");
  /*
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

       // Load the HTML file
        webEngine.load(getClass().getResource("Navbar.html").toExternalForm());

        AnchorPane root = new AnchorPane(webView);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                // Load and execute the JavaScript file
                String scriptContent = loadJavaScriptFile("script.js");
                webEngine.executeScript(scriptContent);
            }
        });
        // Load the CSS file
        scene.getStylesheets().add(getClass().getResource("Navbar.css").toExternalForm());*/
        File selectedDirectory = SimulinkController.selectedDirectory;
       /* SceneLoader loader = new SceneLoader(selectedDirectory, root);
        loader.parseFile();
        loader.drawScene();*/

        primaryStage.setScene(scene);
        primaryStage.show();

        /*primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
               loader.close();
            }
        });*/
    }
    /*private String loadJavaScriptFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }*/
    public static void main(String[] args) {
        launch();
    }
}