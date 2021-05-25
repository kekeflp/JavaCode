package org.example;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

import java.awt.*;

/**
 * 弹性布局/响应式布局 先定位一个后,其他的组件参照第一个来定位,有点类似CanvasPanel通过坐标来约束定位
 * 
 * @author LipingFu
 */
public class SpringLayoutTest extends JFrame {

    SpringLayout springLayout = new SpringLayout();
    JPanel jp = new JPanel(springLayout);

    JLabel lblTitel = new JLabel("文章标题：");
    JLabel lblAuthore = new JLabel("作者：");
    JLabel lblContent = new JLabel("内容：");
    JTextField tbxTitle = new JTextField(10);
    JTextField tbxAuthore = new JTextField(10);
    JTextArea tbxContent = new JTextArea(4, 20);

    public SpringLayoutTest() {
        super("测试弹性布局");

        Container container = getContentPane();

        jp.add(lblTitel);
        jp.add(lblAuthore);
        jp.add(lblContent);
        jp.add(tbxTitle);
        jp.add(tbxAuthore);
        jp.add(tbxContent);

        jp.setBackground(Color.lightGray);
        container.add(jp);

        /**
         * 需要掌握3个重要的类-约束布局 1.SpringLayout: 布局管理器 2.SpringLayout.Constraints:
         * 使用弹式布局容器里组件的布局约束,每个组件对应一个 3.Spring: 可以理解为一个能够进行四则运算的整数
         */

        // 坐标原点从左上角开始0,0 横坐标为X,纵坐标为Y
        // 标签组件约束: 设置标签的左上角坐标为 (100, 100)
        Constraints constraint = springLayout.getConstraints(lblTitel);
        constraint.setX(Spring.constant(100));
        constraint.setY(Spring.constant(100));

        // lblAuthore与lblTitel 右对齐,距离为0px
        springLayout.putConstraint(SpringLayout.EAST, lblAuthore, 0, SpringLayout.EAST, lblTitel);
        // lblAuthore在lblTitel 距离下方20px处
        springLayout.putConstraint(SpringLayout.NORTH, lblAuthore, 20, SpringLayout.SOUTH, lblTitel);

        springLayout.putConstraint(SpringLayout.EAST, lblContent, 0, SpringLayout.EAST, lblAuthore);
        springLayout.putConstraint(SpringLayout.NORTH, lblContent, 20, SpringLayout.SOUTH, lblAuthore);

        // tbxTitle与lblTitel 的 margin="20 0 0 0"
        springLayout.putConstraint(SpringLayout.WEST, tbxTitle, 20, SpringLayout.EAST, lblTitel);
        springLayout.putConstraint(SpringLayout.NORTH, tbxTitle, 0, SpringLayout.NORTH, lblTitel);

        springLayout.putConstraint(SpringLayout.WEST, tbxAuthore, 20, SpringLayout.EAST, lblAuthore);
        springLayout.putConstraint(SpringLayout.NORTH, tbxAuthore, 0, SpringLayout.NORTH, lblAuthore);

        springLayout.putConstraint(SpringLayout.WEST, tbxContent, 20, SpringLayout.EAST, lblContent);
        springLayout.putConstraint(SpringLayout.NORTH, tbxContent, 0, SpringLayout.NORTH, lblContent);

        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);

        // #region 官方教程中的写法
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
        // String[] labels = { "Name: ", "Fax: ", "Email: ", "Address: " };
        // int numPairs = labels.length;

        // Create and populate the panel.
        // JPanel p = new JPanel(new SpringLayout());
        // for (int i = 0; i < numPairs; i++) {
        // JLabel l = new JLabel(labels[i], JLabel.TRAILING);
        // p.add(l);
        // JTextField textField = new JTextField(10);
        // l.setLabelFor(textField);
        // p.add(textField);
        // }

        // Lay out the panel.
        // SpringUtilities.makeCompactGrid(p, numPairs, 2, // rows, cols
        // 6, 6, // initX, initY
        // 6, 6); // xPad, yPad
        // #endregion
    }

    public static void main(String[] args) {
        new SpringLayoutTest();
    }
}
