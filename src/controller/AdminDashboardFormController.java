package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminDashboardFormController {
    public AnchorPane adminDashboardContext;

    public void mealPackageOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MealPackageForm");
    }

    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RoomsForm");
    }

    public void incomeReportsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("IncomeForm");
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminLoginForm");
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage)adminDashboardContext .getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
