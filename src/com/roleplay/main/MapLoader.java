package com.roleplay.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.roleplay.instances.Player;
import com.roleplay.instances.SandTile;
import com.roleplay.instances.Tree;
import com.roleplay.instances.WaterTile;


public class MapLoader {

	public void loadMap(String imagePath,int width,int height) throws IOException{
		Image map = ImageIO.read(new File(imagePath));
		System.out.println(map.getWidth(null));
		
		BufferedImage buffered = toBufferedImage(map);
		
	                
		int w = width/16;
		int h = height/16;
		int[][] pixels = new int[w][h];

		
		//BOTTOM LAYER
		for( int i = 0; i < w; i++ ){
			for( int j = 0; j < h; j++ ){
				pixels[i][j] = buffered.getRGB(i, j);
				Color c = new Color(pixels[i][j],true);
				int b = c.getBlue();
				int g = c.getGreen();
				int r = c.getRed();
				
				
				if(r == 0 && g == 255 && b == 255){
					Game.getCurrentScene().instantiate(new WaterTile(i*16,j*16));
				}
				else if(r == 255 && g == 237 && b == 197){
					Game.getCurrentScene().instantiate(new SandTile(i*16,j*16));
				}
				
				
				
				
			}
		}
		
		
		
		
		//TOP LAYER
		for( int i = 0; i < w; i++ ){
			for( int j = 0; j < h; j++ ){
				pixels[i][j] = buffered.getRGB(i, j);
				Color c = new Color(pixels[i][j],true);
				int b = c.getBlue();
				int g = c.getGreen();
				int r = c.getRed();
				
				
				if(r == 0 && g == 255 && b == 0){
					Game.getCurrentScene().instantiate(new Tree(i*16,j*16));
				}
				else if(r == 0 && g == 0 && b == 255){
					
					Game.getCurrentScene().instantiate(new Player(i*16,j*16));
				}
				
				
				
			}
		}
		
		
		
	}
	
	
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
	


}
