package games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SI_Panel extends JPanel {

	private final int CELLWIDTH = 5, CELLHEIGHT = CELLWIDTH;
	//private Space_Invaders_Frame frame;
	
	public SI_Panel(Space_Invaders_Frame frame) {
		setBackground(Color.BLACK);					//Sets a white background
		//this.frame = frame;							//Sets the value of the private frame variable
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;				//Translates the graphics variable to a 2D graphics one
		
		drawInvader(g2, 100, 100);		//Creates an Invader at (100;100)
		drawInvader(g2, 200, 100);		//Creates an Invader at (200;100)
		drawPlayer(g2, 150, 200);		//Creates the player ship at (150;200)
	}

	/* Function which draws a space invader in a given color and place */
	private void drawInvader(Graphics2D g2, int x, int y) {
		g2.setColor(Color.WHITE);
		/* Base shape */
		g2.fillRect(x, y, 11 * CELLWIDTH, 5 * CELLHEIGHT);
		/* Outer mouth parts */
		g2.fillRect(x + 3 * CELLWIDTH, y + 5 * CELLHEIGHT, 2 * CELLWIDTH, CELLHEIGHT);
		g2.fillRect(x + 6 * CELLWIDTH, y + 5 * CELLHEIGHT, 2 * CELLWIDTH, CELLHEIGHT);
		/* Ears */
		g2.fillRect(x + 3 * CELLWIDTH, y - CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		g2.fillRect(x + 2 * CELLWIDTH, y - 2 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		g2.fillRect(x + 7 * CELLWIDTH, y - CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		g2.fillRect(x + 8 * CELLWIDTH, y - 2 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		
		g2.setColor(Color.BLACK);
		/* Body rounding */
		g2.fillRect(x, y, CELLWIDTH, CELLHEIGHT * 2);
		g2.fillRect(x + CELLWIDTH, y, CELLWIDTH, CELLHEIGHT);
		g2.fillRect(x + 10 * CELLWIDTH, y, CELLWIDTH, CELLHEIGHT * 2);
		g2.fillRect(x + 9 *CELLWIDTH, y, CELLWIDTH, CELLHEIGHT);
		/* Eyes */
		g2.fillRect(x + 3 * CELLWIDTH, y + CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		g2.fillRect(x + 7 * CELLWIDTH, y + CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		/* "Arm pits" */
		g2.fillRect(x + CELLWIDTH, y + 3 * CELLHEIGHT, CELLWIDTH, 2 * CELLHEIGHT);
		g2.fillRect(x + 9 * CELLWIDTH, y + 3 * CELLHEIGHT, CELLWIDTH, 2 * CELLHEIGHT);
		/* Mouth space */
		g2.fillRect(x + 3 * CELLWIDTH, y + 4 * CELLHEIGHT, 5 * CELLWIDTH, CELLHEIGHT);
		
		System.out.printf("An Invader was drawn at (%d; %d)\n", x, y);
	}
	
	/* Function which draws the player ship in a given place */
	private void drawPlayer(Graphics2D g2, int x, int y) {
		g2.setColor(Color.GREEN);
		/* Base shape */
		g2.fillRect(x, y, 11 * CELLWIDTH, 5 * CELLHEIGHT);
		/* Gun */
		g2.fillRect(x + 4 * CELLWIDTH, y - 2 * CELLHEIGHT, 3 * CELLWIDTH, 2 * CELLHEIGHT);
		g2.fillRect(x + 5 * CELLWIDTH, y - 3 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		
		g2.setColor(Color.BLACK);
		/* Body rounding */
		g2.fillRect(x, y, CELLWIDTH, CELLHEIGHT);
		g2.fillRect(x + 10 * CELLWIDTH, y, CELLWIDTH, CELLHEIGHT);
		
		System.out.printf("The player was drawn at (%d; %d)\n", x, y);
	}
}