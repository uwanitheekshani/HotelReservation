package view.tm;

import javafx.scene.control.Button;

public class MealTM {
     private String mealType;
     private double mealPrice;
     private Button btn;


    public MealTM() {
    }

    public MealTM(String mealType, double mealPrice, Button btn) {
        this.mealType = mealType;
        this.mealPrice = mealPrice;
        this.btn = btn;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(double mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "MealTM{" +
                "mealType='" + mealType + '\'' +
                ", mealPrice=" + mealPrice +
                ", btn=" + btn +
                '}';
    }
}
