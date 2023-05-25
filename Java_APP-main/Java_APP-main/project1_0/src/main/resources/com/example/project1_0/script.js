function handleButton(event) {
    var dirChooser = new javafx.stage.DirectoryChooser();
    var stage = event.getSource().getScene().getWindow();
    var selectedDirectory = dirChooser.showDialog(stage);

    if (selectedDirectory != null) {
        console.log("Selected Directory: " + selectedDirectory.getAbsolutePath());
    }
}

function handleButton1(event) {
    var fileChooser = new javafx.stage.FileChooser();
    fileChooser.setTitle("Save File");

    // Show save file dialog
    var stage = event.getSource().getScene().getWindow();
    var selectedFile = fileChooser.showSaveDialog(stage);

    if (selectedFile != null) {
        // File was selected, do something with it
        console.log("Selected file: " + selectedFile.getAbsolutePath());
    }
}


