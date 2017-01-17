package foxyThings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawingComponent extends JComponent implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Graphics2D g2;
	int s = 0;
	String line1I, line2I;
	Color line1CI, line2CI;
	Timer tm = new Timer(3000, this);
	
	BufferedImage cuteFox, sun, myFox, herBloopy, dorks;
	
	public void paintComponent(Graphics g)
	{
		g2 = (Graphics2D) g;
		g2.setFont(new Font("serif", Font.BOLD, 20));
		
		SlideBg(g2);
		
		try {
			cuteFox = ImageIO.read(getClass().getResourceAsStream("/CuteFox.jpg"));
			sun = ImageIO.read(getClass().getResourceAsStream("/SunDrawing.png"));
			myFox = ImageIO.read(getClass().getResourceAsStream("/FoxIsMine.jpg"));
			herBloopy = ImageIO.read(getClass().getResourceAsStream("/BloppyIsFoxs.jpg"));
			dorks = ImageIO.read(getClass().getResourceAsStream("/Dorks.jpg"));
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
			g2.drawImage(cuteFox, 0, 0, null);
		case 1:
			g2.drawImage(sun, 0, 0,  null);
		case 2:
			
		case 3:
			g2.drawImage(myFox, 0, 0, null);
		case 4:
			g2.drawImage(herBloopy, 0, 0, null);
		case 11:
			g2.drawImage(dorks, 0, 0, null);
		default:
			
		}
	}
	
}