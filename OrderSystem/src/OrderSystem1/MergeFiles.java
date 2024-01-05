package OrderSystem1;

import javax.swing.*;
import java.io.*;

public class MergeFiles {
    public void MergeFile(JTextArea textArea) {
        String pointFilePath = "账单.txt";
        String userFilePath = "info.txt";
        String orderFilePath = "订单信息.txt";

        try {
            // 读取用户信息文件
            FileReader fileReader = new FileReader(userFilePath);
            BufferedReader userReader = new BufferedReader(fileReader);
            // 读取菜单信息文件
            FileReader fileReader2 = new FileReader(pointFilePath);
            BufferedReader pointReader = new BufferedReader(fileReader2);
            String userLine;
            String pointLine;
            // 创建一个新文件来暂时保存用户信息和点餐信息
            String tempFilePath = "temp.txt";
            BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFilePath));
            // 循环遍历用户信息文件的每一行
            while ((userLine = userReader.readLine()) != null) {
                String[] userInfo = userLine.split("\t");
                tempWriter.write("\n姓名: " + userInfo[0]);
                tempWriter.newLine();
                tempWriter.write("地址: " + userInfo[1]);
                tempWriter.newLine();
                tempWriter.write("电话: " + userInfo[2]);
                tempWriter.newLine();
            }
            userReader.close();
            while ((pointLine = pointReader.readLine()) != null) {
                tempWriter.write(pointLine);
                tempWriter.newLine();
            }

            pointReader.close();
            tempWriter.close();

            // 将临时文件中的信息添加到订单信息文件中
            BufferedReader tempReader = new BufferedReader(new FileReader(tempFilePath));
            BufferedWriter orderWriter = new BufferedWriter(new FileWriter(orderFilePath,true));

            String tempLine;
            while ((tempLine = tempReader.readLine()) != null) {
                orderWriter.write(tempLine);
                orderWriter.newLine();
            }

            tempReader.close();
            orderWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

