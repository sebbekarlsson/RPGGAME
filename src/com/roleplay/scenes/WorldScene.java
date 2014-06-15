package com.roleplay.scenes;

import com.roleplay.instances.Player;
import com.roleplay.main.Scene;
import java.awt.Graphics;

public class WorldScene extends Scene {
    
    public WorldScene() {
        this.instantiate(new Player(120,120));
    }
    
    @Override
    public void tick() { }

    @Override
    public void draw(Graphics g) { }
}
