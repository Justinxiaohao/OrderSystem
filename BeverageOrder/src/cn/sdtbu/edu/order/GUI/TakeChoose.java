package cn.sdtbu.edu.order.GUI;

import javax.swing.*;

/**
 * ClassName:TakeChoose
 * Package:cn.sdtbu.edu.order.GUI
 * Author:@Wyh
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName:Demo
 * Package:PACKAGE_NAME
 * Author:@Wyh
 */
public class TakeChoose extends JFrame {
    public TakeChoose() {
        setVisible(true);
        setTitle("请选择堂食还是打包");
        setBounds(500, 300, 600, 400);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        JButton btn1 = new JButton("堂食用餐");
        JButton btn2 = new JButton("打包带走");
        btn1.setBorderPainted(false);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(TakeChoose.this, "您选择的是堂食用餐！！");
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(TakeChoose.this, "您选择的是打包带走！！");
            }
        });
    }
    public static void main(String[] args) {
        new TakeChoose();
    }
}
