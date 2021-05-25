package org.example;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 容器组件与非容器组件
 * 
 * @author LipingFu
 */
public class JframeTest extends JFrame {
    JButton jButton;

    public JframeTest() {
        super("这是frame的标题");

        jButton = new JButton("这是一个按钮");
        Container container = getContentPane();
        container.add(jButton);

        // 设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("shutlle.png");
        setIconImage(new ImageIcon(resource).getImage());
        // 窗口大小
        setSize(800, 400);
        // 窗口可见
        setVisible(true);
        // 居中
        setLocationRelativeTo(null);
        // 关闭时退出进程
        setDefaultCloseOperation(3);
    }

    public static void main(String[] args) {
        new JframeTest();
    }
}