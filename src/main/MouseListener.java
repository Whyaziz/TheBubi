package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

    GamePanel gamePanel;
    public int mouseX;
    public int mouseY;
    public boolean click = false;

    public MouseListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() > -1 && e.getY() > -1){
            click = true;
            if (gamePanel.collisionChecker.checkPig(gamePanel.axe)){
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

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX() > -1 && e.getY() > -1){
            click = false;
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
        int currentX = e.getX();
        int currentY = e.getY();

        if (mouseX != 0 && mouseY != 0) {
            int deltaX = currentX - mouseX;
            int deltaY = currentY - mouseY;
        }

        mouseX = currentX;
        mouseY = currentY;
    }
}
