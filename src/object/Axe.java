package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Axe extends SuperObject{

    GamePanel gamePanel;
    public Rectangle solidArea;


    public Axe(GamePanel gamePanel) {
        this.width = 100;
        this.height = 100;

        this.gamePanel = gamePanel;
        getImage();
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.height = 50;
        solidArea.width = 50;
    }

    public void update(){
        x = gamePanel.mouseListener.mouseX;
        y = gamePanel.mouseListener.mouseY;

        solidArea.x = gamePanel.mouseListener.mouseX+10;
        solidArea.y = gamePanel.mouseListener.mouseY+10;
    }

    @Override
    public void getImage() {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/weapon/kapak1.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image,x,y,width,height,null);
        g2.setColor(Color.red);
        g2.draw(solidArea);
    }
}
