package Dinosaur.src.com.mr.service;

import java.awt.Container;
import Dinosaur.src.com.mr.view.GamePanel;
import Dinosaur.src.com.mr.view.MainFrame;
import Dinosaur.src.com.mr.view.ScoreDialog;

/**
 * ˢ��֡�߳�
 * 
 * @author mingrisoft
 *
 */
public class FreshThread extends Thread {
    public static final int FREASH = 20;
    GamePanel p;

    public FreshThread(GamePanel p) {
        this.p = p;
    }

    public void run() {
        while (!p.isFinish()) {
            p.repaint();
            try {
                Thread.sleep(FREASH);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Container c = p.getParent();
        while (!(c instanceof MainFrame)) {
            c = c.getParent();
        }
        MainFrame frame = (MainFrame) c;
        new ScoreDialog(frame);
        frame.restart();
    }
}