package com.roleplay.main;

import java.util.ArrayList;
import java.util.List;

import com.roleplay.instances.Item;

public class Inventory {

	private List<Item> items = new ArrayList<Item>();
	public int slots = 8;

	public Inventory(int slots){
		this.slots = slots;
	}


	public List<Item> getItems(){
		return this.items;
	}

	public void add(Item item){
		if(!isFull()){
			this.items.add(item);
		}
	}
	
	public void trash(Item item){
		this.items.remove(item);
	}

	public void clear(){
		this.items = new ArrayList<Item>();
	}

	public boolean isFull(){
		return items.size() >= slots;
	}

}
