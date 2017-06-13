package me.meczka.bloxx.graphics;

import me.meczka.bloxx.core.GameCore;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

/**
 * Created by Patryk on 30.05.2017.
 */


public class GraphicEngine extends GameCore implements MouseListener,MouseMotionListener {


    private Sprite[] sprites;
    private Collisions collisions;
    private final int angle = 90;
    private Image blok, chain;
    private boolean goingUp=false;
    private int circleDiameter;
    //finals
    private final int SPRITES = 5;
    public final static int BLOKSIZE = 100;
    private final String IMAGEPATH="E:\\programimage";
    public final static int halfSizeBlok = 50;

    public static void main(String[] args)
    {
        new GraphicEngine().run();
    }
    public void init()
    {
        super.init();

        Window window = screen.getFullScreenWindow();
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
        sprites = new Sprite[SPRITES];
        circleDiameter=screen.getWidth()/2;
        loadImages();
        loadSprites();
        collisions= new Collisions(screen.getWidth(),screen.getHeight());
        goingUp=true;
    }


    public void loadSprites(){
        sprites[2] = new Sprite(screen.getWidth()/2-blok.getWidth(null), screen.getHeight()-blok.getHeight(null),0, blok);
        sprites[0] = new Sprite((int)((circleDiameter/2*Math.cos(angle*Math.PI/180))+screen.getWidth()/2-halfSizeBlok),
                (int)((circleDiameter/2*Math.sin(angle*Math.PI/180))-screen.getHeight()/4+circleDiameter/2-halfSizeBlok),
                angle, blok,false,false,true);
        int chainSize = circleDiameter;
        loadImagesPhase2(chainSize);

        sprites[1] = new Sprite(screen.getWidth()/2-chain.getWidth(null)/2,
                (chainSize/2-screen.getHeight()/4)-chain.getHeight(null)/2,
                angle,chain,false,false,true);


    }
    public void loadImages()
    {
        blok = loadImage(IMAGEPATH+"\\blok.png");
    }

    public void loadImagesPhase2(int chainSize)
    {
        try {
            chain = Thumbnails.of(new File(IMAGEPATH+"\\chain.png"))
                    .size(chainSize,292)
                    .asBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Image loadImage(String fileName)
    {
        return new ImageIcon(fileName).getImage();
    }
    public Sprite[] getSprites()
    {
        return sprites;
    }

    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e)
    {

    }


    public void mousePressed(MouseEvent e)
    {

    }


    public void mouseReleased(MouseEvent e) {
        StartFalling();

    }

    public synchronized void StartFalling()
    {
        sprites[0].setRotating(false);
        sprites[0].setVectored(Sprite.Y,true);
        sprites[0].setVelocityY(1);
        collisions.setFalling(true);
    }




    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());

       //drawing sprites
        for(int i=0;i<sprites.length;i++)
        {
            if(sprites[i]!=null) {
                if (sprites[i].isRotating()) {
                    AffineTransform backup = g.getTransform();
                    AffineTransform trans = new AffineTransform();
                    trans.rotate(Math.toRadians(sprites[i].getRotation()), sprites[i].getX() + sprites[i].getImage().getWidth(null) / 2, sprites[i].getY() + sprites[i].getImage().getHeight(null) / 2);
                    g.setTransform(trans);
                    g.drawImage(sprites[i].getImage(), (int)sprites[i].getX(), (int)sprites[i].getY(), null);
                    g.setTransform(backup);
                } else {
                    g.drawImage(sprites[i].getImage(), (int)sprites[i].getX(), (int)sprites[i].getY(), null);
                }
            }
        }




        g.setColor(Color.BLACK);

        g.drawOval(screen.getWidth()/2-circleDiameter/2, -screen.getHeight()/4, circleDiameter,circleDiameter);



        //trans.translate(sprites[0].getX(), sprites[0].getY());



        //g.drawOval((int) ((200)*Math.cos(angle *Math.PI/180))+500-5, (int) ((100)*Math.sin(angle *Math.PI/180))+400-5, 10, 10);
        //g.drawImage(blok,0,0,null);
    }
    @Override
    public synchronized void update(long elapsedTime)
    {
        //Aktualizacja Kąta
        if (goingUp) {
            if (sprites[0].getRotation() <= 110) {
                sprites[0].setRotation(sprites[0].getRotation() + 1.5);
                sprites[1].setRotation(sprites[1].getRotation() + 1.5);
            } else {
                goingUp = false;
            }
        } else {
            if (sprites[0].getRotation() >= 70) {
                sprites[0].setRotation(sprites[0].getRotation() - 1.5);
                sprites[1].setRotation(sprites[1].getRotation() - 1.5);
            } else {
                goingUp = true;
            }
    }


        //kolko
        if(!collisions.isFalling()) {
            sprites[0].setX((int) ((circleDiameter / 2 * Math.cos(sprites[0].getRotation() * Math.PI / 180)) + screen.getWidth() / 2 - halfSizeBlok));
            sprites[0].setY((int) ((circleDiameter / 2 * Math.sin(sprites[0].getRotation() * Math.PI / 180)) - screen.getHeight() / 4 + circleDiameter / 2 - halfSizeBlok));
        }


        //Wykrywanie Kolizji
        collisions.check(sprites);


        for(int i=0;i<sprites.length;i++)
        {
            if(sprites[i]!=null) {
                if (sprites[i].isVectored(Sprite.X)) {
                    sprites[i].setX( (sprites[i].getX() + sprites[i].getVelocityX() * elapsedTime));
                }
                if (sprites[i].isVectored(Sprite.Y)) {
                    sprites[i].setY( (sprites[i].getY() + sprites[i].getVelocityY() * elapsedTime));
                }
            }
        }




    }
}


