package me.meczka.bloxx.graphics;

import java.util.Map;

/**
 * Created by Patryk on 11.06.2017.
 */
public class Bujacz {
    private final int center;
    private double sumaRoznica=0;
    private boolean firstTime=true;
    public Bujacz(int screenwidth)
    {
        center=screenwidth/2-GraphicEngine.halfSizeBlok;
    }
    public void update(Sprite[] sprites)
    {
        double speed = calculateSpeed();
        if(firstTime&&speed!=0)
        {
            sprites[2].setVectored(Sprite.X,true);
            sprites[3].setVectored(Sprite.X,true);
            sprites[2].setVelocityX(speed);
            sprites[3].setVelocityX(speed);
            firstTime=false;
        }
        if(sprites[2].getX()>center+200) {
            sprites[2].setVelocityX(-speed);
            sprites[3].setVelocityX(-speed);
        }
        else if(sprites[2].getX()<center-200)
        {
            sprites[2].setVelocityX(speed);
            sprites[3].setVelocityX(speed);
        }
        /*if(sprites[2].getX()<center)
        {
            sprites[2].setVectored(Sprite.X,true);
            sprites[3].setVectored(Sprite.X,true);
            sprites[2].setVelocityX(-speed);
            sprites[3].setVelocityX(-speed);
        }
        else if(sprites[2].getX()>center)
        {
            sprites[2].setVectored(Sprite.X,true);
            sprites[3].setVectored(Sprite.X,true);
            sprites[2].setVelocityX(speed);
            sprites[3].setVelocityX(speed);
        }*/
    }
    public void setFirstTime(boolean value)
    {
        firstTime=value;
    }
    public double calculateSpeed()
    {
        return sumaRoznica/1000;
    }
    public void addSpeed(double roznica)
    {
        sumaRoznica=sumaRoznica+ Math.abs(roznica);
    }
}
