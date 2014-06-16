package com.roleplay.main;

import java.awt.Point;

public class Npc extends Instance {

	private boolean wander = false;
	private Point point = new Point(MathHandler.random.nextInt(Game.getCurrentScene().WIDTH), MathHandler.random.nextInt(Game.getCurrentScene().HEIGHT));
	public int speed = 1;
	
	protected String leftSprite;
	protected String rightSprite;
	protected String upSprite;
	protected String downSprite;
	
	public Npc(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if(wander){
			if(x < point.x){
				x+= speed;
				this.setSprite(rightSprite);
			}
			else if(x > point.x){
				x-= speed;
				this.setSprite(leftSprite);
			}
			else if(y < point.y){
				y += speed;
				this.setSprite(downSprite);
			}
			
			else if(y > point.y){
				y -= speed;
				this.setSprite(upSprite);
			}
			
			if(MathHandler.random.nextInt(100) == 0){
				point = new Point(MathHandler.random.nextInt(Game.getCurrentScene().WIDTH), MathHandler.random.nextInt(Game.getCurrentScene().HEIGHT));
			}
			
		}
		
		
		
	}
	
	public void wander(){
		this.wander = true;
	}
	
	public void stopWander(){
		this.wander = false;
	}
	
	public boolean isWandering(){
		return this.wander;
	}
	

}
