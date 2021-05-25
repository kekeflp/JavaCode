package org.Views.ext;

import java.awt.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 单元格样式渲染类
 *
 * @author LipingFu
 */
public class MainViewCellRender extends DefaultTableCellRenderer {
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
