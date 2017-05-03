package stuffs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Pi_Drawing_Compnent extends JComponent {
	
	private JFrame frame;
	private int dotAmount;
	private double x, y, aboveCount = 0, belowCount = 0, estimatedPi, dotR;
	private Graphics2D g2;
	private Arc2D.Double circle;
	private Timer tm;
	
	public Pi_Drawing_Compnent(JFrame window) {
		frame = window;
	}

	public void paintComponent(Graphics g) {
		Random rn = new Random();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the amount of dots: ");
		dotAmount = sc.nextInt();
		System.out.print("Enter the dots' size: ");
		dotR = sc.nextDouble();
		
		g2 = (Graphics2D) g;
		Rectangle rect = new Rectangle(640, 0, 360, 360);
		g2.draw(rect);
		
		tm = new Timer(1, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dotAmount != 0)
				{
					x = rn.nextDouble();
					y = rn.nextDouble();

					g2 = (Graphics2D) getGraphics();
					
					if ((Math.pow(x, 2) + Math.pow(y, 2)) > 1) {
						aboveCount++;
						g2.setColor(Color.BLUE);
						circle = new Arc2D.Double((x * 360 + 640), (y * 360), dotR, dotR, 0, 360, Arc2D.OPEN);
						g2.fill(circle);
					}
					else {
						belowCount++;
						g2.setColor(Color.RED);
						circle = new Arc2D.Double((x * 360 + 640), (y * 360), dotR, dotR, 0, 360, Arc2D.OPEN);
						g2.fill(circle);
					}
					dotAmount--;
				}
				else
				{
					System.out.println("Dots made!");
					tm.stop();
					
					estimatedPi = belowCount / (belowCount + aboveCount);
					estimatedPi *= 4;

					System.out.println("Estimated Pi: " + estimatedPi);
					System.out.println("Pi: " + Math.PI);
				}
			}
		});
		
		System.out.print("Press \"ENTER\" to start generation...");
		try
		{
            System.in.read(new byte[2]);
        }
		catch (IOException e2)
		{
            e2.printStackTrace();
        }
		
		frame.setAlwaysOnTop(true);
	    frame.toFront();
	    frame.requestFocus();
	    frame.setAlwaysOnTop(false);
	    
		tm.start();
	}
}