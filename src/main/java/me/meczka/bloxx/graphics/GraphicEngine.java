package me.meczka.bloxx.graphics;

import me.meczka.bloxx.core.GameCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;

/**
 * Created by Patryk on 30.05.2017.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import me.meczka.bloxx.core.GameCore;


public class GraphicEngine extends GameCore implements MouseListener,MouseMotionListener {


    private Sprite[] sprites;
    private int angle = 90;
    private Image blok, slup;
    private boolean goingUp=false;
    private int circleRadius;
    //finals
    private final int SPRITES = 2;
    private final String IMAGEPATH="E:\\programimage";
    private final int halfSizeBlok = 50;

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
        loadImages();
        loadSprites();
        circleRadius=screen.getWidth()/2;
        goingUp=true;
    }


    public void loadSprites()
    {
        sprites[0] = new Sprite(screen.getWidth()/2-blok.getWidth(null), screen.getHeight()-blok.getHeight(null),0, blok);
        sprites[1] = new Sprite((int)((screen.getWidth()/2*Math.cos(angle*Math.PI/180))+screen.getWidth()/2-halfSizeBlok), (int)((screen.getHeight()/2*Math.sin(angle *Math.PI/180))+screen.getHeight()/2-screen.getHeight()/2-halfSizeBlok),angle, blok);
        //	sprites[2] = new Sprite((int)screen.getWidth()/2-slup.getWidth(null)/2,(int)screen.getHeight()/4-slup.getHeight(null)/2,angle,slup);

    }
    public void loadImages()
    {
        blok = loadImage(IMAGEPATH+"\\blok.png");
        slup = loadImage(IMAGEPATH + "\\s�up.png");
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
        // TODO Auto-generated method stub

    }

    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
        for(int i=0;i<sprites.length;i++)
        {
            if(sprites[i].getRotation()!=0)
            {
                AffineTransform backup = g.getTransform();
                AffineTransform trans = new AffineTransform();
                trans.rotate(Math.toRadians(sprites[i].getRotation()), sprites[i].getX()+sprites[i].getImage().getWidth(null)/2,sprites[i].getY()+sprites[i].getImage().getHeight(null)/2);
                g.setTransform(trans);
                g.drawImage(sprites[i].getImage(),sprites[i].getX(),sprites[i].getY(), null);
                g.setTransform(backup);
            }
            else
            {
                g.drawImage(sprites[i].getImage(), sprites[i].getX(),sprites[i].getY(),null);
            }
        }
        g.setColor(Color.BLACK);

        g.drawOval(screen.getWidth()/2-circleRadius/2, -screen.getHeight()/4, circleRadius,circleRadius);



        //trans.translate(sprites[1].getX(), sprites[1].getY());



        //g.drawOval((int) ((200)*Math.cos(angle *Math.PI/180))+500-5, (int) ((100)*Math.sin(angle *Math.PI/180))+400-5, 10, 10);
        //g.drawImage(blok,0,0,null);
    }
    @Override
    public void update(long elapsedTime)
    {
        //Aktualizacja Kąta
        if(goingUp)
        {
            if(sprites[1].getRotation()!=110)
            {
                sprites[1].setRotation(sprites[1].getRotation()+1);
                //sprites[2].setRotation(sprites[1].getRotation());
            }
            else
            {
                goingUp=false;
            }
        }
        else
        {
            if(sprites[1].getRotation()!=70)
            {
                sprites[1].setRotation(sprites[1].getRotation()-1);
            }
            else
            {
                goingUp=true;
            }
        }

        //kolko
        sprites[1].setX((int)((circleRadius/2*Math.cos(sprites[1].getRotation()*Math.PI/180))+screen.getWidth()/2-halfSizeBlok));
        sprites[1].setY((int)((circleRadius/2*Math.sin(sprites[1].getRotation()*Math.PI/180))-screen.getHeight()/4+circleRadius/2-halfSizeBlok));


    }
}


