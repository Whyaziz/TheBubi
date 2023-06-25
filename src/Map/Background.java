package Map;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Background{

    GamePanel gamePanel;
    BufferedImage map1;

    public Background(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
    }


    public void getImage(){
        try {
            map1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Background.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(map1,0,0,1125,750,null);
    }
}
