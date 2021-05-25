package org.Views;

import org.entity.StudentDO;
import org.handler.EditViewHandler;
import org.service.IStudentService;
import org.service.impl.StudentService;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class EditView extends JDialog {
    JLabel lblXingming = new JLabel("姓名:", JLabel.RIGHT);
    JLabel lblBianhao = new JLabel("编号:", JLabel.RIGHT);
    JLabel lblShengri = new JLabel("生日:", JLabel.RIGHT);
    JLabel lblJiaxiang = new JLabel("家乡:", JLabel.RIGHT);
    JLabel lblYuwenDefen = new JLabel("语文得分:", JLabel.RIGHT);
    JLabel lblYingyuDefen = new JLabel("英语得分:", JLabel.RIGHT);
    JLabel lblShuxueDefen = new JLabel("数学得分:", JLabel.RIGHT);

    JTextField tbxXingming = new JTextField();
    JTextField tbxBianhao = new JTextField();
    JTextField tbxShengri = new JTextField();
    JTextField tbxJiaxiang = new JTextField();
    JTextField tbxYuwenDefen = new JTextField();
    JTextField tbxYingyuDefen = new JTextField();
    JTextField tbxShuxueDefen = new JTextField();

    JButton btnOK = new JButton("编辑");

    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

    public EditView(MainView mainView, int selectedStudentedId) {
        super(mainView, "编辑学生信息", true);

        // 声明事件处理器
        EditViewHandler editViewHandler = new EditViewHandler(this, mainView, selectedStudentedId);
        // 按钮监听事件
        btnOK.addActionListener(editViewHandler);

        // 回显根据ID查询到的学生信息
        IStudentService studentService = new StudentService();
        StudentDO studentDO = studentService.queryById(selectedStudentedId);

        tbxXingming.setText(studentDO.getXingming());
        tbxBianhao.setText(studentDO.getBianhao());
        tbxShengri.setText(studentDO.getShengri().toString());
        tbxJiaxiang.setText(studentDO.getJiaxiang().toString());
        tbxYuwenDefen.setText(studentDO.getYuwen_defeng().toString());
        tbxYingyuDefen.setText(studentDO.getYingyu_defeng().toString());
        tbxShuxueDefen.setText(studentDO.getShuxue_defeng().toString());

        // 布局
        Container contentPane = getContentPane();

        lblXingming.setPreferredSize(new Dimension(80, 30));
        tbxXingming.setPreferredSize(new Dimension(200, 30));
        jPanel.add(lblXingming);
        jPanel.add(tbxXingming);


        lblBianhao.setPreferredSize(new Dimension(80, 30));
        tbxBianhao.setPreferredSize(new Dimension(200, 30));
        tbxBianhao.setEditable(false);
        jPanel.add(lblBianhao);
        jPanel.add(tbxBianhao);

        lblShengri.setPreferredSize(new Dimension(80, 30));
        tbxShengri.setPreferredSize(new Dimension(200, 30));
        jPanel.add(lblShengri);
        jPanel.add(tbxShengri);

        lblJiaxiang.setPreferredSize(new Dimension(80, 30));
        tbxJiaxiang.setPreferredSize(new Dimension(200, 30));
        jPanel.add(lblJiaxiang);
        jPanel.add(tbxJiaxiang);

        lblYuwenDefen.setPreferredSize(new Dimension(80, 30));
        tbxYuwenDefen.setPreferredSize(new Dimension(200, 30));
        jPanel.add(lblYuwenDefen);
        jPanel.add(tbxYuwenDefen);

        lblYingyuDefen.setPreferredSize(new Dimension(80, 30));
        tbxYingyuDefen.setPreferredSize(new Dimension(200, 30));
        jPanel.add(lblYingyuDefen);
        jPanel.add(tbxYingyuDefen);

        lblShuxueDefen.setPreferredSize(new Dimension(80, 30));
        tbxShuxueDefen.setPreferredSize(new Dimension(200, 30));
        jPanel.add(lblShuxueDefen);
        jPanel.add(tbxShuxueDefen);

        jPanel.add(btnOK);

        contentPane.add(jPanel);

        setSize(350, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
    }

    public StudentDO buildStudentDo() {
        StudentDO studentDO = new StudentDO();
        studentDO.setXingming(tbxXingming.getText().trim());
        studentDO.setBianhao(tbxBianhao.getText().trim());
        studentDO.setJiaxiang(tbxJiaxiang.getText().trim());
        studentDO.setShengri(Date.valueOf(tbxShengri.getText().trim()));
        studentDO.setYuwen_defeng(Double.valueOf(tbxYuwenDefen.getText().trim()));
        studentDO.setShuxue_defeng(Double.valueOf(tbxShuxueDefen.getText().trim()));
        studentDO.setYingyu_defeng(Double.valueOf(tbxYingyuDefen.getText().trim()));
        return studentDO;
    }
}
