package OrderSystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Address extends JFrame {

        private JButton btnAddress;  //修改地址
        private JButton btnOrder;    //点餐
        private JButton btnChangePassword; //修改密码

        private JTextField name;   //姓名
        private JTextField address;  //地址
        private JTextField phone;  //电话

        private JTextArea jt;  //信息显示区域
        private String infoFilePath = "info.txt";  //信息保存的文件路径
        private String accountFilePath = "account.txt";  //账号密码保存的文件路径

        public Address(){
                super("个人信息界面");
                Container c = this.getContentPane();
                c.setLayout(new FlowLayout());  //流式布局

                name = new JTextField(25);    //文本框
                address = new JTextField(25);
                phone = new JTextField(25);
                btnAddress = new JButton("修改地址");
                btnOrder = new JButton("点餐");
                btnChangePassword = new JButton("修改密码");

                c.add(new JLabel("姓名"));
                c.add(name);
                c.add(new JLabel("地址"));
                c.add(address);
                c.add(new JLabel("电话"));
                c.add(phone);

                jt = new JTextArea(10,25);
                jt.setText("个人信息\n姓名\t地址\t电话\n");
                c.add(new JScrollPane(jt));

                c.add(btnChangePassword);
                c.add(btnAddress);
                c.add(btnOrder);

                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setBounds(700,300,250,500);
                this.setVisible(true);

                initializeInfo();  // 初始化个人信息以及从文件中读取并写入文本框的方法
                displayInfo();  // 将个人信息在jt文本区域显示的方法


                //修改密码
                btnChangePassword.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String newPassword = JOptionPane.showInputDialog(null, "请输入新密码：");  // 弹出对话框输入新密码
                                if (newPassword != null && !newPassword.isEmpty()) {  // 如果输入了新密码
                                        updatePassword(newPassword);  // 调用修改密码的方法
                                        JOptionPane.showMessageDialog(null, "密码修改成功！");  // 提示密码修改成功的信息
                                }
                        }
                });

                //修改个人信息
                btnAddress.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String newName = name.getText();
                                String newAddress = address.getText();
                                String newPhone = phone.getText();

                                updateInfo(newName, newAddress, newPhone);  // 更新个人信息到文件
                                displayInfo();  // 刷新显示个人信息到jt
                        }
                });


                btnOrder.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                new Order();
                                Address.this.dispose();
                        }
                });

        }

        // 初始化个人信息以及从文件中读取
        private void initializeInfo() {
                File file = new File(infoFilePath);
                if (!file.exists()) {
                        try {
                                BufferedWriter writer = new BufferedWriter(new FileWriter(infoFilePath));
                                writer.write("小明\t山东工商学院\t19712031710");  //初始化的信息
                                writer.close();//关闭写入流
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
                try {
                        BufferedReader reader = new BufferedReader(new FileReader(infoFilePath));  //利用BufferedReader创建一个用来读取文件信息的读取流
                        String line = reader.readLine();   //读取每一行的信息
                        if (line != null) {       //如果读取的行不是空的进行下面的操作
                                String[] info = line.split("\t");   //使用制表符"\t"分隔每个信息
                                name.setText(info[0]);         //将从文件中读到的姓名信息写到文本框里
                                address.setText(info[1]);
                                phone.setText(info[2]);
                        }
                        reader.close();        //关闭读取流
                } catch (IOException e) {
                        e.printStackTrace();    //异常
                }
        }

        // 更新个人信息到文件
        private void updateInfo(String newName, String newAddress, String newPhone) {
                try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(infoFilePath));  //利用BufferedWriter创建一个用来将信息写入文件的写入流
                        writer.write(newName + "\t" + newAddress + "\t" + newPhone);  //将修改后的信息写入文件
                        writer.close();   //将写入流关闭
                } catch (IOException e) {
                        e.printStackTrace();    //异常
                }
        }

        // 显示个人信息到jt文本区域
        private void displayInfo() {
                try {
                        BufferedReader reader = new BufferedReader(new FileReader(infoFilePath));  //利用BufferedReader创建一个用来读取文件信息的读取流
                        String line = reader.readLine();  //利用数组读取文件中的每一行的信息
                        jt.setText("个人信息\n姓名\t地址\t电话\n");  //在文本区域jt添加这些东西
                        while (line != null) {        //当行信息空了就结束while循环
                                jt.append(line + "\n");   //将读取的这一行信息加到文本区域jt中
                                line = reader.readLine();   //接着读下一行
                        }
                        reader.close();     //关闭读取流
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        //修改密码
        private void updatePassword(String newPassword) {
                try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(accountFilePath));  // 创建一个写入文件的字符缓冲输出流对象
                        writer.write("admin\t" + newPassword);  // 向文件中写入新的密码
                        writer.close();  // 关闭输出流
                } catch (IOException e) {
                        e.printStackTrace();  // 打印异常信息
                }
        }

        public static void main(String[] args){

                new Address();
        }

}