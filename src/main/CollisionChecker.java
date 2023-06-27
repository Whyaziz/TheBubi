package main;

import object.Axe;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public Boolean checkPig(Axe axe) {

        return axe.solidArea.intersects(gamePanel.pig.solidArea);
    }

    public Boolean checkDog(Axe axe){

        return axe.solidArea.intersects(gamePanel.dog.solidArea);
    }


}
