package cn.sdtbu.edu.order.GUI;

import cn.sdtbu.edu.order.menu.OrderingWindow;

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
        Container c = getContentPane();
        JFrame jf = new JFrame("请选择堂食还是打包带走");
        ImageIcon background = new ImageIcon("images/background.jpg");
        JLabel label = new JLabel(background);
        label.setSize(background.getIconWidth(), background.getIconHeight());
        jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        Container container = jf.getContentPane();
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("堂食用餐");
        JButton btn2 = new JButton("打包带走");
        Dimension btnSize = new Dimension(200, 50);
        btn1.setPreferredSize(btnSize);
        btn2.setPreferredSize(btnSize);
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());
        panel.add(btn1);
        panel.add(btn2);
        container.add(panel, BorderLayout.SOUTH);

        jf.setSize(background.getIconWidth(), background.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);


        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(TakeChoose.this, "您选择的是堂食用餐！！");
                new OrderingWindow();
                jf.dispose();
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(TakeChoose.this, "您选择的是打包带走！！");
                new OrderingWindow();
                jf.dispose();
            }
        });
    }
    public static void main(String[] args) {
        new TakeChoose();
    }
}
