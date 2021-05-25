
package Dinosaur.src.com.mr.view;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import Dinosaur.src.com.mr.service.ScoreRecorder;
import Dinosaur.src.com.mr.service.Sound;

/**
 * ������
 * 
 * @author mingrisoft
 *
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        restart();
        setBounds(340, 150, 821, 260);
        setTitle("奔跑吧!小恐龙!");
        Sound.background();
        ScoreRecorder.init();
        addListener();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * ���¿�ʼ
     */
    public void restart() {
        Container c = getContentPane();// ��ȡ����������
        c.removeAll();// ɾ���������������
        GamePanel panel = new GamePanel();// �����µ���Ϸ���
        c.add(panel);
        addKeyListener(panel);// ���Ӽ����¼�
        c.validate();// ����������֤�������
    }

    /**
     * ���Ӽ���
     */
    private void addListener() {
        addWindowListener(new WindowAdapter() {// ���Ӵ������
            public void windowClosing(WindowEvent e) {// ����ر�ǰ
                ScoreRecorder.saveScore();// ����ȷ�
            }
        });
    }
}
