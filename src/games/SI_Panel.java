package games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SI_Panel extends JPanel implements ActionListener {

	/* Variable declaration */
	private final int CELLWIDTH = 5, CELLHEIGHT = CELLWIDTH;
	private Space_Invaders_Frame frame;
	private int xI, yI, c = 0;
	private ArrayList<SI_Enemy> invaderList = new ArrayList<SI_Enemy>();
	private SI_Enemy currentI;
	private SI_Player player;
	private Timer gameTime;
	
	public SI_Panel(Space_Invaders_Frame frame) {
		setBackground(Color.BLACK);					//Sets a white background
		this.frame = frame;							//Sets the value of the private frame variable
		xI = 0;									//start x
		yI = 50;									//start y
		
		/* Creates Invaders */
		for(int i = 0; i < 5; i++)
		{
			invaderList.add(new SI_Enemy("Medium", xI + i * 12 * CELLWIDTH, yI));
		}
		player = new SI_Player(220, 400, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP);
		
		inputSetup();
		
		gameTime = new Timer(5, this);				//Sets the game running timer
		gameTime.start();							//Starts the game timer
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;				//Translates the graphics variable to a 2D graphics one
		
		while(c < invaderList.size())
		{
			currentI = invaderList.get(c);
			currentI.paint(g2);
			c++;
		}
		c = 0;
		player.paint(g2);							//paints the player
		
		/* Draws the pixel grid */
		g2.setColor(Color.BLACK);
		for(int i = 0; i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				g2.drawRect(i * CELLWIDTH, j * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	private void inputSetup()
	{
		/* Left pressed */
		AbstractAction left = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.pressed(KeyEvent.VK_LEFT);
			}
		};
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
		this.getActionMap().put("moveLeft", left);
		/* Left release */
		AbstractAction leftOff = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.released(KeyEvent.VK_LEFT);
			}
		};
		this.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "stopMoveLeft");
		this.getActionMap().put("stopMoveLeft", leftOff);
		
		/* Right pressed */
		AbstractAction right = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.pressed(KeyEvent.VK_RIGHT);
			}
		};
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
		this.getActionMap().put("moveRight", right);
		/* Right released */
		AbstractAction rightOff = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.pressed(KeyEvent.VK_RIGHT);
			}
		};
		this.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "stopMoveRight");
		this.getActionMap().put("stopMoveRight", rightOff);
		
		/* Up pressed */
		AbstractAction shoot = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.pressed(KeyEvent.VK_UP);
				}
		};
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "shoot");
		this.getActionMap().put("shoot", shoot);
		/* Up released */
		AbstractAction shootOff = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.pressed(KeyEvent.VK_UP);
				}
		};
		this.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "stopShoot");
		this.getActionMap().put("stopShoot", shootOff);
	}
}