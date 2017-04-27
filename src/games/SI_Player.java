package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SI_Player {

	/* Variable declaration */
	private final int CELLWIDTH = 5, CELLHEIGHT = CELLWIDTH;
	private int x, y, left, right, shoot;
	private SI_Player_Lazer lazer;
	
	public SI_Player(int startX, int startY, int leftKey, int rightKey, int shootKey) {
		x = startX;									//Sets the starting x value
		y = startY;									//Sets the starting y value
		left = leftKey;								//Sets the left keystroke
		right = rightKey;							//Sets the right keystroke
		shoot = shootKey;							//Sets the shooting keystroke
		
		lazer = new SI_Player_Lazer(0, 0);
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
		
		if(lazer.exists())
			lazer.paint(g2);
	}

	public void pressed(int key) {
		if(key == left)
		{
			x -= CELLWIDTH;
		}
		else if(key == right)
		{
			x += CELLWIDTH;
		}
		else if (key == shoot)
		{
			shoot();
		}
	}
	
	public void released(int key) {
		if(key == left)
		{
			x -= CELLWIDTH;
		}
		else if(key == right)
		{
			x += CELLWIDTH;
		}
		else if (key == shoot)
		{
			shoot();
		}
	}

	private void shoot() {
		lazer = new SI_Player_Lazer(x + 5 * CELLWIDTH, y - 3 * CELLHEIGHT);
		lazer.toggleExist();
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y - 3 * CELLHEIGHT, 11 * CELLWIDTH, 8 * CELLHEIGHT);
	}
}
