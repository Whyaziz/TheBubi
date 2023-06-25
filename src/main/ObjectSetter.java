package main;

import object.Bush;

public class ObjectSetter {

    GamePanel gamePanel;

    public ObjectSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setBush(){

        gamePanel.bushes[0] = new Bush();
        gamePanel.bushes[0].x = 380;
        gamePanel.bushes[0].y = 220;

        gamePanel.bushes[1] = new Bush();
        gamePanel.bushes[1].x = 600;
        gamePanel.bushes[1].y = 200;

        gamePanel.bushes[2] = new Bush();
        gamePanel.bushes[2].x = 490;
        gamePanel.bushes[2].y = 80;

        gamePanel.bushes[3] = new Bush();
        gamePanel.bushes[3].x = 340;
        gamePanel.bushes[3].y = 420;

        gamePanel.bushes[4] = new Bush();
        gamePanel.bushes[4].x = 600;
        gamePanel.bushes[4].y = 470;

        gamePanel.bushes[5] = new Bush();
        gamePanel.bushes[5].x = 920;
        gamePanel.bushes[5].y = 490;

        gamePanel.bushes[6] = new Bush();
        gamePanel.bushes[6].x = 30;
        gamePanel.bushes[6].y = 390;

    }
}
