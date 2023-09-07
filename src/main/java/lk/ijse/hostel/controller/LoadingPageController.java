package lk.ijse.hostel.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lk.ijse.hostel.Main;
import lk.ijse.hostel.util.task.ApplicationStartTask;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingPageController implements Initializable {


    public Label lblDescription;

    public Label lblPercentage;

    public Rectangle mainRectangle;

    public AnchorPane root;

    public Rectangle smallRectangle;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        animation();
    }
    public void animation() {
        ApplicationStartTask task = new ApplicationStartTask();
        task.progressProperty().addListener((a,b,c)->{
            smallRectangle.setWidth(mainRectangle.getWidth()*c.doubleValue());
            lblPercentage.setText((c.doubleValue()*100)+"%");
        });

        task.valueProperty().addListener((a,b,c)->{
            if(c.equals("Starting Application...")){
                ((Stage)lblDescription.getScene().getWindow()).close();
                try {
                    new Main().start2(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lblDescription.setText(c);

        });

        Thread t1 = new Thread(task);
        t1.start();
    }
}