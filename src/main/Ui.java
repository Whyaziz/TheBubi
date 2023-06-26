package main;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Ui {

    GamePanel gamePanel;
    public int score;
    public int health = 4;
    int counter = 0;
    int timer = 30;
    public int pOneScore,pTwoScore;

    BufferedImage coin,healthImg;

    public Ui(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
    }
    public void setDefault(){
        timer = 30;
        score = 0;
        health = 4;
    }

    public void getImage(){
        try {
            coin = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/ui/Coins.png")));
            healthImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/ui/nyawa.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        counter ++;
        if (counter >= 60 && timer > 0){
            timer--;
            counter = 0;
        }
    }

    public void drawScore(Graphics2D g2){
        Font font = new Font("Arial",Font.PLAIN,40);
        g2.setFont(font);
        g2.setColor(Color.white);

        g2.drawString(score +"X",gamePanel.screenWidth-200,72);
        g2.drawImage(coin,gamePanel.screenWidth-120, 20,80,80,null);
    }

    public void drawHealth(Graphics2D g2){
        if (health == 1){
            g2.drawImage(healthImg,40, gamePanel.screenHeight-120,40,40,null);
        }
        if (health == 2){
            g2.drawImage(healthImg,40, gamePanel.screenHeight-120,40,40,null);
            g2.drawImage(healthImg,80, gamePanel.screenHeight-120,40,40,null);
        }
        if (health == 3){
            g2.drawImage(healthImg,40, gamePanel.screenHeight-120,40,40,null);
            g2.drawImage(healthImg,80, gamePanel.screenHeight-120,40,40,null);
            g2.drawImage(healthImg,120, gamePanel.screenHeight-120,40,40,null);
        }
    }

    public void drawTimer(Graphics2D g2){
        g2.drawString(timer+"S", 20, 50);
    }

    public void drawTransisi(Graphics2D g2) {
        g2.drawString("Giliran Selesai",gamePanel.screenWidth/2,gamePanel.screenHeight/2);
    }
    public void drawEnd(Graphics2D g2) {
        g2.drawString("Giliran Selesai",gamePanel.screenWidth/2,gamePanel.screenHeight/2);
    }

}
