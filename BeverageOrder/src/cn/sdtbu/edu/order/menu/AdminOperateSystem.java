package cn.sdtbu.edu.order.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:OperateSystem
 * Package:cn.sdtbu.edu.order.GUI.ManageOrder
 * Author:@Wyh
 */
public class AdminOperateSystem {
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

    public static List<AdminOperateSystem> getMealList() {
        return mealList;
    }

    public static void setMealList(List<AdminOperateSystem> mealList) {
        AdminOperateSystem.mealList = mealList;
    }

    public AdminOperateSystem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    private String name;
    private String description;
    private double price;

    private static List<AdminOperateSystem> mealList = new ArrayList<>();

    public static void addMeal(AdminOperateSystem meal) {
        mealList.add(meal);
    }

    public static void deleteMeal(String name) {
        mealList.removeIf(meal -> meal.getName().equals(name));
    }

    public static AdminOperateSystem findMealByName(String name) {
        for (AdminOperateSystem meal : mealList) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }

    public static void updateMeal(String name, String description, double price) {
        for (AdminOperateSystem meal : mealList) {
            if (meal.getName().equals(name)) {
                meal.setDescription(description);
                meal.setPrice(price);
            }
        }
    }



}