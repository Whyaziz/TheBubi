package main;

import object.Axe;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public Boolean checkPig(Axe axe) {
        Boolean touched = false;

        if (axe.solidArea.intersects(gamePanel.pig.solidArea)){
            touched = true;
        }
        return touched;
    }

    public Boolean checkDog(Axe axe){
        Boolean touched = false;

        if (axe.solidArea.intersects(gamePanel.dog.solidArea)){
            touched = true;
        }
        return touched;
    }


}
