package com.roleplay.instances;

import com.roleplay.main.Game;
import com.roleplay.main.Instance;

public class Player extends Instance {

	public int speed = 2;
	
    public Player(int x, int y) {
        super(x, y);
        this.setSprite("images/player/player_down.png");
    }
    
    @Override
    public void tick() {
        if(Game.vk_down){
        	y += speed;
        	this.setSprite("images/player/player_down.png");
        }
        
        if(Game.vk_up){
        	y -= speed;
        	this.setSprite("images/player/player_up.png");
        }
        
        if(Game.vk_left){
        	x -= speed;
        	this.setSprite("images/player/player_left.png");
        }
        
        if(Game.vk_right){
        	x += speed;
        	this.setSprite("images/player/player_right.png");
        }
      
    }

}
