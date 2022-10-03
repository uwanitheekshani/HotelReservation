package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomsMaintenanceFormController {
    public AnchorPane recepMaintenanceContext;
    public ComboBox<Integer> cmbResRoomNum;
    public ComboBox<Integer> cmbAvailRoom;
    public ComboBox<Integer> cmbMainRoomNum;
    public ComboBox<Integer> cmbNum;

    public void initialize(){
        ObservableList<Integer> obList1 = FXCollections.observableArrayList();
        obList1.add(1);
        obList1.add(2);
        cmbResRoomNum.setItems(obList1);

            ObservableList<Integer> obList2 = FXCollections.observableArrayList();
            obList2.add(3);
            obList2.add(4);
            obList2.add(5);
            obList2.add(6);
            obList2.add(7);
            obList2.add(8);
            obList2.add(9);
            obList2.add(10);
            obList2.add(11);
            obList2.add(12);
            obList2.add(13);
            obList2.add(14);
            obList2.add(15);
            obList2.add(16);
            obList2.add(17);
            obList2.add(18);
            obList2.add(19);
            obList2.add(20);
            obList2.add(21);
            obList2.add(22);
            obList2.add(23);
            cmbAvailRoom.setItems(obList2);

        ObservableList<Integer> obList3 = FXCollections.observableArrayList();
        obList3.add(1);
        obList3.add(2);
        obList3.add(3);
        obList3.add(4);
        obList3.add(5);
        obList3.add(6);
        obList3.add(7);
        obList3.add(8);
        obList3.add(9);
        obList3.add(10);
        obList3.add(11);
        obList3.add(12);
        obList3.add(13);
        obList3.add(14);
        obList3.add(15);
        obList3.add(16);
        obList3.add(17);
        obList3.add(18);
        obList3.add(19);
        obList3.add(20);
        obList3.add(21);
        obList3.add(22);
        obList3.add(23);
        cmbNum.setItems(obList3);

    }

    public void mainHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }

    public void mainBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistDashboardForm");
    }

    public void addToMainOnAction(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION, "Success!").show();
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) recepMaintenanceContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
