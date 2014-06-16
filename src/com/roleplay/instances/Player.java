package com.roleplay.instances;

import com.roleplay.items.TestItem;
import com.roleplay.main.Game;
import com.roleplay.main.Instance;
import com.roleplay.main.Inventory;


public class Player extends Instance {

	public static int xx,yy;
	public int speed = 2;
	public static Inventory inventory = new Inventory(20);
	//press '[ i ]' ingame to open inventory

	public Player(int x, int y) {
		super(x, y);
		this.setSprite("images/player/player_down.png");
		


	}

	@Override
	public void tick() {
		xx = x;
		yy = y;
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


		//we need something better that prevents the player from moving through trees & other obstacles. help?

		//this works but isn't very good.
		for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
			Instance instance = Game.getCurrentScene().getInstances().get(i);
			if(instance instanceof Obstacle || instance instanceof WaterTile){
				if(x >= instance.x -1 && x < instance.x+(instance.sprite.getWidth(null)/2) && y >= instance.y && y <= instance.y+instance.sprite.getHeight(null)){
					if(Game.vk_right){
						x -= speed;

					}
				}

				if(x <= instance.x+instance.sprite.getWidth(null)+1 && x > instance.x+(instance.sprite.getWidth(null)/2) && y >= instance.y && y <= instance.y+instance.sprite.getHeight(null)){
					if(Game.vk_left){
						x += speed;

					}
				}


				if(x >= instance.x && x <= instance.x+instance.sprite.getWidth(null) && y >= instance.y-instance.sprite.getHeight(null)-1 && y <= instance.y+(instance.sprite.getHeight(null)/2)){
					if(Game.vk_down){
						y -= speed;

					}
				}


				if(x >= instance.x && x <= instance.x+instance.sprite.getWidth(null) && y >= instance.y+(instance.sprite.getHeight(null)/2) && y <= instance.y+instance.sprite.getHeight(null)+1){
					if(Game.vk_up){
						y += speed;

					}
				}
			}
			else if(instance instanceof Item){
				Item item = (Item) instance;


				if(instance.x >= x && instance.x <= x+sprite.getWidth(null) && instance.y >= y && instance.y <= y+sprite.getHeight(null)){
					if(Game.vk_enter){
						if(!inventory.isFull()){
							inventory.add(item);
							Game.getCurrentScene().destroy(instance);

						}

						Game.vk_enter = false;
					}
				}




			}
		}


	}
	
	public static int getX(){
		return xx;
	}
	
	public static int getY(){
		return yy;
	}

}
