package games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SI_Panel extends JPanel implements ActionListener {

	/* Variable declaration */
	private final int CELLWIDTH = 5, CELLHEIGHT = CELLWIDTH;
	private Space_Invaders_Frame frame;
	private int xI, yI;
	private SI_Enemy inv1, inv2;
	private SI_Player player;
	private Timer gameTime;
	
	public SI_Panel(Space_Invaders_Frame frame) {
		setBackground(Color.BLACK);					//Sets a white background
		this.frame = frame;							//Sets the value of the private frame variable
		xI = 10;									//start x
		yI = 50;									//start y
		
		inv1 = new SI_Enemy("Medium", xI, yI); //Creates an Invader
		inv2 = new SI_Enemy("Medium", xI + 100, yI); //Creates an Invader
		player = new SI_Player(220, 400, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		
		gameTime = new Timer(5, this);
		gameTime.start();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;				//Translates the graphics variable to a 2D graphics one
		
		inv1.paint(g2);								//paints the first invader
		inv2.paint(g2);								//paints the second invader
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
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
}