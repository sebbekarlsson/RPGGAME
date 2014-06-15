package com.roleplay.main;

import java.awt.Image;
import java.awt.Toolkit;

public class ResLoader {
	
	
	public static Image loadImage(String imagePath){
		return Toolkit.getDefaultToolkit().getImage(imagePath);
	}

}
