package cn.sdtbu.edu.order.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName:AdminJFrame
 * Package:cn.sdtbu.edu.order.GUI
 * Author:@Wyh
 */
public class AdminLoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public void AdminJFrame() {
        setTitle("奶茶管理员后台登录");
        setBounds(800,400,270,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("                 用户名:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("                 密码:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (isValidUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "登录成功！");
                    Manage ma = new Manage();
                    ma.createAndShowGUI();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel(""));
        add(loginButton);
        setVisible(true);
    }

    private boolean isValidUser(String username, String password) {
        return username.equals("zfh") && password.equals("123456");
    }

}
