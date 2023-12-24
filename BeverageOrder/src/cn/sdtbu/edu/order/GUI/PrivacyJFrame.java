package cn.sdtbu.edu.order.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName:PrivaceJFrame
 * Package:cn.sdtbu.edu.order.GUI
 * Author:@Wyh
 */
public class PrivacyJFrame {
  public static void PrintFrame() {
        JFrame frame = new JFrame("点餐前，请先阅读我们的隐私政策");
        frame.setBounds(500, 300, 600, 400);

        String text = "     感谢您使用本点餐系统，下面是我们的《隐私保护政策》。"
                + "当您点击同意并使用我们的产品服务时，即表示您已经理解并同意该条款。"
                + "如您拒绝，将无法使用并将自动退出点餐服务系统。"
                + "                                                   "
                + "您在使用我们的服务时，我们可能会收集您的个人信息，我们会尽全力保护你的信息。"
                + "您并非必须向我们提供信息，但某些情况下，如果您选择不提供，我们可能无法为您提供相关服务。";
        JTextArea textArea = new JTextArea(text, 15, 30);
        textArea.setFont(new java.awt.Font("黑体", 1, 20));

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JButton btn = new JButton("同意");
        JButton btn2 = new JButton("拒绝");
        JPanel jPanel = new JPanel();
        jPanel.add(btn);
        jPanel.add(btn2);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(jPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TakeChoose();
                frame.dispose();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        PrivacyJFrame privacyJFrame = new PrivacyJFrame();
        PrivacyJFrame.PrintFrame();
    }
}