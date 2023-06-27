package sound;

import main.GamePanel;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SoundEffect {

    GamePanel gamePanel;
    Clip axeClip, pigClip, dogClip;
    URL[] urls = new URL[3];

    public SoundEffect(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        urls[0] = getClass().getResource("/sound/axe.wav");
        urls[1] = getClass().getResource("/sound/dog.wav");
        urls[2] = getClass().getResource("/sound/pig.wav");

        getSound();
    }

    public void getSound(){
        try{
            AudioInputStream axe = AudioSystem.getAudioInputStream(urls[0]);
            AudioInputStream dog = AudioSystem.getAudioInputStream(urls[1]);
            AudioInputStream pig = AudioSystem.getAudioInputStream(urls[2]);

            axeClip = AudioSystem.getClip();
            dogClip = AudioSystem.getClip();
            pigClip = AudioSystem.getClip();

            axeClip.open(axe);
            dogClip.open(dog);
            pigClip.open(pig);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void playAxe() {
        axeClip.setFramePosition(0);
        axeClip.start();
    }

    public void playDog() {
        dogClip.setFramePosition(0);
        dogClip.start();
    }

    public void playPig() {
        pigClip.setFramePosition(0);
        pigClip.start();
    }

}
