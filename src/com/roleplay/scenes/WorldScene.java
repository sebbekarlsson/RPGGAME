package com.roleplay.scenes;

import com.roleplay.instances.Player;
import com.roleplay.main.Scene;

public class WorldScene extends Scene {
	
	public WorldScene(){
		this.instantiate(new Player(120,120));
	}

}
