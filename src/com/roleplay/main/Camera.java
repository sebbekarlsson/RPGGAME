package com.roleplay.main;

import com.roleplay.instances.Player;


public class Camera {
	
	public int x,	y;
	
	public void tick(){
		
		
		for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
			Instance instance = Game.getCurrentScene().getInstances().get(i);
			if(instance instanceof Player){
				x = -instance.x+Game.RENDERSIZE.width/2-(instance.sprite.getWidth(null)/2);
				y = -instance.y+Game.RENDERSIZE.height/2;
			}
		}
	}

}
