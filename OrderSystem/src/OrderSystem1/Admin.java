package OrderSystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Admin extends JFrame {// 管理员登陆界面
    public Admin() {
        setTitle("管理员登录");
        setBounds(600, 400, 350, 250);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        Container c = getContentPane();
        setLayout(new GridLayout(3, 1, 10, 10));

        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();

        c.add(jp1);
        c.add(jp2);
        c.add(jp3);

        JTextField jtf1 = new JTextField(15);
        JPasswordField jpf1 = new JPasswordField(15);
        JLabel jl1 = new JLabel("用户名：");
        JLabel jl2 = new JLabel("  密码：");
        JButton jb1 = new JButton("登录");

        jp1.add(jl1);
        jp1.add(jtf1);
        jp2.add(jl2);
        jp2.add(jpf1);
        jp3.add(jb1);

        String storedUsername = "";
        String storedPassword = "";
        try (Scanner scanner = new Scanner(new File("password.txt"))) {
            storedUsername = scanner.nextLine();
            storedPassword = scanner.nextLine();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        String Username = storedUsername;
        String Password = storedPassword;


        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf1.getText().equals(Username) && jpf1.getText().equals(Password)) {
                    JOptionPane.showMessageDialog(null, "登录成功");
                    JFrame jf = new JFrame("管理员界面");
                    jf.setLayout(new FlowLayout());

                    JButton btn2 = new JButton("修改管理员密码");
                    JButton btn3 = new JButton("查看外卖信息");
                    JButton btn4 = new JButton("退出管理员");

                    jf.add(btn2);
                    jf.add(btn3);
                    jf.add(btn4);

                    jf.setBounds(600,400,400, 300);
                    jf.setVisible(true);

                    btn2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String newUsername = JOptionPane.showInputDialog(null, "请输入新的用户名");
                            String newPassword = JOptionPane.showInputDialog(null, "请输入新的密码");
                            if (newUsername != null && newPassword != null) {
                                try (PrintWriter writer = new PrintWriter("password.txt")) {
                                    writer.println(newUsername);
                                    writer.println(newPassword);
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(null, "修改用户名和密码成功");
                            }
                        }
                    });
                    btn3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame jf = new JFrame("外卖信息");
                            JTextArea newTextArea = new JTextArea();
                            newTextArea.setEditable(false);
                            newTextArea.setFont(new Font("黑体", Font.PLAIN, 14));
                            JScrollPane newScrollPane = new JScrollPane(newTextArea);
                            jf.add(newScrollPane);
                            jf.setSize(500, 500);
                            jf.setLocationRelativeTo(null);
                            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            try {
                                BufferedReader orderReader = new BufferedReader(new FileReader("订单信息.txt"));
                                String orderLine;
                                StringBuilder content = new StringBuilder();
                                while ((orderLine = orderReader.readLine()) != null) {
                                    content.append(orderLine).append("\n");
                                }
                                orderReader.close();
                                newTextArea.setText(content.toString());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                newTextArea.setText("读取文件错误");
                            }
                            jf.setVisible(true);
                        }
                    });
                    btn4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int result = JOptionPane.showConfirmDialog(null, "是否退出登录", "退出登录", JOptionPane.YES_NO_OPTION);
                            if(result==JOptionPane.YES_OPTION) {
                                jf.setVisible(false);
                            }
                        }
                    });
                    setVisible(false);
                }
                else if (jtf1.getText().equals("") && jpf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "请输入用户名和密码！");//错误提示
                }else if (jtf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "用户名不能为空");//错误提示
                }
                else if(jpf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "密码不能为空");//错误提示
                }else{
                    JOptionPane.showMessageDialog(null, "用户或密码错误！请重试");//错误提示
                }
            }
        });
    }
}
