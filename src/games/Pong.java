package games;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Pong extends JFrame {
	
	private final static int WIDTH = 700, HEIGHT = 450;
    private Pong_Panel panel;
	
	public Pong() {
		setTitle("Two player Pong!");
		setResizable(true);
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		pack();
		setVisible(true);
		
		panel = new Pong_Panel(this);
		add(panel);
	}
	
	public static void main(String[] args)
	{
		new Pong();
	}
}