package me.meczka.bloxx.graphics;

import java.awt.Image;

public class Sprite {
	private int x, y,velX,velY,rotation;
	Image image;
	public Sprite(int x,int y,int rotation,Image image)
	{
		this.x=x;
		this.y=y;
		velX=0;
		velY=0;
		this.image=image;
		this.rotation=rotation;
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
	
}
