package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

    GamePanel gamePanel;
    public int mouseX;
    public int mouseY;
    public boolean click;

    public MouseListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int button = e.getButton();

        if (gamePanel.gameState == gamePanel.titleScreen || gamePanel.gameState == gamePanel.regulationScreen){
            gamePanel.gameState += 1;
        }

        if (gamePanel.gameState == gamePanel.playerOneScreen){
            if (button == MouseEvent.BUTTON1){
                click = true;

                if (gamePanel.collisionChecker.checkPig(gamePanel.axe) && !gamePanel.collisionChecker.checkDog(gamePanel.axe)){
                    gamePanel.ui.score ++;
                    gamePanel.dog.counter = 79;
                    gamePanel.pig.counter = 79;
                }
                if (gamePanel.collisionChecker.checkDog(gamePanel.axe)){
                    gamePanel.ui.health --;
                    gamePanel.dog.counter = 79;
                    gamePanel.pig.counter = 79;
                }

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int button = e.getButton();

        if (gamePanel.gameState == gamePanel.playerOneScreen){
            if (button == MouseEvent.BUTTON1){
                click = false;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (gamePanel.gameState == gamePanel.playerOneScreen){
            int currentX = e.getX();
            int currentY = e.getY();

            mouseX = currentX;
            mouseY = currentY;
        }
    }
}
