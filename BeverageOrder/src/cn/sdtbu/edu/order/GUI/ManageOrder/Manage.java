package cn.sdtbu.edu.order.GUI.ManageOrder;

import javax.swing.*;

/**
 * ClassName:Manage
 * Package:cn.sdtbu.edu.order.GUI.ManageOrder
 * Author:@Wyh
 */
public class Manage {

    public void createAndShowGUI() {

        JFrame frame = new JFrame("管理员后台管理系统");
        frame.setBounds(500,300,600,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();


        JButton addButton = new JButton("增加菜品");
        JButton deleteButton = new JButton("删除菜品");
        JButton editButton = new JButton("编辑菜品");



        addButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("请输入菜品名称:");
            String description = JOptionPane.showInputDialog("请输入菜品描述:");
            String priceString = JOptionPane.showInputDialog("请输入菜品价格:");
            double price = Double.parseDouble(priceString);
            OperateSystem.addMeal(new OperateSystem(name, description, price));
            JOptionPane.showMessageDialog(null, "菜品添加成功!");
        });

        deleteButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("请输入要删除的菜品名称:");
            OperateSystem.deleteMeal(name);
            JOptionPane.showMessageDialog(null, "菜品删除成功!");
        });

        editButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("请输入要修改的菜品名称:");
            OperateSystem meal = OperateSystem.findMealByName(name);
            if (meal == null) {
                JOptionPane.showMessageDialog(null, "找不到指定名称的菜品!");
                return;
            }
            String description = JOptionPane.showInputDialog("请输入新的菜品描述:");
            String priceString = JOptionPane.showInputDialog("请输入新的菜品价格:");
            double price = Double.parseDouble(priceString);
            OperateSystem.updateMeal(name, description, price);
            JOptionPane.showMessageDialog(null, "菜品修改成功!");
        });


        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
            new Manage().createAndShowGUI();

    }
}
