package learningNewThings;

import javax.swing.JFrame;

public class TestingGround {
	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setSize(640, 480);
		window.setTitle("Bla Bla");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		drawingComponent DC = new drawingComponent();
		window.add(DC);
	}
}