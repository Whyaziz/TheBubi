package object;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class SuperObject {

    public BufferedImage image;
    public BufferedImage kapak1,kapak2;
    public int x;
    public int y;

    int width;
    int height;

    public abstract void getImage();

    public void draw(Graphics2D g2){
        g2.drawImage(image,x,y,width,height,null);
    }
}
