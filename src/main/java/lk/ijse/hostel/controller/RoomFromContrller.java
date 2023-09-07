package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.bo.custom.RoomBO;
import lk.ijse.hostel.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostel.tm.ReservationTM;
import lk.ijse.hostel.tm.RoomTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RoomFromContrller implements Initializable {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSerch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colKeyMony;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colType;


    @FXML
    private JFXComboBox<String> comRoomTypeid;

    @FXML
    private TableView<RoomTM> tblRoom;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtKeyMoney;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtRoomType;

    RoomBO roomBO =new RoomBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAll();
        setCellValueFactory();
        LoadRoopTypeId();
    }

    private void LoadRoopTypeId() {
        List<String> list =new ArrayList<>();
        ObservableList<String> oblist= FXCollections.observableArrayList();

        list.add("RM-1324");
        list.add("RM-5464");
        list.add("RM-7896");
        list.add("RM-0093");
         for (String type :list){
             oblist.add(type);
         }
         comRoomTypeid.setItems(oblist);
    }

    private void setCellValueFactory() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMony.setCellValueFactory(new PropertyValueFactory<>("keymoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void getAll() {
        ObservableList<RoomTM>obList=FXCollections.observableArrayList();

        List<RoomDto> roomDtoList = roomBO.getAll();

        for (RoomDto roomDto : roomDtoList){
            obList.add(new RoomTM(
                    roomDto.getRoom_id(),
                    roomDto.getType(),
                    roomDto.getKeymoney(),
                    roomDto.getQty()
            ));
        }
        tblRoom.setItems(obList);
        tblRoom.refresh();
}

    @FXML
    void OnMouseEnterdOnAction(MouseEvent event) {

    }

    @FXML
    void OnMouseExitOnAction(MouseEvent event) {

    }

    @FXML
    void SaveOnAction(ActionEvent event) {
        String roomid =txtRoomId.getText();
        String roomTypeId = (String) comRoomTypeid.getSelectionModel().getSelectedItem();
        String roomtype =txtRoomType.getText();
        String keymoney =txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());

        boolean isSave=roomBO.save(new RoomDto(roomid,roomTypeId,roomtype,keymoney,qty));
        if (isSave){
            new Alert(Alert.AlertType.CONFIRMATION,"NEW ROOM SAVED!!").show();
            clear();
            getAll();
        }
    }

    void clear(){
        txtRoomId.clear();
        comRoomTypeid.getSelectionModel().clearSelection();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtQty.clear();
    }
    @FXML
    void deleteOnAction(ActionEvent event) {
        String roomid =txtRoomId.getText();

        boolean isDelete=roomBO.delete(new RoomDto(roomid));
        if (isDelete){
            new Alert(Alert.AlertType.CONFIRMATION," ROOM DELETED!!").show();
            clear();
        }

    }

    @FXML
    void serchOnAction(ActionEvent event) {
        String roomId=txtRoomId.getText();
        RoomDto roomDto =roomBO.serch(roomId);
        if (roomDto!=null){
            txtRoomId.setText(roomDto.getRoom_id());
            comRoomTypeid.setValue(roomDto.getRoom_Type_id());
            txtRoomType.setText(roomDto.getType());
            txtKeyMoney.setText(roomDto.getKeymoney());
            txtQty.setText(String.valueOf(roomDto.getQty()));
        }

    }

    @FXML
    void updateOnAction(ActionEvent event) {
        String roomid =txtRoomId.getText();
        String roomTypeId = (String) comRoomTypeid.getSelectionModel().getSelectedItem();
        String roomtype =txtRoomType.getText();
        String keymoney =txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());

        boolean isUpdate=roomBO.update(new RoomDto(roomid,roomTypeId,roomtype,keymoney,qty));
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"NEW ROOM SAVED!!").show();
            clear();
        }
    }


    public void comRoomTypeOnAction(ActionEvent actionEvent) {
        if (   comRoomTypeid.getSelectionModel().getSelectedItem().equals("RM-1324")){
            txtRoomType.setText("Non-Ac");
            txtKeyMoney.setText("3100.00");
        }
        if (   comRoomTypeid.getSelectionModel().getSelectedItem().equals("RM-5464")){
            txtRoomType.setText("Non-Ac/FOODS");
            txtKeyMoney.setText("6500.00");
        }
        if (   comRoomTypeid.getSelectionModel().getSelectedItem().equals("RM-7896")){
            txtRoomType.setText("Ac");
            txtKeyMoney.setText("8900.00");
        }
        if (   comRoomTypeid.getSelectionModel().getSelectedItem().equals("RM-0093")){
            txtRoomType.setText("Ac/FOODS");
            txtKeyMoney.setText("16000.00");
        }


    }


}
