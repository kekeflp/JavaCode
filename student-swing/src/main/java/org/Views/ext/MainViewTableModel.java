package org.Views.ext;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * 单例数据构造类
 *
 * @author LipingFu
 */
public class MainViewTableModel extends DefaultTableModel {
    static Vector<String> columns = new Vector<>();

    // 静态代码块
    // 在类初次被加载的时候执行且仅会被执行一次（这是优化性能的原因！！！），
    // 会按照static块的顺序来执行每个static块，一般用来初始化静态变量和调用静态方法。
    static {
        columns.addElement("编号");
        columns.addElement("姓名");
        columns.addElement("学号");
        columns.addElement("生日");
        columns.addElement("家乡");
        columns.addElement("语文");
        columns.addElement("英语");
        columns.addElement("数学");
        columns.addElement("总分");
    }

    private MainViewTableModel() {
        super(null, columns);
    }

    // 饿汉式单例
    // 饿汉式，就是直接创建出类的实例化；
    // 懒汉式，就是在需要的时候再创建类的实例化
    private static MainViewTableModel mainViewTableModel = new MainViewTableModel();

    // 设置视图
    public static MainViewTableModel assembleModel(Vector<Vector<Object>> data) {
        mainViewTableModel.setDataVector(data, columns);
        return mainViewTableModel;
    }

    // 刷新视图
    public static void updateModel(Vector<Vector<Object>> data) {
        mainViewTableModel.setDataVector(data, columns);
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
