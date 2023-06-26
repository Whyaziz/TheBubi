package Map;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Background{

    GamePanel gamePanel;
    BufferedImage map1, titleScreen, regulationScreen,perbandingan,oneWin,twoWin,draw;

    public Background(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
    }


    public void getImage(){
        try {
            map1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Background.png")));
            titleScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Mulai.png")));
            regulationScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Peraturan.png")));
            perbandingan = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/perbandingan.png")));
            oneWin = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Player1Wins.png")));
            twoWin = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Player2Wins.png")));
            draw = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/PlayerDraw.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(map1,0,0,gamePanel.screenWidth, gamePanel.screenHeight, null);
    }
    public void drawMulai(Graphics2D g2){g2.drawImage(titleScreen,0,0,gamePanel.screenWidth, gamePanel.screenHeight, null);}
    public void drawRegulation(Graphics2D g2){g2.drawImage(regulationScreen,0,0,gamePanel.screenWidth, gamePanel.screenHeight, null);}
    public void drawPerbandingan(Graphics2D g2){
        Font font = new Font("Arial",Font.PLAIN,60);
        g2.setFont(font);
        g2.setColor(Color.white);

        g2.drawImage(perbandingan,0,0,gamePanel.screenWidth, gamePanel.screenHeight, null);

        g2.drawString(gamePanel.ui.pOneScore+"X", gamePanel.screenWidth/2 + 260,gamePanel.screenHeight/2-gamePanel.screenHeight/11);
        g2.drawString(gamePanel.ui.pTwoScore+"X", gamePanel.screenWidth/2 + 260,gamePanel.screenHeight/2+gamePanel.screenHeight/4);
    }
    public void drawEnd(Graphics2D g2){
        if (gamePanel.ui.pOneScore > gamePanel.ui.pTwoScore){
            g2.drawImage(oneWin,0,0,gamePanel.screenWidth, gamePanel.screenHeight, null);
        }
        if (gamePanel.ui.pOneScore < gamePanel.ui.pTwoScore){
            g2.drawImage(twoWin,0,0,gamePanel.screenWidth, gamePanel.screenHeight, null);
        }
        if (gamePanel.ui.pOneScore == gamePanel.ui.pTwoScore){
            g2.drawImage(draw,0,0,gamePanel.screenWidth, gamePanel.screenHeight, null);
        }
    }
}
