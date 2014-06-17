package com.roleplay.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.roleplay.instances.Player;

public class DialogBox {

	private List<String> messages = new ArrayList<String>();
	private int messageIndex = 0;


	public void tick(){
		if(Game.vk_enter){
			nextMessage();
			Game.vk_enter = false;
		}
		
		if(messages.size() > 0){
			Player.canMove = false;
		}else{
			Player.canMove = true;
		}
	}

	public void drawGUI(Graphics g){

		if(messages != null && messages.size() > 0){

			
			
			g.setColor(Color.blue);
			g.fillRect(Game.RENDERSIZE.width/2-150, Game.RENDERSIZE.height/2+100, 264, 100);
			
			g.setColor(Color.BLACK);
			g.drawRect(Game.RENDERSIZE.width/2-150, Game.RENDERSIZE.height/2+100, 264, 100);
			
			g.setFont(new Font(Font.SERIF,16,16));
			g.setColor(Color.WHITE);

			g.drawString(messages.get(messageIndex), Game.RENDERSIZE.width/2-148, Game.RENDERSIZE.height/2+124);
			
			
			
			

		}
	}

	public void nextMessage(){
		if(messageIndex < messages.size()-1){
			messageIndex += 1;
		}else{
			messages.clear();
		}
	}

	public void setMessages(List<String> s){
		this.messages = s;
	}

	public void addMessage(String s){
		this.messages.add(s);
	}

	public void clearMessages(){
		this.messages.clear();
	}

	public void destroyMessages(){
		this.messages = null;
	}
	
	public boolean isEmpty(){
		if(messages.size() < 1){
			return true;
		}
		
		return false;
	}

}
