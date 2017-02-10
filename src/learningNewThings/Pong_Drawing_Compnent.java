package learningNewThings;

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Pong_Drawing_Compnent extends JComponent{

	public void paintComponent(Graphics g)
	{
		g.drawLine(0, 0, 100, 150);
	}
}