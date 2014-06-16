package com.roleplay.items;

import com.roleplay.instances.Item;
import com.roleplay.instances.Player;
import com.roleplay.main.Game;

public class Rock extends Item {

	
	boolean goLeft = false;
	boolean goRight = false;
	boolean goDown = false;
	boolean goUp = false;
	
	double speed = 6;
	
	public Rock(int x, int y) {
		super(x, y);
		this.setDisplayName("Rock");
		this.setSprite("images/rock.png");
	}
	
	public void tick(){
		if(goLeft){
			x -= speed;
			if(speed > 0){
				speed -= 0.1;
			}
		}
		if(goRight){
			x += speed;
			if(speed > 0){
				speed -= 0.1;
			}
		}
		if(goDown){
			y += speed;
			if(speed > 0){
				speed -= 0.1;
			}
		}
		if(goUp){
			y -= speed;
			if(speed > 0){
				speed -= 0.1;
			}
		}
		
		if(speed < 0){
			speed = 0;
		}
	}
	
	public void use(){
		x = Player.getX();
		y = Player.getY();
		if(Player.direction.equals("up")){
			goUp = true;
			Game.getCurrentScene().instantiate(this);
		}
		if(Player.direction.equals("down")){
			goDown = true;
			Game.getCurrentScene().instantiate(this);
		}
		if(Player.direction.equals("left")){
			goLeft = true;
			Game.getCurrentScene().instantiate(this);
		}
		if(Player.direction.equals("right")){
			goRight = true;
			Game.getCurrentScene().instantiate(this);
		}
		
		Player.inventory.trash(this);
	}

}
