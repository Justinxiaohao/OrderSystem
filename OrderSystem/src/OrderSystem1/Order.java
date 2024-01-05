package OrderSystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Order extends JFrame implements ActionListener {

    JPanel center = new JPanel();//中面板
    JPanel north = new JPanel();//北面板
    JPanel south = new JPanel();//南面板
    JPanel west = new JPanel();//西面板
    JPanel east = new JPanel();//东面板
    JPanel milkteaJP = new JPanel(new GridLayout(3,3,10,10));//奶茶面板
    JPanel coffeeJP = new JPanel(new GridLayout(3,3,10,10));//咖啡面板
    JPanel nectarJP = new JPanel(new GridLayout(3,3,10,10));//果茶面板
    JPanel icecreamJP = new JPanel(new GridLayout(3,3,10,10));//冰淇淋面板
    JPanel teaJP = new JPanel(new GridLayout(3,3,10,10));//纯茶面板
    JLabel northLabel1 = new JLabel("饮品点餐系统",JLabel.CENTER);//北标签
    JLabel eastLabel1 = new JLabel("已点菜式列表：",JLabel.LEFT);//东标签
    JLabel eastLabel2 = new JLabel("总金额：0元",JLabel.CENTER);
    JButton milkteaButton = new JButton("  奶  茶  ");//西面板按钮
    JButton coffeeButton = new JButton("  咖  啡  ");
    JButton nectarButton = new JButton("  果  茶  ");
    JButton icecreamButton = new JButton("  冰淇淋   ");
    JButton teaButton = new JButton("  纯  茶   ");
    JButton emptyButton = new JButton("  清空   ");//南面板按钮
    JButton downButton = new JButton("  下单   ");
    JButton addButton = new JButton("  加单   ");
    JButton checkButton = new JButton("  结账   ");
    JMenuBar menuBar = new JMenuBar();//菜单栏
    JTextField textField = new JTextField("0");//文本框
    JTextArea textArea = new JTextArea(15,30);
    JScrollPane scrollPane;//可滚动的
    String[] cardName = {"1","2","3","4","5"};//卡片名字
    CardLayout card = new CardLayout();//定义卡片布局对象
    JButton centerButton1,centerButton2,centerButton3,centerButton4,centerButton5, centerButton6,centerButton7,centerButton8,centerButton9,
            centerButton10,centerButton11,centerButton12,centerButton13,centerButton14, centerButton15;//中图片按钮
    JLabel centerLabel1,centerLabel2,centerLabel3;//中饮品标签
    int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0,i7=0,i8=0,i9=0,i10=0,i11=0,i12=0,i13=0,i14=0,i15=0;
    int sum = 0;//
    int num = 0;
    int alltotal = 0;//
    ImageIcon img;//中图片

    //构造方法
    public Order() {
        Container c = getContentPane();
        setTitle("饮品点餐系统");
        setLayout(new BorderLayout(50,0));//窗口边界布局
        west.setBorder(BorderFactory.createTitledBorder("饮品导航"));//西边框

        setJMenuBar(menuBar);//添加菜单栏
        c.add(center,BorderLayout.CENTER);//添加面板
        c.add(north,BorderLayout.NORTH);
        c.add(south,BorderLayout.SOUTH);
        c.add(west,BorderLayout.WEST);
        c.add(east,BorderLayout.EAST);


        //北面板
        Font f = new Font("楷体",Font.PLAIN,45); //设置北标签
        northLabel1.setFont(f);
        northLabel1.setForeground(Color.BLACK);//字体颜色
//    JMenu menu = new JMenu("系统设置");
//    menuBar.add(menu);//添加进菜单栏
//    JMenuItem menu1 = new JMenuItem("管理员登录");
//    menu.add(menu1);//添加进系统设置
//	JMenuItem menu2 = new JMenuItem("外卖订餐");
//	menu.add(menu2);
        north.add(northLabel1);
        //监听
        //管理员登录
//	menu1.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			new Admin();
//		}
//	});
//	menu2.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			new AddAddress();
//			order.this.dispose();
//		}
//	});


        //西面板
        west.setLayout(new GridLayout(15,1,10,10));
        west.add(milkteaButton);
        west.add(coffeeButton);
        west.add(nectarButton);
        west.add(icecreamButton);
        west.add(teaButton);
        //注册监听器
        milkteaButton.addActionListener(this);
        coffeeButton.addActionListener(this);
        nectarButton.addActionListener(this);
        icecreamButton.addActionListener(this);
        teaButton.addActionListener(this);

        //南面板
        south.add(emptyButton);//添加按钮
        south.add(downButton);
        south.add(addButton);
        south.add(checkButton);
        emptyButton.addActionListener(this);
        downButton.addActionListener(this);
        addButton.addActionListener(this);
        checkButton.addActionListener(this);

        //东面板
        east.setLayout(new GridLayout(4,1));//东面板布局
        east.add(eastLabel1);
        textArea.append("菜名\t价格\t数量\n");
        textArea.setEditable(false);//文本域不可修改
        scrollPane = new JScrollPane(textArea);//将列表设置为滚动
        east.add(scrollPane);
        east.add(eastLabel2);

        //中面板
        center.setLayout(card);//设置center面板为卡片布局
        center.add(cardName[0],milkteaJP);//分别将面板添加进卡片
        center.add(cardName[1],coffeeJP);
        center.add(cardName[2],nectarJP);
        center.add(cardName[3],icecreamJP);
        center.add(cardName[4],teaJP);

        //冰淇淋卡片
        img = new ImageIcon("src/src/icecream/1.png");//每次循环迭代时都会为img创建一个新的ImageIcon实例
        centerButton1 = new JButton("奥利奥圣代\t6元",img);
        img = new ImageIcon("src/src/icecream/2.png");
        centerButton2 = new JButton("草莓圣代\t6元",img);
        img = new ImageIcon("src/src/icecream/3.png");
        centerButton3 = new JButton("芒果圣代\t6元",img);
        //价格
        centerLabel1 = new JLabel("奥利奥圣代/6元",JLabel.CENTER);
        centerLabel2 = new JLabel("草莓圣代/6元",JLabel.CENTER);
        centerLabel3 = new JLabel("芒果圣代/6元",JLabel.CENTER);
        //添加进冰淇淋卡片
        icecreamJP.add(centerButton1);icecreamJP.add(centerLabel1);
        icecreamJP.add(centerButton2);icecreamJP.add(centerLabel2);
        icecreamJP.add(centerButton3);icecreamJP.add(centerLabel3);

        //咖啡卡片
        img = new ImageIcon("src/src/coffee/10.png");
        centerButton4 = new JButton("拿铁咖啡\t7元",img);
        img = new ImageIcon("src/src/coffee/11.png");
        centerButton5 = new JButton("美式咖啡\t5元",img);
        img = new ImageIcon("src/src/coffee/12.png");
        centerButton6 = new JButton("咖啡椰椰\t7元",img);
        //价格
        centerLabel1 = new JLabel("拿铁咖啡/7元",JLabel.CENTER);
        centerLabel2 = new JLabel("美式咖啡/5元",JLabel.CENTER);
        centerLabel3 = new JLabel("咖啡椰椰/7元",JLabel.CENTER);
        //添加进咖啡卡片
        coffeeJP.add(centerButton4);coffeeJP.add(centerLabel1);
        coffeeJP.add(centerButton5);coffeeJP.add(centerLabel2);
        coffeeJP.add(centerButton6);coffeeJP.add(centerLabel3);

        //果茶卡片
        img = new ImageIcon("src/src/nectar/7.png");
        centerButton7 = new JButton("蜜桃四季春\t7元",img);
        img = new ImageIcon("src/src/nectar/8.png");
        centerButton8 = new JButton("百香芒芒\t7元",img);
        img = new ImageIcon("src/src/nectar/9.png");
        centerButton9 = new JButton("草莓啵啵\t9元",img);
        //价格
        centerLabel1 = new JLabel("蜜桃四季春/7元",JLabel.CENTER);
        centerLabel2 = new JLabel("百香芒芒/7元",JLabel.CENTER);
        centerLabel3 = new JLabel("草莓啵啵/9元",JLabel.CENTER);
        //添加进果茶卡片
        nectarJP.add(centerButton7);nectarJP.add(centerLabel1);
        nectarJP.add(centerButton8);nectarJP.add(centerLabel2);
        nectarJP.add(centerButton9);nectarJP.add(centerLabel3);


        //奶茶卡片
        img = new ImageIcon("src/src/milktea/4.png");
        centerButton10 = new JButton("芋泥奶茶\t7元",img);
        img = new ImageIcon("src/src/milktea/5.png");
        centerButton11 = new JButton("三拼霸霸奶茶\t8元",img);
        img = new ImageIcon("src/src/milktea/6.png");
        centerButton12 = new JButton("红豆奶茶\t7元",img);
        //价格
        centerLabel1 = new JLabel("芋泥奶茶/7元",JLabel.CENTER);
        centerLabel2 = new JLabel("三拼霸霸奶茶/8元",JLabel.CENTER);
        centerLabel3 = new JLabel("红豆奶茶/7元",JLabel.CENTER);
        //添加进奶茶卡片
        milkteaJP.add(centerButton10);milkteaJP.add(centerLabel1);
        milkteaJP.add(centerButton11);milkteaJP.add(centerLabel2);
        milkteaJP.add(centerButton12);milkteaJP.add(centerLabel3);


        //纯茶卡片
        img = new ImageIcon("src/src/tea/13.png");
        centerButton13 = new JButton("芝士奶盖绿茶\t8元",img);
        img = new ImageIcon("src/src/tea/14.png");
        centerButton14 = new JButton("高山四季春茶\t4元",img);
        img = new ImageIcon("src/src/tea/15.png");
        centerButton15 = new JButton("茉莉绿茶\t5元",img);
        //价格
        centerLabel1 = new JLabel("芝士奶盖绿茶88元",JLabel.CENTER);
        centerLabel2 = new JLabel("高山四季春茶/4元",JLabel.CENTER);
        centerLabel3 = new JLabel("茉莉绿茶/5元",JLabel.CENTER);
        //添加进纯茶卡片
        teaJP.add(centerButton13);teaJP.add(centerLabel1);
        teaJP.add(centerButton14);teaJP.add(centerLabel2);
        teaJP.add(centerButton15);teaJP.add(centerLabel3);

        //监听15个图片按钮
        centerButton1.addActionListener(this);
        centerButton2.addActionListener(this);
        centerButton3.addActionListener(this);
        centerButton4.addActionListener(this);
        centerButton5.addActionListener(this);
        centerButton6.addActionListener(this);
        centerButton7.addActionListener(this);
        centerButton8.addActionListener(this);
        centerButton9.addActionListener(this);
        centerButton10.addActionListener(this);
        centerButton11.addActionListener(this);
        centerButton12.addActionListener(this);
        centerButton13.addActionListener(this);
        centerButton14.addActionListener(this);
        centerButton15.addActionListener(this);


        setBounds(300,50,1200,950);//设置窗口位置大小
        setVisible(true);//窗口可见
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//窗口关闭方式
    }

    //监听按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        //清空按钮
        if(e.getSource()==emptyButton) {
            if(num==0) {
                textArea.setText("饮品\t价格\t数量\n");
                i1=0;i2=0;i3=0;i4=0;i5=0;i6=0;i7=0;i8=0;i9=0;i10=0;i11=0;i12=0;i13=0;i14=0;i15=0;
                eastLabel2.setText("总金额：0元");//重置标签内容
                textField.setText("0");
            }
            else if(num==1) {
                JOptionPane.showMessageDialog(null, "很抱歉，已经下单了，无法取消！");
            }
        }
        //下单按钮
        if(e.getSource()==downButton) {
            if(num==0) {
                if(textArea.getText().equals("饮品\t价格\t数量\n")){
                    JOptionPane.showMessageDialog(null, "请点餐！");
                }
                else {
                    writer(textArea.getText());
                    eastLabel2.setText("总金额："+total()+"元");
                    num=1;
                    JOptionPane.showMessageDialog(null, "下单成功！");
                }
            }
            else if(num==1){
                JOptionPane.showMessageDialog(null, "已下单，请勿重复下单，如需加菜请点加单！");
            }
        }

        //加单按钮
        if(e.getSource()==addButton) {
            if(num==1) {
                if(sum!=total()) {
                    writer(textArea.getText());
                    eastLabel2.setText("总金额："+total()+"元");
                    JOptionPane.showMessageDialog(null, "加单成功！");
                }
                else{
                    JOptionPane.showMessageDialog(null, "请选择要增加的饮品！");
                }}
            else{
                JOptionPane.showMessageDialog(null, "请先下单！");
            }}

        //结账按钮
        if(e.getSource()==checkButton) {
            if(num==1) {
                new Checkout(total());
                i1=0;i2=0;i3=0;i4=0;i5=0;i6=0;i7=0;i8=0;i9=0;i10=0;i11=0;i12=0;i13=0;i14=0;i15=0;
                textArea.setText("饮品\t价格\t数量\n");
                textField.setText("0");
                num=0;
                eastLabel2.setText("总金额：0元");
            }
            else if(num==0){
                JOptionPane.showMessageDialog(null, "请先下单！");
            }
        }


        if(e.getSource()==milkteaButton) {
            center.setBorder(BorderFactory.createTitledBorder("   奶茶"));//中边框
            card.show(center, cardName[0]);//展示卡片0
        }
        if(e.getSource()==coffeeButton) {
            center.setBorder(BorderFactory.createTitledBorder("   咖啡"));//中边框
            card.show(center, cardName[1]);
        }
        if(e.getSource()==nectarButton) {
            center.setBorder(BorderFactory.createTitledBorder("   果茶"));//中边框
            card.show(center, cardName[2]);
        }
        if(e.getSource()==icecreamButton) {
            center.setBorder(BorderFactory.createTitledBorder("   冰淇淋"));//中边框
            card.show(center, cardName[3]);
        }
        if(e.getSource()==teaButton) {
            center.setBorder(BorderFactory.createTitledBorder("   纯茶"));//中边框
            card.show(center, cardName[4]);
        }
        if(e.getSource()==centerButton1) {
            textArea.append(centerButton1.getText()+"\t1"+"\n");
//			int price = addtoppings.getInstance().getToppingsPrice();
//			System.out.println(price);
            i1+=6;
            System.out.println(i1);
        }
        if(e.getSource()==centerButton2) {
            textArea.append(centerButton2.getText()+"\t1"+"\n");
            i2+=6;
        }
        if(e.getSource()==centerButton3) {
            textArea.append(centerButton3.getText()+"\t1"+"\n");
            i3+=6;
        }
        if(e.getSource()==centerButton4) {
            textArea.append(centerButton4.getText()+"\t1"+"\n");
            i4+=7;
        }
        if(e.getSource()==centerButton5) {
            textArea.append(centerButton5.getText()+"\t1"+"\n");
            i5+=8;
        }
        if(e.getSource()==centerButton6) {
            textArea.append(centerButton6.getText()+"\t1"+"\n");
            i6+=7;
        }
        if(e.getSource()==centerButton7) {
            textArea.append(centerButton7.getText()+"\t1"+"\n");
            i7+=7;
        }
        if(e.getSource()==centerButton8) {
            textArea.append(centerButton8.getText()+"\t1"+"\n");
            i8+=7;
        }
        if(e.getSource()==centerButton9) {
            textArea.append(centerButton9.getText()+"\t1"+"\n");
            i9+=9;
        }
        if(e.getSource()==centerButton10) {
            textArea.append(centerButton10.getText()+"\t1"+"\n");
            i10+=7;
        }
        if(e.getSource()==centerButton11) {
            textArea.append(centerButton11.getText()+"\t1"+"\n");
            i11+=8;
        }
        if(e.getSource()==centerButton12) {
            textArea.append(centerButton12.getText()+"\t1"+"\n");
            i12+=7;
        }
        if(e.getSource()==centerButton13) {
            textArea.append(centerButton13.getText()+"\t1"+"\n");
            i13+=8;
        }
        if(e.getSource()==centerButton14) {
            textArea.append(centerButton14.getText()+"\t1"+"\n");
            i14+=4;
        }
        if(e.getSource()==centerButton15) {
            textArea.append(centerButton15.getText()+"\t1"+"\n");
            i15+=5;
        }
    }

    public void writer(String line) {
        try {
            File f = new File("账单.txt");
            if(!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            fw.write(line);//写入账单文件
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int total() {
        sum = i1+i2+i3+i4+i5+i6+i7+i8+i9+i10+i11+i12+i13+i14+i15;
        return sum;
    }
    public static void main(String[] args) {
        new Order();
    }

}

