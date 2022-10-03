package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import model.Room;
import view.tm.RoomTM;

import java.io.IOException;
import java.util.Optional;

public class RoomsFormController {
    public TableView tblRoom;
    public TableColumn colRoomNum;
    public TableColumn colRoomType;
    public TableColumn colPrice;
    public TableColumn colOption;
    public AnchorPane roomContext;
    public JFXTextField txtRoomNum;
    public JFXTextField txtRoomType;
    public JFXTextField txtPrice;
    public JFXButton btnSaveAndUpdate;

    public void initialize(){
        colRoomNum.setCellValueFactory(new PropertyValueFactory("roomNum"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("roomType"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllRooms();

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null) {
                setData((RoomTM) newValue);
            }
        });
    }

    private void setData(RoomTM tm) {
        txtRoomNum.setText(tm.getRoomNum());
        txtRoomType.setText(tm.getRoomType());
        txtPrice.setText(String.valueOf(tm.getPrice()));
        btnSaveAndUpdate.setText("Update");
    }


    private void loadAllRooms() {
        ObservableList<RoomTM> obList = FXCollections.observableArrayList();

        for (Room r: RoomDatabase.roomTable
             ) {
            Button btn = new Button("Delete");
           RoomTM tm = new RoomTM(r.getRoomNum(),r.getRoomType(),r.getPrice(),btn);
            obList.add(tm);


            btn.setOnAction((e)->{


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)){
                    RoomDatabase.roomTable.remove(r);
                    obList.remove(tm);
                }
            });

        }
        tblRoom.setItems(obList);
    }

    public void btnSaveRoomOnAction(ActionEvent actionEvent) {
        if (btnSaveAndUpdate.getText().equals("Save Room")) {
            Room r1 = new Room(
                    txtRoomNum.getText(),
                    txtRoomType.getText(),
                    Double.parseDouble(txtPrice.getText())
            );
            RoomDatabase.roomTable.add(r1);
            loadAllRooms();
        }else {
            for (Room r2:RoomDatabase.roomTable){
                if (r2.getRoomNum().equals(txtRoomNum.getText())){
                    r2.setRoomType(txtRoomType.getText());
                    r2.setPrice(Double.parseDouble(txtPrice.getText()));
                    loadAllRooms();
                    return;
                }
            }
        }
    }

    public void addNewOnAction(ActionEvent actionEvent) {
        btnSaveAndUpdate.setText("Save Room");
        txtRoomNum.clear();
        txtRoomType.clear();
        txtPrice.clear();
    }

    public void rHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HotelLoginForm");
    }

    public void rBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminDashboardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) roomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
