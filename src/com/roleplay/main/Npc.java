package com.roleplay.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class Npc extends Instance {

	private boolean wander = false;
	private Point point = new Point(MathHandler.random.nextInt(Game.getCurrentScene().WIDTH), MathHandler.random.nextInt(Game.getCurrentScene().HEIGHT));
	public int speed = 1;
	
	protected String leftSprite;
	protected String rightSprite;
	protected String upSprite;
	protected String downSprite;
	protected String name = "";
	
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
	
	public void draw(Graphics g){
		g.setFont(new Font(Font.SERIF,12,12));
		g.setColor(Color.WHITE);
		g.drawString(name, x-4, y-8);
		
		drawDefaultSprite(g);
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
	
	public void talk(List<String> talks){
		
		Game.getCurrentScene().getDialogBox().setMessages(talks);
	}
	

}
