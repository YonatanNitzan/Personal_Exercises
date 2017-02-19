package learningNewThings;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Pong extends JFrame implements KeyListener {
	
	private Pong_Drawing_Component PDC;
	
	public Pong() {
		this.PDC = new Pong_Drawing_Component();
		addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	}
	
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Pong frame = new Pong();
                frame.setTitle("Square Move Practice");
                frame.setResizable(false);
                frame.setSize(640, 480);
                frame.setMinimumSize(new Dimension(640, 480));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.PDC);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			PDC.moveRight(1);
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			PDC.moveLeft(1);
		if (e.getKeyCode() == KeyEvent.VK_D)
			PDC.moveRight(2);
		if (e.getKeyCode() == KeyEvent.VK_A)
			PDC.moveLeft(2);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}