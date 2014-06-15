package com.roleplay.main;

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

import com.roleplay.scenes.WorldScene;

public class Game extends JFrame implements Runnable, KeyListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 2;
	
	public static final Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static final Dimension RENDERSIZE = new Dimension(FRAMESIZE.width / 2, FRAMESIZE.height / 2);
	
	public static final BufferedImage offscreen = new BufferedImage(RENDERSIZE.width,RENDERSIZE.height,BufferedImage.TYPE_INT_RGB);
	
	private final Thread gameLoop = new Thread(this,"Game Loop");
	
	public static List<Scene> scenes = new ArrayList<Scene>();
	public static int sceneIndex = 0;
	
	
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
		
		for(int i = 0; i < getCurrentScene().getInstances().size(); i++){
			Instance instance = getCurrentScene().getInstances().get(i);
			instance.tick();
		}
		
		getCurrentScene().tick();
	}

	public void run() {
		while(true){
			
			tick();
			
			
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void paint(Graphics g){
		
		Graphics s = offscreen.getGraphics();
		s.clearRect(0, 0, RENDERSIZE.width, RENDERSIZE.height);
		
		for(int i = 0; i < getCurrentScene().getInstances().size(); i++){
			Instance instance = getCurrentScene().getInstances().get(i);
			instance.draw(s);
		}
		
		getCurrentScene().draw(s);
		
		g.drawImage(offscreen.getScaledInstance(FRAMESIZE.width, FRAMESIZE.height, 1), 0, 0, this);
		
		repaint();
	}
	
	public void start(){
		gameLoop.start();
	}
	
	
	//returns the current scene in the game.
	public Scene getCurrentScene(){
		return scenes.get(sceneIndex);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
