package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SI_Player_Lazer {
	
	/* Variable declaration */
	private final int CELLWIDTH = 5, CELLHEIGHT = CELLWIDTH;
	private int x, y;
	private int animationFrame;
	private Boolean exists = false;
	
	public SI_Player_Lazer(int startX, int startY)
	{
		x = startX;
		y = startY - 3 * CELLHEIGHT;
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setColor(Color.BLUE);
		g2.fillRect(x, y, CELLWIDTH, 3 * CELLHEIGHT);
	}
	
	public Boolean exists()
	{
		return exists;
	}
	
	public void toggleExist()
	{
		if(exists)
			exists = false;
		else
			exists = true;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, CELLWIDTH, 3 * CELLHEIGHT);
	}
}
