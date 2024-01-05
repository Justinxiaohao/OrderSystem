package OrderSystem1;

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Checkout extends JFrame {

    JTextArea textArea = new JTextArea(15, 30);

    public Checkout(int x) {
        Container c = getContentPane();
        setTitle("结账");
        setLayout(new BorderLayout());
        textArea.setEditable(false);

        // 读取账单文件内容并在文本域中显示
        readBill();

        // 在账单文件中追加总金额
        try {
            FileWriter fileWriter = new FileWriter("账单.txt", true);
            fileWriter.write("总金额：" + x + "元");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        textArea.append("总金额：" + x + "元");

        JScrollPane scrollPane = new JScrollPane(textArea);
        c.add(scrollPane, BorderLayout.CENTER);

        // 设置标签
        JLabel label = new JLabel("欢迎下次光临!!!");
        c.add(label, BorderLayout.SOUTH);
        MergeFiles mf = new MergeFiles();
        mf.MergeFile(textArea);
        setVisible(true);
        setBounds(500, 200, 500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void readBill() {
        try {
            FileReader fileReader = new FileReader("账单.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            textArea.append("账单文件内容：\n");
            while ((line = bufferedReader.readLine()) != null) {
                textArea.append(line + "\n");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

