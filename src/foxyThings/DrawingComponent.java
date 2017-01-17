package foxyThings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;

import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawingComponent extends JComponent implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Graphics2D g2;
	int s = 0;
	String line1I, line2I;
	Color line1CI, line2CI;
	Timer tm = new Timer(3000, this);
	
	BufferedImage sun;
	
	public void paintComponent(Graphics g)
	{
		g2 = (Graphics2D) g;
		g2.setFont(new Font("serif", Font.BOLD, 20));
		
		SlideBg(g2);
		
		try {
			sun = ImageIO.read(getClass().getResourceAsStream("/SunDrawing.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(Main.iterL1.hasNext() && Main.iterL2.hasNext() && Main.iterL1C.hasNext() && Main.iterL2C.hasNext())
		{
			line1I = Main.iterL1.next();
			line1CI = Main.iterL1C.next();
			line2I = Main.iterL2.next();
			line2CI = Main.iterL2C.next();
		}
		else
			tm.stop();
		
		g2.setColor(line1CI);
		g2.drawString(line1I, 200, 300);
		
		g2.setColor(line2CI);
		g2.drawString(line2I, 200, 350);
		
		tm.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		s++;
		repaint();
	}
	
	private void SlideBg(Graphics2D g2)
	{
		switch(s)
		{
		case 0:
			g2.setColor(new Color(255, 205, 0));
			
			Ellipse2D.Double el1 = new Ellipse2D.Double(0, 0, 150, 150);
			g2.fill(el1);
			
			g2.drawLine(75, 75, 150, 200);
			g2.drawLine(75, 75, 100, 200);
			g2.drawLine(75, 75, 200, 200);
		default:
			g2.drawImage(sun, 0, 0, null);
		}
	}
	
}