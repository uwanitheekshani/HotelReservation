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

public class AdminLoginFormController {
    public TextField txtAUserName;
    public PasswordField pwdAPassword;
    public AnchorPane adminLoginContext;

    public void aLoginOnAction(ActionEvent actionEvent) throws IOException {
        String tempUserName = txtAUserName.getText();
        String tempPassword = pwdAPassword.getText();
        if (tempUserName.equals("admin") && tempPassword.equals("1234")){
            setUi("AdminDashboardForm");
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again").show();
        }
    }

    public void aCancelOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) adminLoginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
