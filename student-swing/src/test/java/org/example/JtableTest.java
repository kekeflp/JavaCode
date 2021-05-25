package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

/**
 * 表格组件
 *
 * @author LipingFu
 */
public class JtableTest extends JFrame {
    public JtableTest() {
        super("JTable表格测试");

        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> row;
        for (int i = 0; i < 100; i++) {
            row = new Vector<>();
            row.addElement(i);
            row.addElement("姓名" + i);
            row.addElement("学号" + i);
            row.addElement("家乡" + i);
            row.addElement("语文" + i);
            row.addElement("数学" + i);
            row.addElement("英语" + i);
            row.addElement("总分" + i);
            data.addElement(row);
        }

        // DefaultTableModel tableModel = new DefaultTableModel(10, 10);
        // tableModel.setDataVector(data, columns);
        // JTable table = new JTable(tableModel);

        // 改写成单例模式
        JTable table = new JTable(StudentTableModel.assembleModel(data));

        // 设置表头样式
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font(null, Font.BOLD, 16));
        header.setForeground(Color.red);
        // 设置表格体样式
        table.setFont(new Font(null, Font.PLAIN, 14));
        table.setForeground(Color.black);
        table.setGridColor(Color.black);
        table.setRowHeight(30);
        // 设置多行选择,默认是单选
        table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // 设置表格列的渲染方式
        // 获取所有的列
        Vector<String> columns = StudentTableModel.getColumn();
        StudentCellRender render = new StudentCellRender();
        for (int i = 0; i < columns.size(); i++) {
            // 循环获取每一列，并渲染
            TableColumn column = table.getColumn(columns.get(i));
            column.setCellRenderer(render);
            // 设置首列宽度大小
            if (i == 0) {
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            }
        }

        // JTable默认是不显示列头, 如果放在JScrollPane中, 则可以显示列头
        JScrollPane jScrollPane = new JScrollPane(table);

        Container contentPane = getContentPane();
        contentPane.add(jScrollPane);

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    public static void main(String[] args) {
        new JtableTest();
    }
}

/**
 * 单例数据构造类
 *
 * @author LipingFu
 */
class StudentTableModel extends DefaultTableModel {

    static Vector<String> columns = new Vector<>();

    // 静态代码块
    // 在类初次被加载的时候执行且仅会被执行一次（这是优化性能的原因！！！），
    // 会按照static块的顺序来执行每个static块，一般用来初始化静态变量和调用静态方法。
    static {
        columns.addElement("编号");
        columns.addElement("姓名");
        columns.addElement("学号");
        columns.addElement("家乡");
        columns.addElement("语文");
        columns.addElement("数学");
        columns.addElement("英语");
        columns.addElement("总分");
    }

    private StudentTableModel() {
        super(null, columns);
    }

    // 饿汉式单例
    // 饿汉式，就是直接创建出类的实例化；
    // 懒汉式，就是在需要的时候再创建类的实例化
    private static StudentTableModel studentTableModel = new StudentTableModel();

    public static StudentTableModel assembleModel(Vector<Vector<Object>> data) {
        studentTableModel.setDataVector(data, columns);
        return studentTableModel;
    }

    // 暴露列名的方法
    public static Vector<String> getColumn() {
        return columns;
    }

    // 禁用单元格可编辑模式
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

/**
 * 单元格样式渲染类
 *
 * @author LipingFu
 */
class StudentCellRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        // 设置隔行变色
        if (row % 2 == 0) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }

        // 设置单元格内容水平居中
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}