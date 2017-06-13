package me.meczka.bloxx.graphics;


/**
 * Created by Patryk on 10.06.2017.
 */
public class Collisions {
    private boolean isFalling,movingDown;
    private int screenwidth,screenheight;
    private int blocksDown=2;
    public Collisions(int screenwidth,int screenheight)
    {
        this.screenwidth=screenwidth;
        this.screenheight=screenheight;
    }
    public synchronized void check(Sprite[] sprites)
    {
        if(movingDown)
        {
            if(sprites[blocksDown-1].getY()>screenheight-GraphicEngine.BLOKSIZE*2)
            {
                movingDown=false;
                for(int i=2;i<=blocksDown;i++) {
                    sprites[i].setVelocityY(0);
                }
                sprites[blocksDown].setY(screenheight-GraphicEngine.BLOKSIZE*2);
                sprites[blocksDown-1].setY(screenheight-GraphicEngine.BLOKSIZE);
                cloneBlock(sprites,blocksDown-1,2);
                cloneBlock(sprites,blocksDown,3);
                blocksDown=3;
            }

        }
        if(blocksDown==4&&!movingDown)
        {
            moveOneBlockDown(sprites);
        }
        if(sprites[0].getY()>sprites[blocksDown].getY()-GraphicEngine.BLOKSIZE)
        {
            if(sprites[0].getX()>=sprites[blocksDown].getX()&&sprites[0].getX()<=sprites[blocksDown].getX()+GraphicEngine.BLOKSIZE
                    ||sprites[0].getX()+GraphicEngine.BLOKSIZE>=sprites[blocksDown].getX()&&sprites[0].getX()+GraphicEngine.BLOKSIZE<=sprites[blocksDown].getX()+GraphicEngine.BLOKSIZE)
            {
                sprites[0].setVelocityY(0);
                sprites[0].setY(sprites[blocksDown].getY() - GraphicEngine.BLOKSIZE);
                isFalling=false;
                blocksDown++;
                cloneBlock(sprites,0,blocksDown);
            }
            else
            {
                sprites[0].setVelocityY(0);
                isFalling=false;
            }
        }
    }
    public void cloneBlock(Sprite[] sprites,int clonedSpriteIndex,int saveIndex)
    {
        sprites[saveIndex]= new Sprite(sprites[clonedSpriteIndex].getX(),sprites[clonedSpriteIndex].getY(),0,sprites[clonedSpriteIndex].getImage());
    }
    public void moveOneBlockDown(Sprite[] sprites)
    {
        for(int i=2;i<=blocksDown;i++)
        {
            sprites[i].setVectored(Sprite.Y,true);
            sprites[i].setVelocityY(1);
            movingDown=true;
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
