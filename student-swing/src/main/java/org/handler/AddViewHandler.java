package org.handler;

import org.Views.AddView;
import org.Views.MainView;
import org.entity.StudentDO;
import org.service.IStudentService;
import org.service.impl.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddViewHandler implements ActionListener {

    AddView addView;
    MainView mainView;

    public AddViewHandler(AddView addView, MainView mainView) {
        this.addView = addView;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        IStudentService studentService = new StudentService();
        StudentDO studentDO = addView.buildStudentDo();
        boolean result = studentService.add(studentDO);
        if (result) {
            // 刷新表格
            mainView.reloadTable();
            JOptionPane.showMessageDialog(addView, "添加成功", "信息", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(addView, "添加失败", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }
}
