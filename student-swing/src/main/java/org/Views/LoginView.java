package org.Views;

import org.handler.LoginViewHandler;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

/**
 * 登录视图
 *
 * @author LipingFu
 */
public class LoginView extends JFrame {

    JLabel title = new JLabel("java-swing学生成绩管理系统", JLabel.CENTER);
    SpringLayout springLayout = new SpringLayout();
    JPanel jp = new JPanel(springLayout);
    JLabel lblUsername = new JLabel("用户名:");
    JLabel lblPassword = new JLabel("密码:");
    JTextField tbxUsername = new JTextField(20);
    JPasswordField tbxPassword = new JPasswordField(20);
    JButton btnLogin = new JButton("登录");
    JButton btnCancel = new JButton("取消");

    // 系统托盘图标
    SystemTray systemTray;
    TrayIcon trayIcon;

    // 按钮事件
    LoginViewHandler loginViewHandler;

    public LoginView() {
        super("学生成绩管理系统");
        // 把当前对象传过去
        loginViewHandler = new LoginViewHandler(this);
        // 设置字体样式
        title.setFont(new Font("微软雅黑", Font.PLAIN, 40));
        Font font = new Font("宋体", Font.PLAIN, 20);
        lblUsername.setFont(font);
        lblPassword.setFont(font);
        tbxUsername.setFont(font);
        tbxPassword.setFont(font);
        btnLogin.setFont(font);
        btnCancel.setFont(font);

        // 组件放入面板
        jp.add(lblUsername);
        jp.add(lblPassword);
        jp.add(tbxUsername);
        jp.add(tbxPassword);
        jp.add(btnLogin);
        jp.add(btnCancel);

        // 组件/面板,放入容器
        Container container = getContentPane();
        container.add(title, BorderLayout.NORTH);
        container.add(jp, BorderLayout.CENTER);

        // 布局
        layoutCenter();

        // 按钮事件
        btnLogin.addActionListener(loginViewHandler);
        btnCancel.addActionListener(loginViewHandler);
        // 设置登录按钮为默认按钮
        getRootPane().setDefaultButton(btnLogin);

        // 设置窗体ICON
        URL imgUrl = LoginView.class.getClassLoader().getResource("shutlle.png");
        setIconImage(new ImageIcon(imgUrl).getImage());

        // 设置系统托盘图标
        // 先判断系统是否支持托盘
        if (SystemTray.isSupported()) {
            systemTray = SystemTray.getSystemTray();
            trayIcon = new TrayIcon(new ImageIcon(imgUrl).getImage());
            // 设置图片自动缩放,太大了就不显示
            trayIcon.setImageAutoSize(true);
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            // 添加最小化时销毁资源
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowIconified(WindowEvent e) {
                    LoginView.this.dispose();
                }
            });
            // 增加托盘事件监听
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    if (clickCount == 1) {
                        LoginView.this.setExtendedState(JFrame.NORMAL);
                    }
                    LoginView.this.setVisible(true);
                }
            });
        }

        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    private void layoutCenter() {
        SpringLayout.Constraints constraints = springLayout.getConstraints(lblUsername);
        constraints.setX(Spring.constant(150));
        constraints.setY(Spring.constant(50));

        springLayout.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblUsername);
        springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 20, SpringLayout.SOUTH, lblUsername);
        // margin="20 0 0 0"
        springLayout.putConstraint(SpringLayout.WEST, tbxUsername, 20, SpringLayout.EAST, lblUsername);
        springLayout.putConstraint(SpringLayout.NORTH, tbxUsername, 0, SpringLayout.NORTH, lblUsername);

        springLayout.putConstraint(SpringLayout.WEST, tbxPassword, 20, SpringLayout.EAST, lblPassword);
        springLayout.putConstraint(SpringLayout.NORTH, tbxPassword, 0, SpringLayout.NORTH, lblPassword);

        springLayout.putConstraint(SpringLayout.WEST, btnLogin, 0, SpringLayout.EAST, lblPassword);
        springLayout.putConstraint(SpringLayout.NORTH, btnLogin, 40, SpringLayout.NORTH, lblPassword);

        springLayout.putConstraint(SpringLayout.WEST, btnCancel, 40, SpringLayout.EAST, btnLogin);
        springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 40, SpringLayout.NORTH, tbxPassword);
    }

    public static void main(String[] args) {
        new LoginView();
    }

    // 作为属性, 暴露给事件处理器来获取文本信息
    public JTextField getTbxUsername() {
        return tbxUsername;
    }

    public JPasswordField getTbxPassword() {
        return tbxPassword;
    }
}
