module com.example.project1_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project1_0 to javafx.fxml;
    exports com.example.project1_0;
}