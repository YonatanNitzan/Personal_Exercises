package games;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Space_Invaders_Frame extends JFrame {

	private final int WIDTH = 500, HEIGHT = WIDTH;
	private SI_Panel panel;
	
	public static void main(String[] args) {
		new Space_Invaders_Frame();
	}
	
	public Space_Invaders_Frame()
	{
		/* Frame setup */
		setTitle("Space Invaders");							//Sets the frame's title
		setResizable(false);								//Makes the frame unresizable
		setMinimumSize(new Dimension(WIDTH, HEIGHT));		//Sets the size of the frame
		setVisible(true);									//Makes the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Makes the program terminate when the frame closes
		
		/* Adds panel */
		panel = new SI_Panel(this);
		add(panel);
		
		validate();
		pack();
	}

}
