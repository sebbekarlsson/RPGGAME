package com.roleplay.items;

import com.roleplay.instances.Item;

public class Rock extends Item {

	public Rock(int x, int y) {
		super(x, y);
		this.setDisplayName("Rock");
		this.setSprite("images/rock.png");
	}

}
