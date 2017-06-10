package me.meczka.bloxx.graphics;


/**
 * Created by Patryk on 10.06.2017.
 */
public class Collisions {
    public void check(Sprite[] sprites)
    {
        if(sprites[1].getY()>sprites[0].getY()-100)
        {
            sprites[1].setVelocityY(0);
            sprites[1].setY(sprites[0].getY()-100);
        }
    }
}
