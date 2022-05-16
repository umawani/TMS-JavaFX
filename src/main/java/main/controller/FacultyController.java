package main.controller;


import javafx.beans.binding.ListBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.au.edu.uts.ap.javafx.Controller;
import main.au.edu.uts.ap.javafx.ViewLoader;
import main.model.Faculty;
import main.model.Student;
import main.model.TMS;

public class FacultyController extends Controller<Faculty> {

    Faculty faculty;

    @FXML private TableView<Student> studentTable;

    @FXML private TextField nameFilter;

    @FXML private TextField emailFilter;

    @FXML
    private void initialize(){
        faculty = model;
        studentTable.setItems(faculty.getStudents());
        nameFilter.textProperty().addListener(observable -> {
            if(!nameFilter.getText().isEmpty()){
                faculty.filterList(nameFilter.getText(), "$ $");
            }
            else{
                if(!emailFilter.getText().isEmpty()){
                    faculty.filterList("$ $", emailFilter.getText());
                }
                else{
                    faculty.filterList("", "");
                }
            }
        });
        emailFilter.textProperty().addListener(observable -> {
            if(nameFilter.getText().isEmpty()){
                if(!emailFilter.getText().isEmpty()){
                    faculty.filterList("$ $", emailFilter.getText());
                }
                else{
                    faculty.filterList("", "");
                }
            }
        });

    }

    @FXML
    private void handleClose(ActionEvent e){
        stage.close();
    }

    @FXML
    private void handleSlip(ActionEvent e) throws Exception{
        Student s = studentTable.getSelectionModel().getSelectedItem();
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image(FacultyController.class.getClassLoader().getResource("edit.png").toURI().toString()));
        newStage.setX(ViewLoader.X);
        newStage.setY(ViewLoader.Y);
        newStage.setUserData(s);
        ViewLoader.showStage(s, "slip.fxml", s.getName() + " SLIP Report", newStage);
    }

    @FXML
    private void handleDelete(ActionEvent e){
        Student s = studentTable.getSelectionModel().getSelectedItem();
        faculty.removeStudent(s);
    }

    @FXML
    private void handleReport(ActionEvent e) throws Exception{
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image(FacultyController.class.getClassLoader().getResource("uts.jpeg").toURI().toString()));
        newStage.setX(ViewLoader.X);
        newStage.setY(ViewLoader.Y);
        ViewLoader.showStage(new TMS(faculty), "tms.fxml", "TMS Report", newStage);
    }

    @FXML
    private void handleAdd(ActionEvent e) throws Exception{
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image(FacultyController.class.getClassLoader().getResource("edit.png").toURI().toString()));
        newStage.setX(ViewLoader.X);
        newStage.setY(ViewLoader.Y);
        ViewLoader.showStage(faculty, "student.fxml", "Adding New Student", newStage);
    }
    
}
