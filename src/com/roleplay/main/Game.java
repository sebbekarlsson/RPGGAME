package com.roleplay.main;

import com.roleplay.scenes.WorldScene;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = GAME_WIDTH / 16 * 9;
	public static final int SCALE = 2;

	public static final Dimension FRAMESIZE = new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE);
	public static final Dimension RENDERSIZE = new Dimension(FRAMESIZE.width / 2, FRAMESIZE.height / 2);

	public static final BufferedImage offscreen = new BufferedImage(RENDERSIZE.width,RENDERSIZE.height,BufferedImage.TYPE_INT_RGB);

	private final Thread gameLoop = new Thread(this,"Game Loop");

	public static List<Scene> scenes = new ArrayList<Scene>();
	public static int sceneIndex = 0;

	public static Camera camera = new Camera();

	public static boolean vk_up = false;
	public static boolean vk_down = false;
	public static boolean vk_left = false;
	public static boolean vk_right = false;
	public static boolean vk_i = false;
	public static boolean vk_e = false;
	public static boolean vk_q = false;
	public static boolean vk_r = false;
	public static boolean vk_enter = false;
	public static boolean vk_d = false;


	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}

	public Game(){

		//add all scenes here:
			scenes.add(new WorldScene());


			this.setVisible(true);
			this.setSize(FRAMESIZE);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setTitle("RPG");


			this.addKeyListener(this);
			this.addMouseListener(this);
	}


	public void tick(){
		camera.tick();

		for(int i = 0; i < getCurrentScene().getInstances().size(); i++){
			Instance instance = getCurrentScene().getInstances().get(i);
			instance.tick();
		}


		getCurrentScene().tick();
	}

	public void run() {
		while(true) {
			tick();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				System.out.println("Inturrupted! " + e);
			}
		}

	}

	@Override
	public void paint(Graphics g){

		
		
		Graphics s = offscreen.getGraphics();
		Graphics GUI = offscreen.getGraphics();
		s.clearRect(0, 0, RENDERSIZE.width, RENDERSIZE.height);

		s.translate(camera.x, camera.y);

		for(int i = 0; i < getCurrentScene().getInstances().size(); i++){
			Instance instance = getCurrentScene().getInstances().get(i);
			if(! instance.isOutsideView()){
				instance.draw(s);
			}
		}

		getCurrentScene().draw(s);

		s.translate(-camera.x, -camera.y);
		
		getCurrentScene().drawGUI(GUI);

		g.drawImage(offscreen.getScaledInstance(FRAMESIZE.width, FRAMESIZE.height, 1), 0, 0, this);

		repaint();
	}

	public void start(){
		gameLoop.start();
	}

	public static Scene getCurrentScene(){
		return scenes.get(sceneIndex);
	}

	public void mouseClicked(MouseEvent e) { }

	public void mousePressed(MouseEvent e) { }


	public void mouseReleased(MouseEvent e) { }


	public void mouseEntered(MouseEvent e) { }


	public void mouseExited(MouseEvent e) { }


	public void keyTyped(KeyEvent e) { }


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			vk_up = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			vk_down = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			vk_left = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			vk_right = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_I){
			vk_i = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_E){
			vk_e = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Q){
			vk_q = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_R){
			vk_r = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			vk_enter = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D){
			vk_d = true;
		}



	}


	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_UP){
			vk_up = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			vk_down = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			vk_left = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			vk_right = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_I){
			vk_i = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_E){
			vk_e = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Q){
			vk_q = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_R){
			vk_r = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			vk_enter = false;
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_D){
			vk_d = false;
		}



	}
}
