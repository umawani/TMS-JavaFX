module com.example.tmsass2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens main to javafx.fxml;
    exports main;
    opens main.controller to javafx.fxml;
    opens main.model to javafx.base;
}