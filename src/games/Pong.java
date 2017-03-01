package games;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Pong extends JFrame {
	
	private final static int WIDTH = 1100, HEIGHT = 700;
    private Pong_Panel panel;
	
	public Pong() {
		setTitle("Two player Pong!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
		
		panel = new Pong_Panel(this);
		add(panel);
		
		validate();
		pack();
	}
	
	public Pong_Panel getPanel()
	{
		return panel;
	}
	
	public static void main(String[] args)
	{
		new Pong();
	}
}