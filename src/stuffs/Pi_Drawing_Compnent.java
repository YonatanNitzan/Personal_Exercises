package stuffs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Pi_Drawing_Compnent extends JComponent {
	
	private int c = 0;
	private double x, y, aboveCount = 0, belowCount = 0, estimatedPi;
	private LinkedList<Double> xList = new LinkedList<Double>(), yList = new LinkedList<Double>();
	private Graphics2D g2;
	private Arc2D.Double circle;
	
	public void paintComponent(Graphics g) {
		Random rn = new Random();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int dotAmount;
		double dotR;
		
		System.out.print("Enter the amount of dots: ");
		dotAmount = sc.nextInt();
		System.out.print("Enter the dots' size: ");
		dotR = sc.nextDouble();
		
		g2 = (Graphics2D) g;
		Rectangle rect = new Rectangle(640, 0, 360, 360);
		g2.draw(rect);
		
		while(c <= 30000)
		{
			x = rn.nextDouble();
			y = rn.nextDouble();

			xList.add(x);
			yList.add(y);
			
			c++;
		}
		
		System.out.println("Dots made!");

		xList.iterator();
		yList.iterator();
		
		while (dotAmount != 0)
		{
			x = rn.nextDouble();
			y = rn.nextDouble();

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
		
		estimatedPi = belowCount / (belowCount + aboveCount);
		estimatedPi *= 4;

		System.out.println("Estimated Pi: " + estimatedPi);
		System.out.println("Pi: " + Math.PI);
	}
}