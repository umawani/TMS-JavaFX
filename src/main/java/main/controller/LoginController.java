package main.controller;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.au.edu.uts.ap.javafx.Controller;
import main.au.edu.uts.ap.javafx.ViewLoader;
import main.model.Faculty;
import main.model.Session;

import java.util.Objects;

public class LoginController extends Controller {

    Session s;

    @FXML private TextField username;

    @FXML private PasswordField password;

    @FXML private Label incorrectPassLabel;

    @FXML
    private void initialize(){
        s = (Session) model;
    }

    @FXML
    private void handleLogin(ActionEvent e) throws Exception{
        Faculty f = s.getFaculty(username.getText(), password.getText());
        if(Objects.isNull(f)){
            incorrectPassLabel.setText("Incorrect Login Details");
        }
        else{
            Stage newStage = new Stage();
            newStage.getIcons().add(new Image(LoginController.class.getClassLoader().getResource("faculty.png").toURI().toString()));
            newStage.setX(ViewLoader.X);
            newStage.setY(ViewLoader.Y);
            ViewLoader.showStage(f, "faculty.fxml", "Session Admin: " + f.getName(), newStage);
        }
    }

    @FXML
    private void handleCancel(ActionEvent e){
        stage.close();
    }

    
}
