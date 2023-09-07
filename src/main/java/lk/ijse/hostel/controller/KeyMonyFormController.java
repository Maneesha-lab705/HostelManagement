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
import lk.ijse.hostel.Dto.BillDTO;
import lk.ijse.hostel.Dto.ReservationDTO;
import lk.ijse.hostel.bo.custom.KeyMoneyBO;
import lk.ijse.hostel.bo.custom.impl.KeyMoneyBOImpl;
import lk.ijse.hostel.tm.BillTM;
import lk.ijse.hostel.tm.ReservationTM;
import lk.ijse.hostel.tm.StudentTM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KeyMonyFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TableColumn<?, ?> colKeyMoney;

    @FXML
    private TableColumn<?, ?> colLastPayment;

    @FXML
    private TableColumn<?, ?> colPayId;

    @FXML
    private TableColumn<?, ?> colResd;

    @FXML
    private TableView<BillTM> tblBill;

    @FXML
    private TextField txtLastPayment;

    @FXML
    private TextField txtPay;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtStudentId;


    KeyMoneyBO keyMoneyBO =new KeyMoneyBOImpl();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllPayment();
        setCellValueFactory();

    }
    private void setCellValueFactory() {
        colPayId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colLastPayment.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        colResd.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keymony"));



    }
    private void getAllPayment() {
        ObservableList<BillTM> obList= FXCollections.observableArrayList();
        List<BillDTO> billDTOS = keyMoneyBO.getAllPayment();
        for (BillDTO billDTO: billDTOS){
            obList.add(new BillTM(
                    billDTO.getPaymentId(),
                    billDTO.getKeymony(),
                    billDTO.getAmount(),
                    billDTO.getBalance(),
                    billDTO.getReservation().getRes_id()
            ));
        }
        tblBill.setItems(obList);
    }

    @FXML
    void btnPayOnAction(ActionEvent event) {
        if (tblBill.getSelectionModel().getSelectedItem() != null) {
            BillTM selectedItem = tblBill.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                Double lastPay =selectedItem.getAmount();
                Double balance =selectedItem.getBalance();
                String payId =selectedItem.getPaymentId();

                double payment= Double.parseDouble(txtPay.getText());
                double newPayment =lastPay+payment;
                double newBalance =balance-payment;

                boolean isPayed =keyMoneyBO.payed(new BillDTO(payId,newPayment,newBalance));
                if (isPayed){
                    getAllPayment();
                    new Alert(Alert.AlertType.CONFIRMATION).show();
                }
            }
        }
    }

    public void MousePressedOnAction(MouseEvent mouseEvent) {
        if (tblBill.getSelectionModel().getSelectedItem() != null) {
            BillTM selectedItem = tblBill.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                txtLastPayment.setText(String.valueOf(selectedItem.getAmount()));
                String studentId = keyMoneyBO.getStudentId(selectedItem.getResId());
                txtStudentId.setText(studentId);
                String roomId =keyMoneyBO.getRoomId(selectedItem.getResId());
                txtRoomId.setText(roomId);
            }
        }

    }
}
