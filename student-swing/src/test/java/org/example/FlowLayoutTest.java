package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * 流式布局 有点类似stackpanel 默认是水平方向布局
 * 
 * @author LipingFu
 */
public class FlowLayoutTest extends JFrame {

    // JPanel 默认就是流式布局
    JPanel jPanel = new JPanel();
    JButton jbtn0 = new JButton("按钮0");
    JButton jbtn1 = new JButton("按钮1");
    JButton jbtn2 = new JButton("按钮2");
    JButton jbtn3 = new JButton("按钮3");
    JButton jbtn4 = new JButton("按钮4");
    JButton jbtn5 = new JButton("按钮5");
    JButton jbtn6 = new JButton("按钮6");
    JButton jbtn7 = new JButton("按钮7");
    JButton jbtn8 = new JButton("按钮8");
    JButton jbtn9 = new JButton("按钮9");

    public FlowLayoutTest() {
        super("测试流式布局");

        // 在窗口内创建一个容器
        Container container = getContentPane();

        jPanel.add(jbtn0);
        jPanel.add(jbtn1);
        jPanel.add(jbtn2);
        jPanel.add(jbtn3);
        jPanel.add(jbtn4);
        jPanel.add(jbtn5);
        jPanel.add(jbtn6);
        jPanel.add(jbtn7);
        jPanel.add(jbtn8);
        jPanel.add(jbtn9);

        container.add(jPanel);

        setSize(450, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);

    }

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}
