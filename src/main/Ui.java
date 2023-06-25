package main;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Ui {

    GamePanel gamePanel;
    public int score;
    public int health = 3;

    BufferedImage coin,healthImg;

    public Ui(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
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

}
