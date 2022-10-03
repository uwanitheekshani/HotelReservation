package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.MealDatabase;
import db.RoomDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Meal;
import model.Room;
import view.tm.MealTM;
import view.tm.RoomTM;

import java.io.IOException;
import java.util.Optional;

public class MealPackageFormController {
    public AnchorPane mealContext;
    public JFXTextField txtMealPackageType;
    public JFXTextField txtMealPrice;
    public JFXButton btnmSaveAndUpdate;
    public TableView tblMeal;
    public TableColumn colMealPackageType;
    public TableColumn colMealPrice;
    public TableColumn colmOption;


    public void initialize(){
        colMealPackageType.setCellValueFactory(new PropertyValueFactory("mealType"));
        colMealPrice.setCellValueFactory(new PropertyValueFactory("mealPrice"));
        colmOption.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllMeals();

        tblMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null) {
                setData((MealTM) newValue);
            }
        });
    }

    private void setData(MealTM tm) {
        txtMealPackageType.setText(tm.getMealType());
        txtMealPrice.setText(String.valueOf(tm.getMealPrice()));
        btnmSaveAndUpdate.setText("Update");
    }


    private void loadAllMeals() {

        ObservableList<MealTM> obList = FXCollections.observableArrayList();

        for (Meal r: MealDatabase.mealTable
        ) {
            Button btn = new Button("Delete");
            MealTM tm = new MealTM(r.getMealType(),r.getMealPrice(),btn);
            obList.add(tm);


            btn.setOnAction((e)->{


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)){
                    MealDatabase.mealTable.remove(r);
                    obList.remove(tm);
                }
            });

        }
        tblMeal.setItems(obList);

    }


    public void mHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }

    public void mBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminDashboardForm");
    }

    public void btnSaveMealOnAction(ActionEvent actionEvent) {

        if (btnmSaveAndUpdate.getText().equals("Save Meal")) {
            Meal r1 = new Meal(
                    txtMealPackageType.getText(),
                    Double.parseDouble(txtMealPrice.getText())
            );
            MealDatabase.mealTable.add(r1);
            loadAllMeals();
        }else {
            for (Meal r2:MealDatabase.mealTable){
                if (r2.getMealType().equals(txtMealPackageType.getText())){
                    r2.setMealPrice(Double.parseDouble(txtMealPrice.getText()));
                    loadAllMeals();
                    return;
                }
            }
        }

    }

    public void addmNewOnAction(ActionEvent actionEvent) {

        btnmSaveAndUpdate.setText("Save Meal");
        txtMealPackageType.clear();
        txtMealPrice.clear();

    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) mealContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
