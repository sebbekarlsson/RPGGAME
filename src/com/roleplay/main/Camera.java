package com.roleplay.main;

import com.roleplay.scenes.WorldScene;

public class Camera {
	
	public int x,	y;
	
	public void tick(){
		x = -WorldScene.player.x+Game.RENDERSIZE.width/2;
		y = -WorldScene.player.y+Game.RENDERSIZE.height/2;
	}

}
