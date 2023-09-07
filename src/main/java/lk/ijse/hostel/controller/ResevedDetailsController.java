package lk.ijse.hostel.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.hostel.Dto.ReservationDTO;
import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.bo.custom.ReservationBO;
import lk.ijse.hostel.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostel.tm.ReservationTM;
import lk.ijse.hostel.tm.RoomTM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ResevedDetailsController implements Initializable {
    @FXML
    private TableColumn<?, ?> colDDate;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colKeyMony;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colResId;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colRoomType;

    @FXML
    private TableColumn<?, ?> colStId;

    @FXML
    private TextField txtroomId;


    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TextField txtRoomType;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<RoomTM> tblAvaleble;

    @FXML
    private TableView<ReservationTM> tblReseved;

    @FXML
    private TextField txtKeyMoney;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtRsId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtStId;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtduedate;
    ReservationBO reservationBO =new ReservationBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllReseved();
        getAllAvaleble();
        setCellValueFactory();
        setCellValueFactory2();
    }

    private void setCellValueFactory2() {

        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMony.setCellValueFactory(new PropertyValueFactory<>("keymoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

    }

    private void getAllAvaleble() {
        ObservableList<RoomTM> obList= FXCollections.observableArrayList();
        List<RoomDto> roomDtoList = reservationBO.getAllAvaleble();

        for (RoomDto roomDto: roomDtoList){
            obList.add(new RoomTM(
                    roomDto.getRoom_id(),
                    roomDto.getRoom_Type_id(),
                    roomDto.getKeymoney(),
                    roomDto.getQty()
            ));
        }
    tblAvaleble.setItems(obList);
        tblAvaleble.refresh();
    }

    private void setCellValueFactory() {
        colResId.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDDate.setCellValueFactory(new PropertyValueFactory<>("duedata"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colStId.setCellValueFactory(new PropertyValueFactory<>("sId"));
    }

    private void getAllReseved() {
        ObservableList<ReservationTM> obList= FXCollections.observableArrayList();

        List<ReservationDTO> reservationDTOS = reservationBO.getAll();
//        for (ReservationDTO reservationDTO : reservationDTOS){
//            System.out.println(reservationDTO);
//        }

        for (ReservationDTO reservationDTO: reservationDTOS){
            obList.add(new ReservationTM(
                    reservationDTO.getRes_id(),
                    reservationDTO.getDate(),
                    reservationDTO.getDuedata(),
                    reservationDTO.getRoom_type_id(),
                    reservationDTO.getStudent().getStudentId()
            ));
        }
        tblReseved.setItems(obList);
        tblReseved.refresh();
    }

    public void onMousePressedOnAction(MouseEvent mouseEvent) {
        if (tblReseved.getSelectionModel().getSelectedItem() != null) {
            ReservationTM selectedItem = tblReseved.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Assuming 'txtRoomId' is the name of your text field
                txtRsId.setText(selectedItem.getRes_id());
                txtStId.setText(selectedItem.getSId());
                txtdate.setText(String.valueOf(selectedItem.getDate()));
                txtduedate.setText(String.valueOf(selectedItem.getDuedata()));
                txtStatus.setText(selectedItem.getRoom_type_id());
                String roomid=reservationBO.getRoomId(selectedItem.getRes_id());
                txtroomId.setText(roomid);

            }
            String sid =txtStId.getText();
            String name =reservationBO.getName(sid);
            txtName.setText(name);
        }
    }

    public void MousePressedOnAction2(MouseEvent mouseEvent) {
                if (tblAvaleble.getSelectionModel().getSelectedItem() != null) {
                 RoomTM selectedItem = tblAvaleble.getSelectionModel().getSelectedItem();
                         if (selectedItem != null) {
                // Assuming 'txtRoomId' is the name of your text field
                txtRoomId.setText(selectedItem.getRoom_id());
                txtRoomType.setText(selectedItem.getType());
                txtKeyMoney.setText(selectedItem.getKeymoney());
                txtQty.setText(String.valueOf(selectedItem.getQty()));
            }
        }
    }

    public void releasedOnAction(KeyEvent keyEvent) {

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        if (tblAvaleble.getSelectionModel().getSelectedItem() != null) {
            RoomTM selectedItem = tblAvaleble.getSelectionModel().getSelectedItem();
            boolean isDelete=reservationBO.delete(selectedItem.getRoom_id());
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"is delete").show();
                clear();
                getAllAvaleble();
            }
        }
    }
    void clear(){
        txtRoomId.clear();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtQty.clear();
    }
//    public void releasedOnAction(KeyEvent keyEvent) {
//        String sid =txtStId.getText();
//        String name =reservationBO.getName(sid);
//        txtName.setText(name);
//    }
}



