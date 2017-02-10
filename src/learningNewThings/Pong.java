package learningNewThings;

import javax.swing.JFrame;

public class Pong {
	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setSize(640, 480);
		window.setTitle("Test Test");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		Pong_Drawing_Compnent DC = new Pong_Drawing_Compnent();
		window.add(DC);
	}
}