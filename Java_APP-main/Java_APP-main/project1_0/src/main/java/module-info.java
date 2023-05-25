module com.example.project1_0 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.xml;

    opens com.example.project1_0 to javafx.fxml;
    exports com.example.project1_0;
}