package Dinosaur.src.com.mr.view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ��������
 * 
 * @author mingrisoft
 *
 */
public class BackgroundImage {
    public BufferedImage image;
    private BufferedImage image1, image2;
    private Graphics2D g;
    public int x1, x2;
    public static final int SPEED = 4;

    public BackgroundImage() {
        try {
            image1 = ImageIO.read(new File("image/背景1.png"));
            image2 = ImageIO.read(new File("image/背景2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ��ͼƬ���ÿ�800��300�Ĳ�ɫͼƬ
        image = new BufferedImage(800, 300, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();
        x1 = 0;
        x2 = 800;
        g.drawImage(image1, x1, 0, null);
    }

    /**
     * ����
     */
    public void roll() {
        x1 -= SPEED;// ��һ��ͼƬ����
        x2 -= SPEED;// �ڶ���ͼƬ����
        if (x1 <= -800) {// �����һ��ͼƬ�Ƴ���Ļ
            x1 = 800;// �ص���Ļ�Ҳ�
        }
        if (x2 <= -800) {// ����ڶ���ͼƬ�Ƴ���Ļ
            x2 = 800;// �ص���Ļ�Ҳ�
        }
        g.drawImage(image1, x1, 0, null); // ����ͼƬ�л�������ͼƬ
        g.drawImage(image2, x2, 0, null);
    }
}
