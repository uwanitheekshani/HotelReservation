package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistDashboardFormController {
    public AnchorPane recepDashboardContext;

    public void recepHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }

    public void recepBackHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistLoginForm");
    }

    public void reserveRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReserveRoomsForm");
    }

    public void roomsMaintenanceOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RoomsMaintenanceForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) recepDashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
