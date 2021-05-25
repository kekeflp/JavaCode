package org.example;

import java.awt.*;

import javax.swing.*;

/**
 * 边界容器布局，有点类似dockpanel
 *
 * @author LipingFu
 */
public class BorderLayoutTest extends JFrame {

    JButton jbtn0 = new JButton("按钮0");
    JButton jbtn1 = new JButton("按钮1");
    JButton jbtn2 = new JButton("按钮2");
    JButton jbtn3 = new JButton("按钮3");
    JButton jbtn4 = new JButton("按钮4");

    public BorderLayoutTest() {
        super("测试边界布局");

        // 在窗口内创建一个容器
        Container container = getContentPane();

        // 设置容器的布局样式管理器，可写可不写
        // container.setLayout(new BorderLayout());
        // 分别把按钮放到容器的不同位置
        jbtn0.setPreferredSize(new Dimension(200, 0));
        container.add(jbtn0, BorderLayout.WEST);
        container.add(jbtn1, BorderLayout.NORTH);
        container.add(jbtn2, BorderLayout.EAST);
        container.add(jbtn3, BorderLayout.SOUTH);
        // BorderLayout.CENTER 可写可不写，默认放置在中间
        container.add(jbtn4, BorderLayout.CENTER);

        setSize(750, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);

    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}
