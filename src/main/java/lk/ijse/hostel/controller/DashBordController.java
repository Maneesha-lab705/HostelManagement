package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class DashBordController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDate.setText(String.valueOf(LocalDate.now()));
        lblTime.setText(String.valueOf(LocalTime.now()));


    }

    @FXML
    private AnchorPane LoadContex;

    @FXML
    private JFXButton btnKeyMony;

    @FXML
    private JFXButton btnReseved;

    @FXML
    private JFXButton btnStudentManage;

    @FXML
    private JFXButton btnResevedDetails;

    @FXML
    private JFXButton btnRoom;

    @FXML
    private JFXButton btnStudent;

    @FXML
    private Rectangle hederLabel;

    @FXML
    private Label lblDate;
    @FXML
    private Label lblTime;

    @FXML
    private Rectangle mainLabel;

    @FXML
    private AnchorPane root;

    @FXML
    void btnKeyMonyClickOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/KeyMony_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContex.getChildren().clear();
        LoadContex.getChildren().add(load);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), LoadContex);
        transition.setFromX(load.getScene().getWidth());
        transition.setToX(1);
        transition.play();
    }

    @FXML
    void btnResevedClickOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/RoomReseved_Form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContex.getChildren().clear();
        LoadContex.getChildren().add(load);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), LoadContex);
        transition.setFromX(load.getScene().getWidth());
        transition.setToX(1);
        transition.play();

    }

    @FXML
    void btnResevedDetailsClickOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/ResevedDetails.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContex.getChildren().clear();
        LoadContex.getChildren().add(load);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), LoadContex);
        transition.setFromX(load.getScene().getWidth());
        transition.setToX(0);
        transition.play();
    }

    @FXML
    void btnRoomClickOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/Room_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContex.getChildren().clear();
        LoadContex.getChildren().add(load);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), LoadContex);
        transition.setFromX(load.getScene().getWidth());
        transition.setToX(0);
        transition.play();
    }

    @FXML
    void btnStudentClickOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/Student_Form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContex.getChildren().clear();
        LoadContex.getChildren().add(load);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), LoadContex);
        transition.setFromX(load.getScene().getWidth());
        transition.setToX(0);
        transition.play();

    }


    public void btnManageOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/StudentManage_Form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContex.getChildren().clear();
        LoadContex.getChildren().add(load);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), LoadContex);
        transition.setFromX(load.getScene().getWidth());
        transition.setToX(0);
        transition.play();
    }
}
