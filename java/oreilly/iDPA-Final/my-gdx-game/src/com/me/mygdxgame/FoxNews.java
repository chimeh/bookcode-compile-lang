package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class FoxNews {
	
	float x;
	float y;
	int health;
	public Texture image;
	RectangleEx FoxRect;
	
	public FoxNews()
	{
		x=300;
		y=20;
		health = 1000;
		Foximage();
		FoxRect = new RectangleEx();
	}



public void Foximage()
{
	image = new Texture(Gdx.files.internal("data/fox_news_logo_a_l.jpg"));
}

}