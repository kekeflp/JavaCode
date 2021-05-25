package org.handler;

import org.Views.AddView;
import org.Views.EditView;
import org.Views.MainView;
import org.entity.StudentDO;
import org.service.IStudentService;
import org.service.impl.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewHandler implements ActionListener {

    private MainView mainView;
    private int[] selectedStudentIds;

    public MainViewHandler(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        switch (text) {
            case "增加":
                new AddView(mainView);
                break;
            case "修改":
                Edit();
                break;
            case "删除":
                Delete();
                break;
            case "搜索":
                mainView.setPageNow(1);
                mainView.reloadTable();
                break;
            case "上一页":
                mainView.setPageNow(mainView.getPageNow() - 1);
                mainView.reloadTable();
                break;
            case "下一页":
                mainView.setPageNow(mainView.getPageNow() + 1);
                mainView.reloadTable();
                break;
        }
    }

    private void Edit() {
        selectedStudentIds = mainView.getSelectedStudentIds();
        if (selectedStudentIds.length == 1) {
            new EditView(mainView, selectedStudentIds[0]);
        } else {
            //如果是多选了,就是请选择一条
            JOptionPane.showMessageDialog(mainView, "请选择一个条目后再编辑!", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void Delete() {
        selectedStudentIds = mainView.getSelectedStudentIds();
        if (selectedStudentIds.length == 0) {
            JOptionPane.showMessageDialog(mainView, "请选择要删除的行!", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(mainView, "是否要删除选择的 " + selectedStudentIds.length + " 行吗?", "确认删除", JOptionPane.YES_NO_OPTION);
        //  if (result != 0) return; 或者
        if (result != JOptionPane.YES_OPTION) return;

        IStudentService studentService = new StudentService();
        if (studentService.delete(selectedStudentIds)) {
            JOptionPane.showMessageDialog(mainView, "删除操作成功!", "信息", JOptionPane.INFORMATION_MESSAGE);
            mainView.reloadTable();
        } else {
            JOptionPane.showMessageDialog(mainView, "删除操作失败!", "信息", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}