package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ReceptionistLoginFormController {
    public TextField txtRUserName;
    public PasswordField pwdRPassword;
    public AnchorPane receptionistLoginContext;

    public void rLoginOnAction(ActionEvent actionEvent) throws IOException {
        String tempUserName = txtRUserName.getText();
        String tempPassword = pwdRPassword.getText();
        if (tempUserName.equals("recep") && tempPassword.equals("5678")){
            setUi("ReceptionistDashboardForm");
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again").show();
        }
    }

    public void rCancelOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage)receptionistLoginContext .getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
