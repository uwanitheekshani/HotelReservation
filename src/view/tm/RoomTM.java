package view.tm;

import javafx.scene.control.Button;

public class RoomTM {
    private String roomNum;
    private String roomType;
    private double price;
    private Button btn;


    public RoomTM() {
    }

    public RoomTM(String roomNum, String roomType, double price, Button btn) {
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.price = price;
        this.btn = btn;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "roomNum='" + roomNum + '\'' +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", btn=" + btn +
                '}';
    }
}
