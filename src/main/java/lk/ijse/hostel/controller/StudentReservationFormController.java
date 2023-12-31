package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import lk.ijse.hostel.Dto.BillDTO;
import lk.ijse.hostel.Dto.ReservationDTO;
import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.Dto.StudentDTO;
import lk.ijse.hostel.bo.custom.ReservationBO;
import lk.ijse.hostel.bo.custom.RoomBO;
import lk.ijse.hostel.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostel.bo.custom.impl.RoomBOImpl;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentReservationFormController implements Initializable {
    ReservationBO reservationBO=new ReservationBOImpl();
    RoomBO roomBO =new RoomBOImpl();

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXComboBox<String> comGender;

    @FXML
    private JFXComboBox<String> comRoomType;

    @FXML
    private JFXComboBox<String> comRoomId;

    @FXML
    private DatePicker picDate;

    @FXML
    private AnchorPane root2;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private DatePicker txtDate;

    @FXML
    private DatePicker txtEndDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtResId;

    @FXML
    private TextField txtKeyMony;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtStId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadResId();
        loadGender();
        loadRoomType();
        loadBillId();
    }

    private void loadRoomType() {
        ObservableList<String> oblist= FXCollections.observableArrayList();
        List<String> list =new ArrayList<>();
        list.add("RM-1324");
        list.add("RM-5464");
        list.add("RM-7896");
        list.add("RM-0093");
        for (String type :list){
            oblist.add(type);
        }
        comRoomType.setItems(oblist);
    }

    private void loadGender() {
        List<String> list =new ArrayList<>();
        ObservableList<String> oblist = FXCollections.observableArrayList();

        list.add("Mail");
        list.add("Fe-mail");

        for (String gender :list){
            oblist.add(gender);
            comGender.setItems(oblist);
        }
    }

    private void loadResId() {
        String resId=reservationBO.getResId();
        txtResId.setText(resId);

    }

    @FXML
    void OnMEnterdOnAction(MouseEvent event) {

    }

    @FXML
    void OnMExitedOnAction(MouseEvent event) {

    }

