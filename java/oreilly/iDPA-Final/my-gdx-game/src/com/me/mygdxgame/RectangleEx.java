package com.me.mygdxgame;

import com.badlogic.gdx.math.Rectangle;

public class RectangleEx extends Rectangle 
{

	public float getMaxX()
	{
		return this.x + this.width;
	}
	
	public float getMaxY()
	{
		return this.y + this.height;
	}

}
