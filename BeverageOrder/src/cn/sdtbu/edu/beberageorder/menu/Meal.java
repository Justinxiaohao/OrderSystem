package cn.sdtbu.edu.beberageorder.menu;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(Image image) {
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

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Image getImage() {
        return image;
    }
}
