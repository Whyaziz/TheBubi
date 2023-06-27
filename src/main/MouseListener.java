package main;

import java.awt.*;
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

        if (
                gamePanel.gameState == gamePanel.titleScreen ||
                gamePanel.gameState == gamePanel.regulationScreen ||
                gamePanel.gameState == gamePanel.transisi ||
                gamePanel.gameState == gamePanel.perbandingan ||
                gamePanel.gameState == gamePanel.endGame ||
                (gamePanel.gameState == gamePanel.giliranOne && gamePanel.ui.hooverPlay) ||
                (gamePanel.gameState == gamePanel.giliranTwo && gamePanel.ui.hooverPlay)
        ){
            gamePanel.gameState += 1;
            if (gamePanel.gameState > 9){
                gamePanel.gameState = gamePanel.titleScreen;
            }
        }

        if (gamePanel.gameState == gamePanel.playerOneScreen || gamePanel.gameState == gamePanel.playerTwoScreen){
            if (button == MouseEvent.BUTTON1){
                click = true;
                gamePanel.soundEffect.playAxe();

                if (gamePanel.collisionChecker.checkPig(gamePanel.axe) && !gamePanel.collisionChecker.checkDog(gamePanel.axe)){
                    gamePanel.ui.score ++;
                    gamePanel.soundEffect.playPig();
                    gamePanel.dog.counter = 79;
                    gamePanel.pig.counter = 79;
                }
                if (gamePanel.collisionChecker.checkDog(gamePanel.axe)){
                    gamePanel.ui.health --;
                    gamePanel.soundEffect.playDog();
                    gamePanel.dog.counter = 79;
                    gamePanel.pig.counter = 79;
                }

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int button = e.getButton();

        if (gamePanel.gameState == gamePanel.playerOneScreen || gamePanel.gameState == gamePanel.playerTwoScreen){
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
        if (
                gamePanel.gameState == gamePanel.playerOneScreen ||
                gamePanel.gameState == gamePanel.playerTwoScreen ||
                gamePanel.gameState == gamePanel.giliranOne ||
                gamePanel.gameState == gamePanel.giliranTwo)
        {
            int currentX = e.getX();
            int currentY = e.getY();

            mouseX = currentX;
            mouseY = currentY;
        }
    }
}