//
//    @FXML
//    void btnDeleteOnAction(ActionEvent event) {
//        String id =txtStId.getText();
//        boolean isDelete=reservationBO.delete(new StudentDTO(id));
//        if (isDelete){
//            new Alert(Alert.AlertType.CONFIRMATION,"is delete").show();
//        }
//
//    }

    private void loadBillId() {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        if (conformId()) {
            if (confermResId()) {
                if (conformContact()) {
                    String name = txtName.getText();
                    String sId = txtStId.getText();
                    String address = txtAddress.getText();
                    String contact = txtContact.getText();
                    LocalDate dob = picDate.getValue();
                    String gender = String.valueOf(comGender.getSelectionModel().getSelectedItem());

                    String resId = txtResId.getText();
                    LocalDate date = txtDate.getValue();
                    LocalDate endDate = txtEndDate.getValue();
                    String roomType = comRoomType.getSelectionModel().getSelectedItem();
                    String roomid = comRoomId.getSelectionModel().getSelectedItem();

                    Double amount = Double.valueOf(txtAmount.getText());
                    Double balance = Double.valueOf(txtBalance.getText());
                    Double keymony = Double.valueOf(txtKeyMony.getText());

                    StudentDTO studentDTO = new StudentDTO(sId, name, address, contact, dob, gender);
                    RoomDto roomDto = new RoomDto(roomid);
                    ReservationDTO reservationDTO = new ReservationDTO(resId, date, endDate, roomType, roomDto, studentDTO);
                    BillDTO billDTO = new BillDTO(sId, keymony, amount, balance);


                    boolean isSave = reservationBO.save(reservationDTO, roomDto, studentDTO, billDTO);
                    if (isSave) {
                        new Alert(Alert.AlertType.CONFIRMATION, "is Saved..").show();
                        Clear();
                        txtStId.setBackground(Background.fill(Color.WHITE));
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Duplicate Entity").show();
                    }
                } else if (!confermResId()) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Entity").show();
                }
            } else if (!conformId()) {
                new Alert(Alert.AlertType.ERROR, "WRONG STUDENT ID ENTER CORRECT ONE!!").show();
            }
        }else if (!conformContact()){
            new Alert(Alert.AlertType.ERROR, "WRONG CONTACT  ENTER CORRECT ONE!!").show();

        }

    }
    private boolean conformId() {
        if (txtStId.getText().matches("^[ST0-9]{5}$")) {
            return true;
        }else {
            txtStId.setBackground(Background.fill(Color.RED));
        }
        return false;
    }

    private boolean confermResId() {
        if (txtResId.getText().matches("^[R0-9]{4}$")) {
            return true;
        }else {
            txtResId.setBackground(Background.fill(Color.RED));}
        return false;
    }
    private boolean conformContact() {
        if (txtContact.getText().matches("^[0-9]{10}$")) {
            return true;
        } else {
            txtContact.setBackground(Background.fill(Color.RED));

        }
        return false;
    }
    private void Clear() {
        txtName.clear();
        txtStId.clear();
        txtAddress.clear();
        txtContact.clear();
        picDate.cancelEdit();
        comGender.setPromptText("");

        txtResId.clear();
        comRoomType.setPromptText("");
        comRoomId.setPromptText("");

        txtAmount.getText();
        txtBalance.getText();
        txtKeyMony.getText();
    }

    public void RoomTypeOnAction(ActionEvent actionEvent) {
        if (comRoomType.getSelectionModel().getSelectedItem().equals("RM-1324")){
            txtKeyMony.setText("3100.00");
        }
        if (comRoomType.getSelectionModel().getSelectedItem().equals("RM-5464")){
            txtKeyMony.setText("6500.00");
        }
        if (comRoomType.getSelectionModel().getSelectedItem().equals("RM-7896")){
            txtKeyMony.setText("8900.00");
        }
        if (comRoomType.getSelectionModel().getSelectedItem().equals("RM-0093")){
            txtKeyMony.setText("16000.00");
        }
        ObservableList<String> observableList =FXCollections.observableArrayList();
        List<String> ids =roomBO.getRoomIds(comRoomType.getSelectionModel().getSelectedItem());

        for (String id :ids){
            observableList.add(id);
        }
        comRoomId.setItems(observableList);

    }

    public void TextAmountOnAction(KeyEvent keyEvent) {
        double keMony= Double.parseDouble(txtKeyMony.getText());
        double amount = Double.parseDouble(txtAmount.getText());

        double balance=keMony-amount;
        txtBalance.setText(String.valueOf(balance));

    }
    @FXML
    void StIDOnAction(ActionEvent event) {
        if (conformId()){
            txtName.requestFocus();
            txtStId.setBackground(Background.fill(Color.WHITE));

        }else if (!conformId()){
            new Alert(Alert.AlertType.ERROR,"INCORRECT ID!").show();
            txtStId.setBackground(Background.fill(Color.RED));
        }

    }

    public void namaOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void AddressOnAction(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void ContactOnAction(ActionEvent actionEvent) {
        if (conformContact()){
            picDate.requestFocus();
            txtContact.setBackground(Background.fill(Color.WHITE));
        }else if (!conformContact()){
            new Alert(Alert.AlertType.ERROR,"INCORRECT CONTACT!").show();
            txtContact.setBackground(Background.fill(Color.RED));

        }

    }

    public void DobOnAction(ActionEvent actionEvent) {
        comGender.requestFocus();
        Background.fill(Color.GREEN);
    }


    public void GenderOnAction(ActionEvent actionEvent) {
        txtResId.requestFocus();
    }

    public void DateOnAction(ActionEvent actionEvent) {
        txtEndDate.requestFocus();
    }

    public void EndDateOnAction(ActionEvent actionEvent) {
        comRoomType.requestFocus();
    }

    public void ResIdOnAction(ActionEvent actionEvent) {
        txtDate.requestFocus();
    }

    public void KemonyeOnAction(ActionEvent actionEvent) {
        txtAmount.requestFocus();

    }
}
