package com.roleplay.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
    
	public int WIDTH;
	public int HEIGHT;
	
    List<Instance> instances = new ArrayList<Instance>();
    
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void drawGUI(Graphics g);
    
    public void instantiate(Instance instance) {
        instances.add(instance);
    }
    
    public void destroy(Instance instance){
        instances.remove(instance);
    }
    
    public List<Instance> getInstances(){
        return this.instances;
    }
}
