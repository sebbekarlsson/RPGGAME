package com.roleplay.items;

import com.roleplay.instances.Item;

public class Mushroom extends Item {

	public Mushroom(int x, int y) {
		super(x, y);
		this.setSprite("images/mushroom.png");
		this.setDisplayName("Mushroom");
	}

}
