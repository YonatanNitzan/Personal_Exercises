package stuffs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Snek extends JPanel implements ActionListener {

	private ArrayList<Rectangle> l = new ArrayList<Rectangle>();
	private Timer tm;
	private int x = 0, y = 0;
	
	public static void main(String[] args) {
		new Snek();
	}
	
	public Snek()
	{
		JFrame f = new JFrame();
		
		f.setTitle("Ur mom");
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		l.add(new Rectangle(x, y, 20, 20));
		l.add(new Rectangle(x + 20, y, 20, 20));
		
		f.validate();
		
		f.add(this);
		
		tm = new Timer(1000, this);
		tm.start();
	}
	
	public void paintComponent(Graphics g)
	{	
		
		
		Graphics2D g2 = (Graphics2D) g;
		
		
		
		g2.setColor(Color.GREEN);
		
		for(Rectangle rct : l)
		{
			g2.fill(rct);
			g2.setColor(Color.BLUE);
			System.out.println(l.size());
		}
		
		g2.clearRect(l.get(0).x - 20, l.get(0).y, l.get(0).width, l.get(0).height);
		l.remove(0);
		l.add(new Rectangle(x + 20, y, 20, 20));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		x += 20;
		repaint();
	}
}
