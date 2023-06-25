package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Bush extends SuperObject{

    public Bush() {
        getImage();

        this.width = 140;
        this.height = 145;
    }

    @Override
    public void getImage() {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/bush.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
