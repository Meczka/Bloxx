package me.meczka.bloxx.graphics;

import java.awt.Image;

public class Sprite {
	private double x, y,velX,velY,rotation;
	private boolean isYVectored,isXVectored,isRotating;
	public static final int X = 0,Y = 1,BOTH = 2;
	Image image;
	public Sprite(double x,double y,double rotation,Image image)
	{
		this(x,y,rotation,image,true,true,false);
	}
	public Sprite(double x,double y,double rotation,Image image,boolean isXVectored,boolean isYVectored,boolean isRotating)
	{
		this.x=x;
		this.y=y;
		velX=0;
		velY=0;
		this.image=image;
		this.rotation=rotation;
		this.isXVectored=isXVectored;
		this.isYVectored=isYVectored;
		this.isRotating=isRotating;
	}
	public void setVelocityX(double velX)
	{
		this.velX=velX;
	}
	public void setVelocityY(double velY)
	{
		this.velY=velY;
	}
	public double getVelocityX()
	{
		return velX;
	}
	public double getVelocityY()
	{
		return velY;
	}
	public void setX(double x)
	{
		this.x=x;
	}
	public void setY(double y)
	{
		this.y=y;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
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
	public double getRotation()
	{
		return rotation;
	}
	public void setRotation(double rotation)
	{
		this.rotation=rotation;
	}
	public boolean isRotating(){
		return isRotating;
	}
	public void setRotating(boolean value){
		this.isRotating=value;
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
