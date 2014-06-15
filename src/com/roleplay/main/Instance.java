package com.roleplay.main;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Instance {

	public int x, y;
	public Image sprite;

	public Instance(int x, int y){
		this.x = x;
		this.y = y;
	}


	public abstract void tick();

	public void draw(Graphics g) {
		drawDefaultSprite(g);
	}

	public void drawDefaultSprite(Graphics g){
		g.drawImage(sprite, x, y, null);
	}

	public void setSprite(String imagePath){
		Image image = ResLoader.loadImage(imagePath);
		if(this.sprite != image){
			this.sprite =  ResLoader.loadImage(imagePath);
		}
	}
}
