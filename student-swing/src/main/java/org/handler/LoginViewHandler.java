package org.handler;

import org.Views.LoginView;
import org.Views.MainView;
import org.entity.ManagerDO;
import org.service.IAdminService;
import org.service.impl.AdminService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 登录事件处理器
 *
 * @author LipingFu
 */
// 继承KeyAdapter, 获取按键行为
// 实现ActionListener接口, 事件接口
public class LoginViewHandler extends KeyAdapter implements ActionListener {
    LoginView loginView;

    public LoginViewHandler(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        switch (text) {
            case "登录":
                login();
                break;
            case "取消":
                // todo 关闭窗口
                break;
        }
    }

    private void login() {
        String username = loginView.getTbxUsername().getText();
        char[] chars = loginView.getTbxPassword().getPassword();
        if (username == null || "".equals(username.trim()) || chars == null) {
            JOptionPane.showMessageDialog(loginView, "用户名或密码不能为空!", "警告", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String pwd = new String(chars);

        // 查DB,判断是否能登录
        IAdminService adminService = new AdminService();
        ManagerDO managerDO = new ManagerDO();
        managerDO.setUsername(username);
        managerDO.setPwd(pwd);
        boolean flag = adminService.validateAdmin(managerDO);

        if (flag) {
            new MainView();
            loginView.dispose();
        } else {
            // 类似form.ShowDialog();功能
            JOptionPane.showMessageDialog(loginView, "用户名或密码错误!", "警告", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 如果按下的为回车键时, 触发点击登录,需要先设置登录按钮为默认按钮
    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            login();
        }
    }
}
