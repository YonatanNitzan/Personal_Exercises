package stuffs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Art_Drawing_Compnent extends JComponent {
	
	public void paintComponent(Graphics g) {
		double x, y, circleD;
		int dotAmount, width, height, R, G, B;
		Arc2D.Double circle;
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		Graphics2D g2 = (Graphics2D) g;
		
		System.out.print("Enter the width of the drawing (Max - 1100): ");
		width = sc.nextInt();
		if(width > 1100)
			width = 1100;
		System.out.print("Enter the hight of the drawing (Max - 680): ");
		height = sc.nextInt();
		if(height > 680)
			height = 680;
		System.out.print("Enter the amount of dots: ");
		dotAmount = sc.nextInt();
		
		g2.drawRect(0, 0, width, height);
		
		while (dotAmount != 0)
		{
			x = rn.nextDouble();
			y = rn.nextDouble();
			circleD = rn.nextDouble() * 11;
			R = (int)(Math.random() * 255) + 1;
			G = (int)(Math.random() * 255) + 1;
			B = (int)(Math.random() * 255) + 1;

			g2.setColor(new Color(R, G, B));
			circle = new Arc2D.Double((x * width), (y * height), (circleD), (circleD), 0, 360, Arc2D.OPEN);
			g2.fill(circle);

			dotAmount--;
		}
	}
}