package com.roleplay.instances;

import com.roleplay.main.Instance;

public class Player extends Instance {

    public Player(int x, int y) {
        super(x, y);
        this.setSprite("images/hamburger.png");
    }
    
        @Override
    public void tick(){
        x += 2;
    }

}
