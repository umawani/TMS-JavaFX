package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import main.au.edu.uts.ap.javafx.Controller;
import main.model.Student;

public class SlipController extends Controller {

    Student s;
    @FXML private Text creditsText;
    @FXML private Text totalFeeText;
    @FXML private Text netFeeText;
    @FXML private Text PPCText;
    @FXML private Text scholarshipTest;
    @FXML private Text deductionText;

    @FXML private Button closeButton;

    @FXML
    private void initialize(){
        s = (Student) model;
        creditsText.textProperty().bind(s.creditsProperty().asString().concat(" credits"));
        totalFeeText.textProperty().bind(s.totalFeeProperty().asString("$%.2f"));
        netFeeText.textProperty().bind(s.netFeeProperty().asString("$%.2f"));
        PPCText.textProperty().bind(s.payPerCreditProperty().asString("$%.2f"));
        scholarshipTest.textProperty().bind(s.scholarshipProperty().asString("$%.2f"));
        deductionText.textProperty().bind(s.deductionProperty().asString("$%.2f"));
    }

    @FXML
    private void handleClose(ActionEvent e){
        stage.close();
    }

}
