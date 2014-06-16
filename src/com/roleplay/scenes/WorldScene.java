package com.roleplay.scenes;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import com.roleplay.instances.GrassTile;
import com.roleplay.instances.Item;
import com.roleplay.instances.Player;
import com.roleplay.instances.Tile;
import com.roleplay.items.TestItem;
import com.roleplay.main.Game;
import com.roleplay.main.Instance;
import com.roleplay.main.MapLoader;
import com.roleplay.main.MathHandler;
import com.roleplay.main.ResLoader;
import com.roleplay.main.Scene;

public class WorldScene extends Scene {


	MapLoader maploader = new MapLoader();
	boolean created = false;


	public boolean drawInventory = false;
	int slotx = 0;
	int sloty = Game.RENDERSIZE.height/2;
	int markerx = (Game.RENDERSIZE.width/2-16*20/2);
	Item markedItem;


	public WorldScene() {
		this.WIDTH = 3000;
		this.HEIGHT = 3000;


		for(int i = 0; i < WIDTH/16; i ++){
			for(int ii = 0; ii < HEIGHT/16; ii++){
				Tile tile = new GrassTile(i*16, ii*16);



				this.instantiate(tile);




			}
		}






		for(int i = 0; i < WIDTH/16; i ++){
			for(int ii = 0; ii < HEIGHT/16; ii++){

					if(MathHandler.random.nextInt(100) == 0){
						this.instantiate(new TestItem(i*16,ii*16));
					}


			}
		}



	}

	@Override
	public void tick() { 
		if(Player.inventory.getItems().size() > 0){
			if(markerx-(Game.RENDERSIZE.width/2-16*20/2) < Player.inventory.getItems().size()*16){
				markedItem = Player.inventory.getItems().get(((markerx)-(Game.RENDERSIZE.width/2-16*20/2))/16);
			}
		}
		if(created == false){
			try {
				maploader.loadMap("images/map.png", 3000, 3000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			created = true;
		}

		if(Game.vk_i){
			if(drawInventory == false){
				drawInventory = true;
			}else{
				drawInventory = false;
			}

			Game.vk_i = false;
		}

		if(Game.vk_q){
			if(markerx > (Game.RENDERSIZE.width/2-16*20/2)){
				markerx -= 16;
			}
			System.out.println(markerx);
			Game.vk_q = false;
		}

		if(Game.vk_e){
			if(markerx < (464)){
				markerx += 16;
			}

			System.out.println(markerx);
			Game.vk_e = false;
		}

		if(Game.vk_r){
			if(markedItem != null){
				markedItem.use();
				markedItem = null;

				Game.vk_r = false;
			}
		}
	}


	@Override
	public void draw(Graphics g) { }

	@Override
	public void drawGUI(Graphics g) {

		g.setColor(Color.white);
		g.setFont(new Font(Font.SERIF,12,12));

		g.drawImage(ResLoader.loadImage("images/gui/slot.png"), 8, Game.RENDERSIZE.height-23, null);
		g.drawString(Player.inventory.getItems().size() + " / "+ Player.inventory.slots, 32, Game.RENDERSIZE.height-8);
		
		if(Player.inventory.getItems().size() > 0){
			if(markerx-(Game.RENDERSIZE.width/2-16*20/2) < Player.inventory.getItems().size()*16){

				Item markedItem = Player.inventory.getItems().get(((markerx)-(Game.RENDERSIZE.width/2-16*20/2))/16);
				if(markedItem != null){
					g.drawImage(markedItem.sprite,8,Game.RENDERSIZE.height-23,null);
				}
			}
		}
		if(drawInventory == true){
			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(AlphaComposite.SrcOver.derive(0.8f));
			g2.setColor(Color.black);
			g2.fillRect(0, 0, Game.RENDERSIZE.width, Game.RENDERSIZE.height);
			g2.setComposite(AlphaComposite.SrcOver.derive(1f));

			g2.setColor(Color.white);
			g2.setFont(new Font(Font.SERIF,20,20));
			g2.drawString("Inventory", Game.RENDERSIZE.width/2-36, Game.RENDERSIZE.height/2-64);
			g2.setFont(new Font(Font.SERIF,16,16));
			g2.drawString("'E' & 'Q' to scroll", Game.RENDERSIZE.width/2-52, Game.RENDERSIZE.height/2+64);
			for(int i = 0; i < Player.inventory.slots; i ++){
				slotx = i*16;



				g.drawImage(ResLoader.loadImage("images/gui/slot.png"), Game.RENDERSIZE.width/2-16*20/2+slotx, sloty, null);



			}

			for(int ii = 0; ii < Player.inventory.getItems().size(); ii ++){


				Item item = Player.inventory.getItems().get(ii);{
					g.drawImage(item.sprite,  (Game.RENDERSIZE.width/2-16*20/2)+ii*16, sloty, null);


				}
			}


			g.drawImage(ResLoader.loadImage("images/gui/marker.png"), markerx, sloty, null);


		}else{
			g.setColor(Color.white);
			g.setFont(new Font(Font.SERIF,20,20));
			
			for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
				Instance instance = Game.getCurrentScene().getInstances().get(i);
				if(instance instanceof Item){
					if(instance.x >= Player.getX() && instance.x+32 <= Player.getX()+32 && instance.y >= Player.getY() && instance.y <= Player.getY()+32){
						Item item = (Item) instance;
						g.drawString(item.displayName + " - Press enter to pickup", Game.RENDERSIZE.width/2-124, Game.RENDERSIZE.height/2);
					}
				}
			}
			
		}
	}
	
	
}



