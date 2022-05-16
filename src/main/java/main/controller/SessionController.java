package main.controller;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.au.edu.uts.ap.javafx.Controller;
import main.au.edu.uts.ap.javafx.ViewLoader;
import main.model.Session;

public class SessionController extends Controller<Session> {
    @FXML
    private void handleLogin(ActionEvent e) throws Exception{
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image(Application.class.getClassLoader().getResource("book.png").toURI().toString()));
        newStage.setX(ViewLoader.X);
        newStage.setY(ViewLoader.Y);
        ViewLoader.showStage(model, "login.fxml", "Sign In", newStage);
    }

    @FXML
    private void handleExit(ActionEvent e){
        stage.close();
    }

}
