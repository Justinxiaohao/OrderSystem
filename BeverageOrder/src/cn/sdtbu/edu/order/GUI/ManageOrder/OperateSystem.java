package cn.sdtbu.edu.order.GUI.ManageOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:OperateSystem
 * Package:cn.sdtbu.edu.order.GUI.ManageOrder
 * Author:@Wyh
 */
public class OperateSystem {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<OperateSystem> getMealList() {
        return mealList;
    }

    public static void setMealList(List<OperateSystem> mealList) {
        OperateSystem.mealList = mealList;
    }

    public OperateSystem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    private String name;
    private String description;
    private double price;

    private static List<OperateSystem> mealList = new ArrayList<>();

    public static void addMeal(OperateSystem meal) {
        mealList.add(meal);
    }

    public static void deleteMeal(String name) {
        mealList.removeIf(meal -> meal.getName().equals(name));
    }

    public static OperateSystem findMealByName(String name) {
        for (OperateSystem meal : mealList) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }

    public static void updateMeal(String name, String description, double price) {
        for (OperateSystem meal : mealList) {
            if (meal.getName().equals(name)) {
                meal.setDescription(description);
                meal.setPrice(price);
            }
        }
    }



}