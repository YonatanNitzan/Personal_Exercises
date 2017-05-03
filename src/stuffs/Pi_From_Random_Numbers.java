package stuffs;

import javax.swing.JFrame;

public class Pi_From_Random_Numbers {
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(1100, 680);
		window.setTitle("Pi from random numbers");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setFocusable(true);
		window.toBack();
		
		Pi_Drawing_Compnent DC = new Pi_Drawing_Compnent(window);
		window.add(DC);
	}
}