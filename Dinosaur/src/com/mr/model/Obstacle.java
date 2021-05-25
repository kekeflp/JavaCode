package Dinosaur.src.com.mr.model;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Dinosaur.src.com.mr.view.BackgroundImage;

/*
障碍类
*/
public class Obstacle {
    public int x, y;
    public BufferedImage image;
    BufferedImage stone;
    BufferedImage cacti;
    int speed;

    public Obstacle() {
        try {
            stone = ImageIO.read(new File("image/石头.png"));
            cacti = ImageIO.read(new File("image/仙人掌.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random r = new Random();
        if (r.nextInt(2) == 0) {
            image = cacti;
        } else {
            image = stone;
        }
        x = 800;
        y = 200 - image.getHeight();
        speed = BackgroundImage.SPEED;
    }

    public void move() {
        x -= speed;
    }

    public Rectangle getBounds() {
        if (image == cacti) {
            return new Rectangle(x + 7, y, 15, image.getHeight());
        }
        return new Rectangle(x + 5, y + 4, 23, 21);
    }

    public boolean isLive() {
        if (x <= -image.getWidth()) {
            return false;
        }
        return true;
    }
}
