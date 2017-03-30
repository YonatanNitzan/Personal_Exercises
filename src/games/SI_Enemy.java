package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SI_Enemy implements ActionListener {

	/* Variable declaration */
	private final int CELLWIDTH = 5, CELLHEIGHT = CELLWIDTH;
	private int x, y, invaderFrame;
	private Timer movementTimer;
	
	public SI_Enemy (String type, int startX, int startY)
	{
		x = startX;									//Sets the starting x value
		y = startY;									//Sets the starting y value
		
		movementTimer = new Timer(1000, this);		//Sets a timer of 1 second
		movementTimer.start();						//Starts the timer
	}
	
	
	void paint(Graphics2D g2)
	{
		g2.setColor(Color.WHITE);
		/* Closed frame */
		if(invaderFrame % 2 == 0)
		{
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
		}
		/* Open frame */
		else
		{
			/* Base shape */
			g2.fillRect(x, y, 11 * CELLWIDTH, 5 * CELLHEIGHT);
			/* Outer mouth parts */
			g2.fillRect(x + CELLWIDTH, y + 5 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			g2.fillRect(x + 9 * CELLWIDTH, y + 5 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			/* Ears */
			g2.fillRect(x + 3 * CELLWIDTH, y - CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			g2.fillRect(x + 2 * CELLWIDTH, y - 2 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			g2.fillRect(x + 7 * CELLWIDTH, y - CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			g2.fillRect(x + 8 * CELLWIDTH, y - 2 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			/* Arms */
			g2.fillRect(x, y + CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
		}
		g2.setColor(Color.BLACK);
		/* Closed frame */
		if(invaderFrame % 2 == 0)
		{
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
		}
		/* Open frame */
		else
		{
			/* Body rounding */
			g2.fillRect(x + CELLWIDTH, y, CELLWIDTH, CELLHEIGHT);
			g2.fillRect(x + 9 *CELLWIDTH, y, CELLWIDTH, CELLHEIGHT);
			/* Eyes */
			g2.fillRect(x + 3 * CELLWIDTH, y + CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			g2.fillRect(x + 7 * CELLWIDTH, y + CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			/* "Arm pits" */
			g2.fillRect(x, y + 3 * CELLHEIGHT, CELLWIDTH, 2 * CELLHEIGHT);
			g2.fillRect(x + CELLWIDTH, y + 4 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			g2.fillRect(x + 10 * CELLWIDTH, y + 3 * CELLHEIGHT, CELLWIDTH, 2 * CELLHEIGHT);
			g2.fillRect(x + 9 * CELLWIDTH, y + 4 * CELLHEIGHT, CELLWIDTH, CELLHEIGHT);
			/* Mouth space */
			g2.fillRect(x + 3 * CELLWIDTH, y + 4 * CELLHEIGHT, 5 * CELLWIDTH, CELLHEIGHT);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		invaderFrame++;
		x += CELLWIDTH;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y - 2 * CELLHEIGHT, 11 * CELLWIDTH, 8 * CELLHEIGHT);
	}
}