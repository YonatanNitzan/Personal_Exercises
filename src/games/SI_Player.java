package games;

import java.awt.Color;
import java.awt.Graphics2D;

public class SI_Player {

	/* Variable declaration */
	private final int CELLWIDTH = 5, CELLHEIGHT = CELLWIDTH;
	private int x, y;
	
	public SI_Player(int startX, int startY, int left, int right) {
		x = startX;									//Sets the starting x value
		y = startY;									//Sets the starting y value
	}
	
	void paint(Graphics2D g2)
	{
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
	}
}
