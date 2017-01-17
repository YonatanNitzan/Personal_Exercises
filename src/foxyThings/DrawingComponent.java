package foxyThings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

public class DrawingComponent extends JComponent implements ActionListener{
	private static final long serialVersionUID = 1L;

	LinkedList<String> line1 = new LinkedList<String>();
	LinkedList<String> line2 = new LinkedList<String>();
	
	LinkedList<Color> line1C = new LinkedList<Color>();
	LinkedList<Color> line2C = new LinkedList<Color>();
	
	int s = 0;
	
	public void paintComponent(Graphics g)
	{
		line1.add("Sophia,");
		line2.add("my dearest Fox.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("You are my sunshine,");
		line2.add("the one to lighten up my day.");
		line1C.add(new Color(255, 215, 0));
		line2C.add(new Color(255, 215, 0));
		
		line1.add("The fuel of my happiness,");
		line2.add("because all i need to be happy is you.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("You're mine,");
		line2.add("forever and always.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("I'm yours,");
		line2.add("forever and always.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("Two hearts beating as one,");
		line2.add("striving to be closer.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("Two hearts connected by love,");
		line2.add("that connection only growing with time...");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("Every week,");
		line2.add("Every day,");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("Every minute,");
		line2.add("Every Second,");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("My love for you only grows stronger,");
		line2.add("our connection grows tighter.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("Every moment in my life i want to spend with you,");
		line2.add("My love.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("So will you be mine?");
		line2.add("Officially?");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("John, your dork,");
		line2.add("signing out.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));

		
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("serif", Font.BOLD, 20));
		
		SlideBg(g2);
		
		g2.setColor(line1C.get(s));
		g2.drawString(line1.get(s), 300, 300);
		
		g2.setColor(line2C.get(s));
		g2.drawString(line2.get(s), 300, 350);
		
		Timer tm = new Timer(5000, this);
		
		tm.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		s++;
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
			g2.setColor(new Color(255, 205, 0));
			
			Ellipse2D.Double el11 = new Ellipse2D.Double(0, 0, 150, 150);
			g2.fill(el11);
			
			g2.drawLine(75, 75, 150, 200);
			g2.drawLine(75, 75, 100, 200);
			g2.drawLine(75, 75, 200, 200);
		}
	}
	
}