package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.au.edu.uts.ap.javafx.Controller;
import main.model.InputException;

import java.util.LinkedList;
import java.util.List;

public class ErrorController extends Controller<List<String>> {

    @FXML private VBox errorList;

    @FXML private Text errorText;

    @FXML
    private void initialize(){
        List<String> errors =  model;
        String errorTexts = "";
        for (String error : errors) {
            errorTexts += error;
        }
        errorText.setText(errorTexts);
    }

    @FXML
    private void onClose(ActionEvent e){
        stage.close();
    }
   

}
