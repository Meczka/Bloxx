package me.meczka.bloxx.graphics;


/**
 * Created by Patryk on 10.06.2017.
 */
public class Collisions {
    private boolean isFalling;
    private int screenwidth,screenheight,circleDiameter;
    public Collisions(int screenwidth,int screenheight,int circleDiameter)
    {
        this.screenwidth=screenwidth;
        this.screenheight=screenheight;
    }
    public void check(Sprite[] sprites)
    {
        if(sprites[1].getY()>sprites[0].getY()-GraphicEngine.BLOKSIZE)
        {
            if(sprites[1].getX()>sprites[0].getX()&&sprites[0].getX()+GraphicEngine.BLOKSIZE>sprites[1].getX())
            {
                sprites[1].setVelocityY(0);
                sprites[1].setY(sprites[0].getY() - GraphicEngine.BLOKSIZE);
                isFalling=false;
            }
            else
            {
                isFalling=false;
            }
        }

    }
    public void setFalling(boolean value)
    {
        isFalling=value;
    }
    public boolean isFalling()
    {
        return isFalling;
    }
}
