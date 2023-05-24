package com.example.project1_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
	
	private static Parent root;
    @Override
    public void start(Stage stage) throws IOException {
		
		/*
		
        root = (Parent)FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        SceneLoader loader = new SceneLoader("C:\\Users\\Abdelrahman\\Downloads\\Example.mdl", root);
        loader.parseFile();
        loader.drawScene();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 720.0, 640.0));
        primaryStage.show();
		*/
		
		
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String iconPath = "file:///C:/Users/zyn66/Desktop/project1_0/My%20project-1%20(1).png";
        Image icon = new Image(iconPath);
        stage.getIcons().add(icon);
        stage.setTitle("AxZ Simulink");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}