package com.roleplay.scenes;

import java.awt.Graphics;
import java.io.IOException;

import com.roleplay.instances.GrassTile;

import com.roleplay.instances.Tile;

import com.roleplay.main.MapLoader;

import com.roleplay.main.Scene;

public class WorldScene extends Scene {

	
	MapLoader maploader = new MapLoader();
	boolean created = false;


	public WorldScene() {
		this.WIDTH = 3000;
		this.HEIGHT = 3000;


		for(int i = 0; i < WIDTH/16; i ++){
			for(int ii = 0; ii < HEIGHT/16; ii++){
				Tile tile = new GrassTile(i*16, ii*16);

				

				this.instantiate(tile);
				
				
				
	
			}
		}
		
		
		
		
	

		/*for(int i = 0; i < WIDTH/16; i ++){
			for(int ii = 0; ii < HEIGHT/16; ii++){
				
					if(MathHandler.random.nextInt(100) == 0){
						this.instantiate(new Tree(i*16,ii*16));
					}
				
	
			}
		}*/


		
	}

	@Override
	public void tick() { 
		if(created == false){
			try {
				maploader.loadMap("images/map.png", 3000, 3000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			created = true;
		}
	}

	@Override
	public void draw(Graphics g) { }
}
