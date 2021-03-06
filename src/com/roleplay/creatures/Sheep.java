package com.roleplay.creatures;

import java.awt.Point;

import com.roleplay.items.Meat;
import com.roleplay.items.Rock;
import com.roleplay.main.Game;
import com.roleplay.main.Instance;
import com.roleplay.main.MathHandler;

public class Sheep extends Instance {

	String leftSprite = "images/sheep/sheep_left.png";
	String rightSprite = "images/sheep/sheep_right.png";
	String upSprite = "images/sheep/sheep_up.png";
	String downSprite = "images/sheep/sheep_down.png";
	Point point; 
	int speed = 1;

	public static Rock rock;

	boolean created = false;

	public Sheep(int x, int y) {
		super(x, y);
		this.setSprite("images/sheep/sheep_down.png");


	}

	@Override
	public void tick() {





		if(created == false){
			point = new Point(MathHandler.random.nextInt(Game.getCurrentScene().WIDTH),MathHandler.random.nextInt(Game.getCurrentScene().HEIGHT));
			created = true;
		}

		if(x < point.x){
			x+=speed;
			this.setSprite(rightSprite);
		}
		else if(x > point.x){
			x-=speed;
			this.setSprite(leftSprite);
		}
		else if(y > point.y){
			y-= speed;
			this.setSprite(upSprite);
		}
		else if(y < point.y){
			y+= speed;
			this.setSprite(downSprite);
		}

		if(MathHandler.random.nextInt(200) == 0){
			point = new Point(MathHandler.random.nextInt(Game.getCurrentScene().WIDTH),MathHandler.random.nextInt(Game.getCurrentScene().HEIGHT));

		}


		if(rock != null){
			
			if(rock.x >= x && rock.x <= x+sprite.getWidth(null) && rock.y >= y && rock.y <= y+sprite.getHeight(null)){


				if(rock.speed > 0){
					Game.getCurrentScene().instantiate(new Meat(x,y));
					Game.getCurrentScene().destroy(this);

				}
			}

		}


	}}


