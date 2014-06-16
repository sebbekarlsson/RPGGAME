package com.roleplay.npcs;

import com.roleplay.main.Npc;

public class Tane extends Npc {

	public Tane(int x, int y) {
		super(x, y);
		this.setSprite("images/npc/Tane/tane_down.png");
		this.wander();
		this.upSprite = "images/npc/Tane/tane_up.png";
		this.downSprite = "images/npc/Tane/tane_down.png";
		this.leftSprite = "images/npc/Tane/tane_left.png";
		this.rightSprite = "images/npc/Tane/tane_right.png";
	}

}
