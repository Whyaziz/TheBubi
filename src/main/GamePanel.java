package main;

import Map.Background;
import entity.Dog;
import entity.Pig;
import object.Axe;
import object.Bush;
import sound.SoundEffect;

import javax.swing.*;
import java.awt.*;

public class GamePanel  extends JPanel implements Runnable {

    //ukuran layar dan fps
    public final int screenWidth = 1125;
    public final int screenHeight = 750;
    final int fps = 60;

    Thread gameThread;

    //inisiasi Objek
    ObjectSetter objectSetter = new ObjectSetter(this);
    public MouseListener mouseListener = new MouseListener(this);
    CollisionChecker collisionChecker = new CollisionChecker(this);

    Background background = new Background(this);
    Bush[] bushes = new Bush[7];
    public Ui ui = new Ui(this);
    public Dog dog = new Dog(this);
    public Pig pig = new Pig(this);
    Axe axe = new Axe(this);
    SoundEffect soundEffect = new SoundEffect(this);


    //cursor trasparant
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image cursorImage = toolkit.getImage("ui/blank.png");
    Cursor customCursor = toolkit.createCustomCursor(cursorImage, new java.awt.Point(0, 0), "Custom Cursor");

    //gameState

    int gameState = 1;
    public final int titleScreen = 1;
    public final int regulationScreen = 2;
    public final int giliranOne = 3;
    public final int playerOneScreen = 4;
    public final int transisi = 5;
    public final int giliranTwo = 6;
    public final int playerTwoScreen = 7;
    public final int perbandingan = 8;
    public final int endGame = 9;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.setFocusable(true);
    }

    public void setUpGame(){
        objectSetter.setBush();
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double paintInterval = 1_000_000_000.0 /fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int paintcount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/paintInterval; //membagi waktu yang berlalu dengan 0,016 detik;
            timer += (currentTime-lastTime);
            lastTime = currentTime;

            if(delta >= 1){ //delta akan 1 ketika waktu yang telah berjalan lebih atau sama dengan 0,016 detik

                update(); //update data terbaru
                repaint(); //menampilkan data berdasarkan data terbaru

                delta --; //mereset delta
                paintcount ++; //menghitung setiap perulangan
            }

            if (timer >= 1000000000){ //akan menghitung berapa kali perulangan terjadi selama 1 detik
                System.out.println("FPS : "+paintcount);
                paintcount = 0; //mereset hitungan perulangan
                timer = 0; //mereset timer
            }

        }
    }

    public void update(){

        if (gameState == playerOneScreen){
            pig.update();
            dog.update();
            ui.update();
            axe.update();

            if (ui.timer == 0 || ui.health == 0){
                gameState = transisi;
                ui.pOneScore = ui.score;
                ui.setDefault();
            }
        }
        if (gameState == playerTwoScreen){
            pig.update();
            dog.update();
            ui.update();
            axe.update();

            if (ui.timer == 0 || ui.health == 0){
                gameState = perbandingan;
                ui.pTwoScore = ui.score;
                ui.setDefault();
            }
        }

        if (gameState == playerOneScreen || gameState == playerTwoScreen){
            this.setCursor(customCursor);
        }
        else {
            this.setCursor(Cursor.getDefaultCursor());
        }

        ui.hooverPlay = mouseListener.mouseX >= screenWidth / 2 - 100 &&
                mouseListener.mouseX <= screenWidth / 2 + 100 &&
                mouseListener.mouseY >= screenHeight / 2 &&
                mouseListener.mouseY <= screenHeight / 2 + 100;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (gameState == titleScreen){
            background.drawMulai(g2);
        }
        if (gameState == regulationScreen){
            background.drawRegulation(g2);
        }

        if (gameState == giliranOne ||
                gameState == playerOneScreen ||
                gameState == playerTwoScreen ||
                gameState == transisi ||
                gameState == giliranTwo){
            background.draw(g2);

            pig.draw(g2);
            dog.draw(g2);

            for (Bush bush : bushes) {
                if (!(bush==null)){
                    bush.draw(g2);
                }
            }

            ui.drawScore(g2);
            ui.drawHealth(g2);
            ui.drawTimer(g2);
            ui.drawPlayer(g2);

            axe.draw(g2);
        }
        if (gameState == giliranOne){
            ui.drawButton(g2);
        }
        if (gameState == giliranTwo){
            ui.drawButton(g2);
        }
        if (gameState == transisi){
            ui.drawTransisi(g2);
        }
        if (gameState == perbandingan){
            background.drawPerbandingan(g2);
        }
        if (gameState == endGame){
            background.drawEnd(g2);
        }



        g2.dispose();
    }
}
