package com.me.mygdxgame;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class America 
{

	public Texture image;
	public Vector2 position = new Vector2();

	public America() 
	{
		random();
		characterimage();
	}

	// ///////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public void characterimage() 
	{
		Random rand = new Random();
		int randNum = rand.nextInt(1);  //1 here is the number of images available
		
		if(randNum == 0)
		{
			image = new Texture(Gdx.files.internal("data/AMERICA.jpg"));
		}
		else if(randNum == 1)
		{
			//load another image
		}
	}

	public void random() 
	{
		Random num = new Random();
		position.x = num.nextInt(800);
		position.y = num.nextInt(800);

	}

}