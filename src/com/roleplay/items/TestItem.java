package com.roleplay.items;

import com.roleplay.instances.Item;
import com.roleplay.instances.Player;

public class TestItem extends Item {

	public TestItem(int x, int y) {
		super(x, y);
		this.setSprite("images/hamburger.png");
		this.setDisplayName("Hamburger");
	}
	
	public void use(){
		System.out.println("Used burger!");
		Player.inventory.trash(this);
		
	}

}
