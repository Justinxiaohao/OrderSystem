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
public class AdminJFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AdminJFrame() {
        setTitle("奶茶管理员后台登录");
        setBounds(700,400,280,170);
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
                    openMainWindow();
                } else {
                    showError("用户名或密码错误");
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

    private void openMainWindow() {
        JOptionPane.showMessageDialog(null, "登录成功！");
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "错误", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new AdminJFrame();
    }
}