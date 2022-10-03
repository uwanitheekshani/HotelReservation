package db;

import model.Room;

import java.util.ArrayList;

public class RoomDatabase {
    public static ArrayList<Room> roomTable = new ArrayList<Room>();


    static{
        roomTable.add(
            new Room("r001","single",7000)
        );
        roomTable.add(
                new Room("r002","double",12000)
        );
        roomTable.add(
                new Room("r003","triple",15000)
        );
    }
}
