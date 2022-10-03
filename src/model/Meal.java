package model;

public class Meal {
     private String mealType;
    private double mealPrice;

    public Meal() {
    }

    public Meal(String mealType, double mealPrice) {
        this.mealType = mealType;
        this.mealPrice = mealPrice;
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

    @Override
    public String toString() {
        return "Meal{" +
                "mealType='" + mealType + '\'' +
                ", mealPrice=" + mealPrice +
                '}';
    }
}
