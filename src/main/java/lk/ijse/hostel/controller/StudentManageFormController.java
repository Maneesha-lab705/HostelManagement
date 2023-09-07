package lk.ijse.hostel.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.Dto.StudentDTO;
import lk.ijse.hostel.bo.custom.StudentManageBO;
import lk.ijse.hostel.bo.custom.impl.StudentManageBOImpl;
import lk.ijse.hostel.tm.RoomTM;
import lk.ijse.hostel.tm.StudentTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StudentManageFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<StudentTM> tblStudent;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSId;

    StudentManageBO studentManageBO =new StudentManageBOImpl();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllStudent();
        setCellValueFactory();
    }

    private void setCellValueFactory() {

        colId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("name"));
        colName.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void getAllStudent() {
        ObservableList<StudentTM> studentTMS= FXCollections.observableArrayList();
        List<StudentDTO> studentDTOS = studentManageBO.getAllStudent();

        for (StudentDTO studentDTO: studentDTOS){
            studentTMS.add(new StudentTM(
                   studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getContact(),
                    studentDTO.getDob(),
                    studentDTO.getGender()
            ));
        }
        tblStudent.setItems(studentTMS);
    }



    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String stId =txtSId.getText();
         boolean isDelete=studentManageBO.delete(new StudentDTO(stId));
         if (isDelete){
             new Alert(Alert.AlertType.CONFIRMATION,"Student Delete.!!").show();
         }else {
             new Alert(Alert.AlertType.ERROR,"Student Not Delete.!!").show();

         }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id=txtSId.getText();
        String name=txtName.getText();
        String address =txtAddress.getText();
        String contact=txtContact.getText();
        LocalDate dob = LocalDate.parse(txtDob.getText());
        String gender=txtGender.getText();


        boolean isUpdate =studentManageBO.update(new StudentDTO(id,name,address,contact,dob,gender));
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Update.!!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Student Not Update.!!").show();
            }
    }


    public void MousePressOnAction(MouseEvent mouseEvent) {
        if (tblStudent.getSelectionModel().getSelectedItem() != null) {
            StudentTM selectedItem = tblStudent.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Assuming 'txtRoomId' is the name of your text field
                txtSId.setText(selectedItem.getStudentId());
                txtName.setText(selectedItem.getName());
                txtAddress.setText(selectedItem.getAddress());
                txtContact.setText(selectedItem.getContact());
                txtDob.setText(String.valueOf(selectedItem.getDob()));
                txtGender.setText(selectedItem.getGender());
            }
        }
    }
}
