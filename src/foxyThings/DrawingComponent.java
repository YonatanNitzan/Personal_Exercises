package foxyThings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;

public class DrawingComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String L1 = "Fox,";
	String L2 = "My dearest Fox";
	Color color1 = new Color(255, 0, 0);
	Color color2 = new Color(255, 0, 0);
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(new Color(255, 205, 0));
		
		Ellipse2D.Double el1 = new Ellipse2D.Double(0, 0, 150, 150);
		g2.fill(el1);
		
		g2.drawLine(75, 75, 150, 200);
		g2.drawLine(75, 75, 100, 200);
		g2.drawLine(75, 75, 200, 200);
		
		g2.setFont(new Font("serif", Font.BOLD, 20));
		
		g2.setColor(color1);
		g2.drawString(L1, 300, 300);
		
		g2.setColor(color2);
		g2.drawString(L2, 300, 350);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		color1 = new Color(255, 215, 0);
		L1 = "You are my sunshine,";
		color2 = new Color(255, 215, 0);
		L2 = "the one to light up my day";
		repaint();
	}
}