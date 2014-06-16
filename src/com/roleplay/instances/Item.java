package com.roleplay.instances;

import com.roleplay.main.Instance;

public class Item extends Instance {

	public String displayName = "";
	
	public Item(int x, int y) {
		super(x, y);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void use(){
		
	}
	
	public void setDisplayName(String name){
		this.displayName = name;
	}

}
