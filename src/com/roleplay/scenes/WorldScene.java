package com.roleplay.scenes;

import java.awt.Graphics;

import com.roleplay.instances.GrassTile;
import com.roleplay.instances.Player;
import com.roleplay.instances.SandTile;
import com.roleplay.instances.Tile;
import com.roleplay.instances.Tree;
import com.roleplay.instances.WaterTile;
import com.roleplay.main.MathHandler;
import com.roleplay.main.Scene;

public class WorldScene extends Scene {

	public static Player player = new Player(120,120);


	public WorldScene() {
		this.WIDTH = 2000;
		this.HEIGHT = 2000;


		for(int i = 0; i < WIDTH/16; i ++){
			for(int ii = 0; ii < HEIGHT/16; ii++){
				Tile tile = new GrassTile(i*16, ii*16);

				//if(MathHandler.random.nextInt(3) == 0){
					//tile = new SandTile(i*16,ii*16);
				///}

				if(MathHandler.random.nextInt(100) == 0){
					tile = new WaterTile(i*16,ii*16);
				}

				


				if(MathHandler.random.nextInt(20) == 0){
					tile = new GrassTile(i*16,ii*16);
				}

				

				this.instantiate(tile);
				
	
			}
		}
		
		

		for(int i = 0; i < WIDTH/16; i ++){
			for(int ii = 0; ii < HEIGHT/16; ii++){
				
					if(MathHandler.random.nextInt(100) == 0){
						this.instantiate(new Tree(i*16,ii*16));
					}
				
	
			}
		}


		this.instantiate(player);
	}

	@Override
	public void tick() { }

	@Override
	public void draw(Graphics g) { }
}
