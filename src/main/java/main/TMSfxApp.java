package main;

import main.au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import main.model.*;

public class TMSfxApp extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        stage.getIcons().add(new Image(Application.class.getClassLoader().getResource("book.png").toURI().toString()));
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        ViewLoader.showStage(new Session(), "session.fxml", "TMSFX - Faculty Mode", stage);
    }
}