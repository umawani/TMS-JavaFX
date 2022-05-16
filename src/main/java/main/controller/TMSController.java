package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import main.au.edu.uts.ap.javafx.Controller;
import main.model.Faculty;
import main.model.Student;
import main.model.TMS;

public class TMSController extends Controller<TMS> {

    TMS tms;

    @FXML private TableView<Student> tmsTableView;

    @FXML private Text tuitionText;
    @FXML private Text netFeeText;
    @FXML private Text basText;
    @FXML private Text scholarshipText;
    @FXML private Text deductionText;

    @FXML
    private void initialize(){
        tms = (TMS) model;
        tmsTableView.setItems(tms.getStudents());
        tuitionText.textProperty().bind(tms.totalTuitionFeeProperty().asString("$%.2f"));
        netFeeText.textProperty().bind(tms.totalNetFeeProperty().asString("$%.2f"));
        basText.textProperty().bind(tms.basProperty().asString("$%.2f"));
        scholarshipText.textProperty().bind(tms.totalScholarshipProperty().asString("$%.2f"));
        deductionText.textProperty().bind(tms.totalDeductionProperty().asString("$%.2f"));

    }

    @FXML
    private void handleClose(ActionEvent e){
        stage.close();
    }

   
}
