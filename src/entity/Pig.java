package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Pig extends Entity implements IGetImage{

    public Pig(GamePanel gamePanel) {
        super(gamePanel);
        getImage();
    }

    @Override
    public void getImage() {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/pig.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
