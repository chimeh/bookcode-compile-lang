package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.mygdxgame.*;

public class Liberals 
{
public Texture image;
public Vector2 position;
int speed;
RectangleEx rect = new RectangleEx();



	public Liberals()
	{	
		int speed = 4;
		position = new Vector2 ();
		liberalimage();
		rect.width = image.getWidth();
		rect.height = image.getHeight();
		updateRectPos();
	}


	public void liberalimage()
	{
		image = new Texture(Gdx.files.internal("data/democratic-donkey.jpg"));
	}
	
	public void updateRectPos()
	{
		rect.x = position.x;
		rect.y = position.y;
	}
	
	public void setPosition(Vector2 v)
	{
		this.position.x = v.x;
		this.position.y = v.y;
		updateRectPos();
	}

}





