package Map;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Background{

    GamePanel gamePanel;
    BufferedImage map1, titleScreen, regulationScreen;

    public Background(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
    }


    public void getImage(){
        try {
            map1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Background.png")));
            titleScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Mulai.png")));
            regulationScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Peraturan.png")));
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
}
