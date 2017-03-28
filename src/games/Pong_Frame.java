package games;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Pong_Frame extends JFrame {
	
	/* Variable declaration */
	private final static int WIDTH = 1100, HEIGHT = 700;	//Finals for the frame's size
    private Pong_Panel panel;								//Panel variable
	
    public static void main(String[] args)
    {
    	new Pong_Frame();
    }
    
	public Pong_Frame() {
		/* Frame setup */
		setTitle("Two player Pong!");						//Sets the frame's title
		setResizable(false);								//Makes the frame unresizable
		setMinimumSize(new Dimension(WIDTH, HEIGHT));		//Sets the size of the frame
		setVisible(true);									//Makes the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Makes the program terminate when the frame closes
		
		/* Adds panel */
		panel = new Pong_Panel(this);
		add(panel);
		
		validate();
		pack();
	}
	
	/* Gives the panel */
	public Pong_Panel getPanel()
	{
		return panel;
	}
}