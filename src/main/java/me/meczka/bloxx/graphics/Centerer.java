package me.meczka.bloxx.graphics;

import javax.sound.midi.SysexMessage;

/**
 * Created by Patryk on 13.06.2017.
 */
public class Centerer{
    private final int screenwidth,center;
    private boolean isMoving;
    public Centerer(int screenwidth)
    {
        this.screenwidth=screenwidth;
        center=screenwidth/2-GraphicEngine.halfSizeBlok;
    }
    public boolean isMoving()
    {
        return isMoving;
    }
    public void centerBloks(Sprite[] sprites)
    {
        double roznica;
        double x = sprites[2].getX();
        if(x>center) {
            sprites[2].setVectored(Sprite.X, true);
            sprites[3].setVectored(Sprite.X, true);
            sprites[2].setVelocityX(-1);
            sprites[3].setVelocityX(-1);
            isMoving = true;
        }
        else if(x<center)
        {
            sprites[2].setVectored(Sprite.X,true);
            sprites[3].setVectored(Sprite.X,true);
            sprites[2].setVelocityX(1);
            sprites[3].setVelocityX(1);
            isMoving=true;
        }
    }
    public void check(Sprite[] sprites)
    {
        if(isMoving&&sprites[2].getVelocityX()==-1&&sprites[2].getX()<=center)
        {
            sprites[2].setVelocityX(0);
            sprites[3].setVelocityX(0);
            sprites[2].setX(center);
            sprites[3].setX(center);
            isMoving=false;
        }
        if(isMoving&&sprites[2].getVelocityX()==1&&sprites[2].getX()>=center)
        {
            sprites[2].setVelocityX(0);
            sprites[3].setVelocityX(0);
            sprites[2].setX(center);
            sprites[3].setX(center);
            isMoving=false;
        }
    }

}
