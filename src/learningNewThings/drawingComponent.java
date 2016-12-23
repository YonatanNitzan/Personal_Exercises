package learningNewThings;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.*;

public class drawingComponent extends JComponent{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle rect1 = new Rectangle(5, 5, 100, 200);
		g2.fill(rect1);
		
		Ellipse2D.Double el1 = new Ellipse2D.Double(100, 100, 50, 20);
		g2.draw(el1);
	}
}