package stuffs;

import javax.swing.JFrame;

public class Random_Art {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(1100, 680);
		window.setTitle("Randomly generated art!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		Art_Drawing_Compnent DC = new Art_Drawing_Compnent();
		window.add(DC);
	}

}
