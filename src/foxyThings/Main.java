package foxyThings;

import java.awt.Color;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JFrame;

public class Main {
	static LinkedList<String> line1 = new LinkedList<String>();
	static LinkedList<String> line2 = new LinkedList<String>();
	
	static ListIterator<String> iterL1;
	static ListIterator<String> iterL2;
	
	static LinkedList<Color> line1C = new LinkedList<Color>();
	static LinkedList<Color> line2C = new LinkedList<Color>();
	
	static ListIterator<Color> iterL1C;
	static ListIterator<Color> iterL2C;
	
	public static void main(String[] args){	
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
		line1C.add(new Color(0, 255, 0));
		line2C.add(new Color(0, 255, 0));
		
		line1.add("You're mine,");
		line2.add("forever and always.");
		line1C.add(new Color(0, 0, 255));
		line2C.add(new Color(0, 0, 255));
		
		line1.add("I'm yours,");
		line2.add("forever and always.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("Two hearts beating as one,");
		line2.add("striving to be closer.");
		line1C.add(new Color(0, 255, 0));
		line2C.add(new Color(0, 255, 0));
		
		line1.add("Two hearts connected by love,");
		line2.add("that connection only growing with time...");
		line1C.add(new Color(0, 0, 255));
		line2C.add(new Color(0, 0, 255));
		
		line1.add("Every week,");
		line2.add("Every day,");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("Every minute,");
		line2.add("Every Second,");
		line1C.add(new Color(0, 255, 0));
		line2C.add(new Color(0, 255, 0));
		
		line1.add("My love for you only grows stronger,");
		line2.add("our connection grows tighter.");
		line1C.add(new Color(0, 0, 255));
		line2C.add(new Color(0, 0, 255));
		
		line1.add("Every moment in my life i want to spend with you,");
		line2.add("My love.");
		line1C.add(new Color(255, 0, 0));
		line2C.add(new Color(255, 0, 0));
		
		line1.add("So will you be mine?");
		line2.add("Officially?");
		line1C.add(new Color(0, 0, 0));
		line2C.add(new Color(0, 0, 0));
		
		line1.add("John, your dork,");
		line2.add("signing out.");
		line1C.add(new Color(10, 150, 103));
		line2C.add(new Color(25, 200, 102));
		
		iterL1 = line1.listIterator();
		iterL2 = line2.listIterator();
		
		iterL1C = line1C.listIterator();
		iterL2C = line2C.listIterator();
		
		JFrame window = new JFrame();
		window.setSize(640, 480);
		window.setTitle("Lovy dovy dub dub!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		DrawingComponent DC = new DrawingComponent();
		window.add(DC);
	}
}