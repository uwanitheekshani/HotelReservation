package db;

import model.Meal;
import model.Room;

import java.util.ArrayList;

public class MealDatabase {
    public static ArrayList<Meal> mealTable = new ArrayList<Meal>();


    static{
        mealTable.add(
                new Meal("Local",1200)
        );
        mealTable.add(
                new Meal("Chinese",3000)
        );
        mealTable.add(
                new Meal("French",3500)
        );
    }
}
