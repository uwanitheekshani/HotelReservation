package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class IncomeFormController {
    public AnchorPane incomeContext;

    public void inHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }

    public void inBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminDashboardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) incomeContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

}
