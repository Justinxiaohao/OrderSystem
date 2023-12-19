package cn.sdtbu.edu.beberageorder.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName:DiningStyleChoice
 * Package:cn.sdtbu.edu.beberageorder.menu
 * Author:@Wyh
 */
public class DiningStyleChoice extends JFrame {
    public DiningStyleChoice() {
        Icon icon = new ImageIcon("src/imageButtoo.jpg");
        setLayout(new GridLayout(3, 2, 5, 5));
        Container c = getContentPane();
        JButton btn[] = new JButton[2];
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();
            c.add(btn[i]);
        }
        btn[0].setText("堂食用餐");
        btn[0].setBorderPainted(false);
        btn[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(DiningStyleChoice.this, "您选择的是堂食用餐！！");
            }
        });
        btn[1].setText("打包带走");
        btn[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(DiningStyleChoice.this, "您选择的是打包带走！！");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("请选择堂食还是打包");
        setBounds(200, 200, 500, 300);
    }
    public static void main(String[] args) {
        new DiningStyleChoice();
    }
}
