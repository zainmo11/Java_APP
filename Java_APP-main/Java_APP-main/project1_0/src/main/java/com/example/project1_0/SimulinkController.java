package com.example.project1_0;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class SimulinkController {
    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane Anchorid;
    @FXML
    private Button importt;

    public static String filePath;
    public static SceneLoader loader;
    public static boolean fileSelected = false;

    public void handelbutton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("MDL Files", "*.mdl"));
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            File[] files = selectedFile.listFiles((dir, name) -> name.toLowerCase().endsWith(".mdl"));
            filePath = selectedFile.getPath();
            fileSelected = true;
            String path = SimulinkController.filePath;
            loader = new SceneLoader(path, SimulinkApplication.root);

            loader.parseFile();
            loader.drawScene();


        }
    }

    public void handleButton1(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");

        // Show save file dialog
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile != null) {
            // File was selected, do something with it
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    public void handleInfoButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Program Information");

        String contentText = "  This program serves as a viewer for Simulink files and is available as a free sample for use.\n"
                + "  While we have made an effort to cover the basic project tasks\n   our limited time constraints have prevented us from completing all aspects.\n"
                + "  However, we plan to resume working on this project during the summer.\n"
                + "  You can find the project on GitHub at the following link: https://github.com/zainmo11/Java_APP.git.\n"
                + "  We hope you will find it enjoyable.\n"
                + "  Contributors to this project include:\n"
                + "  Abdelrhman Zain Mohamed (ID: 2101646)\n"
                + "  Abdelrhman Atef Hamada (ID: 2101645)";

        Text text = new Text(contentText);
        text.setWrappingWidth(700); // Set the desired width of the content text
        text.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setPrefWidth(750); // Set the desired width of the dialog pane
        dialogPane.setContent(text);
        // Create a context menu with a "Copy" menu item
        ContextMenu contextMenu = new ContextMenu();
        MenuItem copyMenuItem = new MenuItem("Copy");
        copyMenuItem.setOnAction(e -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(contentText);
            clipboard.setContent(clipboardContent);
        });
        contextMenu.getItems().add(copyMenuItem);
        text.setOnContextMenuRequested(e -> contextMenu.show(text, e.getScreenX(), e.getScreenY()));
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        alert.initOwner(stage);
        alert.showAndWait();
    }

}