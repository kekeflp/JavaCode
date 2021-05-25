
package Dinosaur.src.com.mr.service;

import java.io.FileNotFoundException;

/*
 * 音效类
 */
public class Sound {
    static final String DIR = "muisc/";
    static final String BACKGROUND = "background.wav";
    static final String JUMP = "jump.wav";
    static final String HIT = "hit.wav";

    public static void jump() {
        play(DIR + JUMP, false);
    }

    public static void hit() {
        play(DIR + HIT, false);
    }

    public static void background() {
        play(DIR + BACKGROUND, true);
    }

    private static void play(String file, boolean circulate) {
        try {
            MusicPlayer player = new MusicPlayer(file, circulate);
            player.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}