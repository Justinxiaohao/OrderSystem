package OrderSystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JButton orderButton;
    private JButton adminButton;
    public  MainGUI() {
        super("点餐系统");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500,300,300,300);

        orderButton = new JButton("用户登录");
        adminButton = new JButton("管理员登录");

        c.add(orderButton);
        c.add(adminButton);
        this.setVisible(true);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserLogin();
                MainGUI.this.dispose();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Admin();
                MainGUI.this.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
