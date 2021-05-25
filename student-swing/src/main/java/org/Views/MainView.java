package org.Views;

import javax.swing.*;

import org.Views.ext.MainViewTable;
import org.Views.ext.MainViewTableModel;
import org.dto.TableDTO;
import org.entity.StudentRequest;
import org.handler.MainViewHandler;
import org.service.IStudentService;
import org.service.impl.StudentService;

import java.awt.*;
import java.net.URL;
import java.util.Vector;

/**
 * 主业务视图
 *
 * @author LipingFu
 */
public class MainView extends JFrame {
    JPanel panelUp = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton btnAdd = new JButton("增加");
    JButton btnEdit = new JButton("修改");
    JButton btnDelete = new JButton("删除");
    JTextField tbxSearch = new JTextField(30);
    JButton btnSearch = new JButton("搜索");

    MainViewTable mainViewTable = new MainViewTable();

    JPanel panelDown = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton btnPre = new JButton("上一页");
    JButton btnNext = new JButton("下一页");

    // 分页
    private int pageNow = 1; //当前页
    private int pageSize = 10;//每页的条目数

    // 事件
    MainViewHandler mainViewHandler;

    public MainView() {
        super("学生成绩管理系统");
        // todo 计算当前窗体的高度,来动态的设置分页大小

        // 窗体作为值传递
        mainViewHandler = new MainViewHandler(this);

        Container contentPane = getContentPane();
        // 上容器布局
        panelUpLayout(contentPane);

        // 中间容器布局

        panelCenterLayout(contentPane);

        // 下容器布局
        panelDownLayout(contentPane);

        // 设置窗体ICON
        URL imgUrl = LoginView.class.getClassLoader().getResource("shutlle.png");
        setIconImage(new ImageIcon(imgUrl).getImage());

        // 设置初始屏幕大小
        setSize(1000, 600);
        // 最大化，当加上这句时，优先级高于 setSize(1000, 600);
        setExtendedState(MAXIMIZED_BOTH);

        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    private void panelUpLayout(Container contentPane) {
        // 增加事件监听
        btnAdd.addActionListener(mainViewHandler);
        btnEdit.addActionListener(mainViewHandler);
        btnDelete.addActionListener(mainViewHandler);
        btnSearch.addActionListener(mainViewHandler);

        panelUp.add(btnAdd);
        panelUp.add(btnEdit);
        panelUp.add(btnDelete);
        panelUp.add(tbxSearch);
        panelUp.add(btnSearch);

        contentPane.add(panelUp, BorderLayout.NORTH);
    }

    private void panelCenterLayout(Container contentPane) {
        // #region 测试数据
//        Vector<Vector<Object>> data = new Vector<>();
//        Vector<Object> row;
//        for (int i = 0; i < 50; i++) {
//            row = new Vector<>();
//            row.addElement(i);
//            row.addElement("姓名" + i);
//            row.addElement("学号" + i);
//            row.addElement("家乡" + i);
//            row.addElement("语文" + i);
//            row.addElement("数学" + i);
//            row.addElement("英语" + i);
//            row.addElement("总分" + i);
//            data.addElement(row);
//        }
        // #endregion

        TableDTO dto = getTableDTO();
        Vector<Vector<Object>> data = dto.getData();
        MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(data);

        mainViewTable.setModel(mainViewTableModel);
        mainViewTable.renderRule();
        JScrollPane jScrollPane = new JScrollPane(mainViewTable);
        contentPane.add(jScrollPane, BorderLayout.CENTER);

        showPreNext(dto.getTotalCount());
    }

    private void panelDownLayout(Container contentPane) {
        panelDown.add(btnPre);
        panelDown.add(btnNext);
        contentPane.add(panelDown, BorderLayout.SOUTH);

        // 增加事件监听
        btnPre.addActionListener(mainViewHandler);
        btnNext.addActionListener(mainViewHandler);
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageNow() {
        return pageNow;
    }

    // 刷新视图
    public void reloadTable() {
        Vector<Vector<Object>> data = getTableDTO().getData();
        MainViewTableModel.updateModel(data);
        mainViewTable.renderRule();
        showPreNext(getTableDTO().getTotalCount());
    }

    // 封装成DTO对象
    private TableDTO getTableDTO() {
        IStudentService studentService = new StudentService();
        StudentRequest request = new StudentRequest();
        request.setPageNow(pageNow);
        request.setPageSize(pageSize);
        request.setSearchKey(tbxSearch.getText().trim());
        return studentService.queryAll(request);
    }

    // 设置翻页按钮是否可见
    private void showPreNext(int totalCount) {
        // 判断上一页是否可见
        if (pageNow == 1) {
            btnPre.setVisible(false);
        } else {
            btnPre.setVisible(true);
        }
        int pageCount = 0; // 总页数
        if (totalCount % pageSize == 0) {
            pageCount = totalCount / pageSize;
        } else {
            pageCount = totalCount / pageSize + 1;
        }
        if (pageNow == pageCount) {
            btnNext.setVisible(false);
        } else {
            btnNext.setVisible(true);
        }
    }

    // 获取单个选中对象的ID
    public int getSelectedStudentId() {
        int selectedRow = mainViewTable.getSelectedRow();
        Object id = mainViewTable.getValueAt(selectedRow, 0);
        return (int) id;
    }

    // 获取多个选中对象的ID集合
    public int[] getSelectedStudentIds() {
        // 获取多选行的对象的索引
        int[] selectedRowIndex = mainViewTable.getSelectedRows();
        int[] ids = new int[selectedRowIndex.length];
        for (int i = 0; i < selectedRowIndex.length; i++) {
            // 再把多选对象中的每个一个首列的值交换给新的数组,就取到了id数组
            ids[i] = (int) mainViewTable.getValueAt(selectedRowIndex[i], 0);
        }
        return ids;
    }

    public static void main(String[] args) {
        new MainView();
    }
}
