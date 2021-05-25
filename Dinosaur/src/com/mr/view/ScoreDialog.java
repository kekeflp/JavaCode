
package Dinosaur.src.com.mr.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Dinosaur.src.com.mr.service.ScoreRecorder;

/**
 * 成绩对话框
 * 
 * @author mingrisoft
 *
 */

public class ScoreDialog extends JDialog {

    /**
     * 构造方法
     * 
     * @param frame 父窗体
     */
    public ScoreDialog(JFrame frame) {
        super(frame, true);// 调用父类构造方法,阻塞父窗体
        int scores[] = ScoreRecorder.getScores();
        JPanel scoreP = new JPanel(new GridLayout(4, 1));
        scoreP.setBackground(Color.WHITE);
        JLabel title = new JLabel("得分排行榜", JLabel.CENTER);
        title.setFont(new Font("黑体", Font.BOLD, 20));
        title.setForeground(Color.RED);
        JLabel first = new JLabel("第一名：" + scores[2], JLabel.CENTER);
        JLabel second = new JLabel("第二名：" + scores[1], JLabel.CENTER);
        JLabel third = new JLabel("第三名：" + scores[0], JLabel.CENTER);
        JButton restart = new JButton("重新开始");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        scoreP.add(title);
        scoreP.add(first);
        scoreP.add(second);
        scoreP.add(third);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(scoreP, BorderLayout.CENTER);
        c.add(restart, BorderLayout.SOUTH);

        setTitle("游戏结束");

        int width, height;
        width = height = 200;
        int x = frame.getX() + (frame.getWidth() - width) / 2;
        int y = frame.getY() + (frame.getHeight() - height) / 2;
        setBounds(x, y, width, height);
        setVisible(true);
    }
}
