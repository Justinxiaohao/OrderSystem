package OrderSystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UserLogin extends JFrame {

    private JButton btnLogin; //登录

    private JTextField accountNumber;  //账号
    private JTextField password;  //密码

    private String accountFilePath = "account.txt";

    public UserLogin(){
        super("用户登录界面");

        Container c = this.getContentPane();  // 得到了内容面板
        c.setLayout(new FlowLayout());  // 用了流式布局

        accountNumber = new JTextField(15);  // 创建文本框，用于输入账号
        password = new JTextField(15);

        btnLogin = new JButton("登录");

        c.add(new JLabel("账号"));  //标签组件，来显示账号
        c.add(accountNumber);  // 账号的文本框组件
        c.add(new JLabel("密码"));
        c.add(password);

        c.add(btnLogin);  // 登录按钮


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 窗口关闭操作用来退出程序
        this.setBounds(700,300,200,250);  // 设置窗口位置和大小
        this.setVisible(true);  // 设置窗口可见
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAccount = accountNumber.getText();  // 获取输入的账号
                String enteredPassword = password.getText();  // 获取输入的密码
                if (validateAccount(enteredAccount, enteredPassword)) {  // 调用验证账号密码的方法来和输入的进行比较，验证登录
                    JOptionPane.showMessageDialog(null, "登录成功！");  // 系统自动显示登录成功的提示信息
                    new Address();
                    UserLogin.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);  // 账号或密码错误的提示
                }
            }
        });


    }

//    // 初始化账号密码
//    private void initializeAccount() {
//        try {
//            //使用了BufferedWriter将初始化的账号密码写入文件
//            BufferedWriter writer = new BufferedWriter(new FileWriter(accountFilePath));  // 创建一个写入文件的字符缓冲输出流对象
//            writer.write("admin\tadmin");  // 向文件中写入初始账号密码
//            writer.close();  // 关闭输出流
//        } catch (IOException e) {
//            e.printStackTrace();  // 异常
//        }
//    }

    // 验证账号密码是否正确
    private boolean validateAccount(String enteredAccount, String enteredPassword) {
        try {
            //使用了BufferedReader读取文件中的账号和密码
            BufferedReader reader = new BufferedReader(new FileReader(accountFilePath));  // 创建一个读取文件的字符缓冲输入流对象
            String line = reader.readLine();  // 读取文件的一行内容

            while (line != null) {  // 循环读取每一行内容，当为空时结束循环
                String[] accountInfo = line.split("\t");
                // 将读取到的一行字符串按制表符分割为账号和密码。line是从文件中读取到的一行字符串,split("\t")的作用是将line按照制表符"\t"进行分割，将分割后的结果存储到accountInfo数组中。
                if (accountInfo[0].equals(enteredAccount) && accountInfo[1].equals(enteredPassword)) {  //使用equals来判断输入的账号密码与读取到的账号密码是不是一样
                    reader.close();  // 关闭输入流
                    return true;  // 返回账号密码验证成功
                }
                line = reader.readLine();  // 读取下一行内容
            }
            reader.close();  // 关闭输入流
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;  // 返回账号密码验证失败
    }


    public static void main(String[] args) {
        new UserLogin();  // 创建用户登录界面对象
    }
}
