package org.Views.ext;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class MainViewTable extends JTable {

    public MainViewTable() {
        JTableHeader header = getTableHeader();
        header.setFont(new Font(null, Font.BOLD, 16));
        header.setForeground(Color.red);
        // 设置表格体样式
        setFont(new Font(null, Font.PLAIN, 14));
        setForeground(Color.black);
        setGridColor(Color.black);
        setRowHeight(30);
        // 设置多行选择,默认是单选
        getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    public void renderRule() {
        // 设置表格列的渲染方式
        // 获取所有的列
        Vector<String> columns = MainViewTableModel.getColumn();
        MainViewCellRender render = new MainViewCellRender();
        for (int i = 0; i < columns.size(); i++) {
            // 循环获取每一列，并渲染
            TableColumn column = getColumn(columns.get(i));
            column.setCellRenderer(render);
            // 设置首列宽度大小
            if (i == 0) {
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            }
        }
    }

}
