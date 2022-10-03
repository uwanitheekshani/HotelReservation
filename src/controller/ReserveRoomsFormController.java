package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReserveRoomsFormController {
    public AnchorPane recepReserveContext;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtTeleNum;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public TextField txtSelectedRoom;
    public ComboBox<String> cmbRoomType;
    public TextField txtRoomNum;
    public JFXTextField txtMealType;
    public JFXButton btnDone;


    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("single");
        obList.add("double");
        obList.add("triple");
        obList.add("quad");
        cmbRoomType.setItems(obList);
    }

    public void recepHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }

    public void recepBackHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistDashboardForm");
    }

    public void btnChooseOnAction(ActionEvent actionEvent) {
        txtSelectedRoom.setText(cmbRoomType.getValue());
    }

    public void doneOnAction(ActionEvent actionEvent) {
        btnDone.setText("done");
        txtName.clear();
        txtNic.clear();
        txtTeleNum.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtSelectedRoom.clear();
        txtRoomNum.clear();
        txtMealType.clear();

    }

    public void printOnAction(ActionEvent actionEvent) {
        if (txtName.getText()!=null && txtNic.getText()!=null && txtTeleNum.getText()!=null && txtEmail.getText()!=null &&
                txtAddress.getText()!=null && txtSelectedRoom.getText()!=null && txtRoomNum.getText()!=null &&
                txtMealType.getText()!=null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Success!").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again");
        }
    }

    public void emailOnAction(ActionEvent actionEvent) {
        if (txtName.getText()!=null && txtNic.getText()!=null && txtTeleNum.getText()!=null && txtEmail.getText()!=null &&
                txtAddress.getText()!=null && txtSelectedRoom.getText()!=null && txtRoomNum.getText()!=null &&
                txtMealType.getText()!=null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Success!").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again");
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) recepReserveContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
