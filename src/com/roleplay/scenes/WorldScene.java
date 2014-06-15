package com.roleplay.scenes;

import java.awt.Graphics;

import com.roleplay.instances.GrassTile;
import com.roleplay.instances.Player;
import com.roleplay.main.Scene;

public class WorldScene extends Scene {
    
	public static Player player = new Player(120,120);
	
	
    public WorldScene() {
    	this.WIDTH = 2000;
    	this.HEIGHT = 2000;
    	
    	
    	for(int i = 0; i < WIDTH/32; i ++){
    		for(int ii = 0; ii < HEIGHT/32; ii++){
    			this.instantiate(new GrassTile(i*32,ii*32));
    		}
    	}
    	
    	
        this.instantiate(player);
    }
    
    @Override
    public void tick() { }

    @Override
    public void draw(Graphics g) { }
}
