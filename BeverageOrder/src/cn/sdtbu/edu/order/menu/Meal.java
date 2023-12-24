package cn.sdtbu.edu.order.menu;

import java.awt.*;

/**
 * ClassName:Menu
 * Package:cn.sdtbu.edu.BeverageOrder.Menu
 * Author:@Wyh
 */
public class Meal {
    private String name;
    private String description;
    private double price;
    private Image image;


    public Meal() {
    }
    public Meal(String name, String description, double price, Image image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
    public Meal(String name, String description, double price, String filename) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        this.image=toolkit.createImage(filename);
    }
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
