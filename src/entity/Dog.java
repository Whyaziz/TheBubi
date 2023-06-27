package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Dog extends Entity implements IGetImage{

    public Dog(GamePanel gamePanel) {
        super(gamePanel);
        getImage();
    }

    @Override
    public void getImage(){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/Dog.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
