package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Entity {

    GamePanel gamePanel;
    BufferedImage image;
    int width = 100;
    int height = 100;

    public Rectangle solidArea;

    public int counter = 0;
    int num = 0;

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;


        this.solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.height = height;
        solidArea.width = width;
    }

    public void update(){
        Random random = new Random();

        counter ++;
        if (counter > 80){
            num = random.nextInt(7)+1;
            counter = 0;
        }
    }

    public void draw(Graphics2D g2){
        if (num == 1){
            g2.drawImage(image,430,170,width,height,null);
            solidArea.x = 430;
            solidArea.y = 170;
        }
        else if (num == 2){
            g2.drawImage(image,650,150,width,height,null);
            solidArea.x = 650;
            solidArea.y = 150;
        }
        else if (num == 3){
            g2.drawImage(image,540,30,width,height,null);
            solidArea.x = 540;
            solidArea.y = 30;
        }
        else if (num == 4){
            g2.drawImage(image,390,370,width,height,null);
            solidArea.x = 390;
            solidArea.y = 370;
        }
        else if (num == 5){
            g2.drawImage(image,650,420,width,height,null);
            solidArea.x = 650;
            solidArea.y = 420;
        }
        else if (num == 6){
            g2.drawImage(image,970,440,width,height,null);
            solidArea.x = 970;
            solidArea.y = 440;
        }
        else if (num == 7){
            g2.drawImage(image,80,350,width,height,null);
            solidArea.x = 80;
            solidArea.y = 350;
        }

    }


}
