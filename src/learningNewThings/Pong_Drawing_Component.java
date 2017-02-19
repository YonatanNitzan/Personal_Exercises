package learningNewThings;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Pong_Drawing_Component extends JComponent {

	private int xP1 = 220;
	private int xP2 = 220;
	
	public void paintComponent(Graphics g)
	{   
        super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 640, 480);
		
		g.setColor(Color.BLUE);
		g.fillRect(xP1, 340, 100, 25);
		
		g.setColor(Color.RED);
		g.fillRect(xP2, 100, 100, 25);
	}
	
	public void moveRight(int p)
	{
		if(p == 1)
		{
			if(xP1 > 640)
				xP1 = -90;
			else
				xP1 += 5;
		}
		else
		{
			if(xP2 > 640)
				xP2 = -90;
			else
				xP2 += 5;
		}
			
		repaint();
	}
	
	public void moveLeft(int p)
	{
		if(p == 1)
		{
			if(xP1 < -90)
				xP1 = 630;
			else
				xP1 -= 5;
		}
		else
		{
			if(xP2 < -90)
				xP2 = 630;
			else
				xP2 -= 5;
		}
			
		repaint();
	}
}