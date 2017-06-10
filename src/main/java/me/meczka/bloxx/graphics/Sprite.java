package me.meczka.bloxx.graphics;

import java.awt.Image;

public class Sprite {
	private int x, y,velX,velY,rotation;
	private boolean isYVectored,isXVectored;
	public static final int X = 0,Y = 1,BOTH = 2;
	Image image;
	public Sprite(int x,int y,int rotation,Image image)
	{
		this(x,y,rotation,image,true,true);
	}
	public Sprite(int x,int y,int rotation,Image image,boolean isXVectored,boolean isYVectored)
	{
		this.x=x;
		this.y=y;
		velX=0;
		velY=0;
		this.image=image;
		this.rotation=rotation;
		this.isXVectored=isXVectored;
		this.isYVectored=isYVectored;
	}
	public void setVelocityX(int velX)
	{
		this.velX=velX;
	}
	public void setVelocityY(int velY)
	{
		this.velY=velY;
	}
	public int getVelocityX()
	{
		return velX;
	}
	public int getVelocityY()
	{
		return velY;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setImage(Image image)
	{
		this.image=image;
	}
	public Image getImage()
	{
		return image;
	}
	public int getRotation()
	{
		return rotation;
	}
	public void setRotation(int rotation)
	{
		this.rotation=rotation;
	}
	public boolean isVectored(int xory)
	{
		switch (xory)
		{
			case X:
				return isXVectored;
			case Y:
				return isYVectored;
			case BOTH:
				return (isYVectored==true&&isXVectored==true);
			default:
				return false;
		}
	}
	public void setVectored(int xory,boolean value)
	{
		switch (xory)
		{
			case X: {
				isXVectored = value;
				break;
			}
			case Y: {
				isYVectored = value;
				break;
			}
			case BOTH:
			{
				isXVectored=value;
				isYVectored=value;
				break;
			}
		}
	}
	
}
