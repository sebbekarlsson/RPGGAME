package com.roleplay.npcs;

import java.util.ArrayList;
import java.util.List;

import com.roleplay.instances.Player;
import com.roleplay.main.Game;
import com.roleplay.main.MathHandler;
import com.roleplay.main.Npc;

public class Tane extends Npc {

	public Tane(int x, int y) {
		super(x, y);
		this.setSprite("images/npc/Tane/tane_down.png");
		this.upSprite = "images/npc/Tane/tane_up.png";
		this.downSprite = "images/npc/Tane/tane_down.png";
		this.leftSprite = "images/npc/Tane/tane_left.png";
		this.rightSprite = "images/npc/Tane/tane_right.png";
		
		this.name = "Tane";
		
		List<String> talks = new ArrayList<String>();
		talks.add("Jeph: Hi my love, what's on your mind?");
		talks.add("Tane: I am leaving you jeph.");
		talks.add("Jeph: What are you talking about!?");
		
		talk(talks);
	}
	
	
	public void tick(){
		if(Game.getCurrentScene().dialog.isEmpty()){
			x -= speed;
			if(MathHandler.random.nextInt(50) == 0){
				y += speed;
			}
			
			if(MathHandler.random.nextInt(100) == 0){
				y -= speed;
				speed += 1;
			}
			
			
			
			if(x < Player.getX()-300){
				Game.getCurrentScene().destroy(this);
			}
			
			this.setSprite(leftSprite);
			
		}
	}
	
	

}
