package cn.sdtbu.edu.order.menu;

/**
 * ClassName:d
 * Package:cn.sdtbu.edu.BeverageOrder.Menu
 * Author:@Wyh
 */


import java.util.LinkedList;

public class MealMenu {
    LinkedList<Meal> mealMenu;

    public MealMenu(){
        mealMenu=new LinkedList<Meal>();
    }

    public void addItem(String name,String description,double price ,String filename){
        Meal meal=new Meal(name,description,price,filename);
        mealMenu.add(meal);
    }

    public LinkedList<Meal> getMeatMenu() {
        return mealMenu;
    }

}
