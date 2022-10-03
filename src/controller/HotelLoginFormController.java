package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HotelLoginFormController {
    public AnchorPane hotelLoginContext;

    public void adminLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminLoginForm");
    }

    public void receptionistLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistLoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) hotelLoginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
