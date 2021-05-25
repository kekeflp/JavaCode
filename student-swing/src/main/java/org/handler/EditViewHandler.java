package org.handler;

import org.Views.EditView;
import org.Views.MainView;
import org.entity.StudentDO;
import org.service.IStudentService;
import org.service.impl.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditViewHandler implements ActionListener {
    EditView editView;
    MainView mainView;
    int studentId;

    public EditViewHandler(EditView editView, MainView mainView, int studentId) {
        this.editView = editView;
        this.mainView = mainView;
        this.studentId = studentId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        // 根据ID查学生
        IStudentService studentService = new StudentService();
        StudentDO studentDO =  editView.buildStudentDo();
        boolean result = studentService.update(studentDO);
        if (result) {
            // 刷新表格
            mainView.reloadTable();
            JOptionPane.showMessageDialog(editView, "编辑成功", "信息", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(editView, "编辑失败", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }
}
