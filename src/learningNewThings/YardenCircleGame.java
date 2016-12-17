package learningNewThings;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JFrame;
import javax.swing.Timer;

public class YardenCircleGame extends JFrame implements ActionListener {
//Variables

    int y, x;
//Double Buffer
    private Image dbImage;
    private Graphics dbg;
    
    
    Timer tm = new Timer(100, this);
    static int direction;

//Window Basics
    public YardenCircleGame() {
        addKeyListener(new AL());
        setTitle("JumperTap");
        setSize(800, 700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x = 400;
        y = 350;

    }
// main

    public static void main(String[] args) {
        new YardenCircleGame();
    }
    //Controls
    public class AL extends KeyAdapter {
    	
        @Override
        public void keyPressed(KeyEvent event) {
            int keyCode = event.getKeyCode();
            if (keyCode == event.VK_A)
            {
                x=x-7;
            }
            if (keyCode == event.VK_D)
            {
                x=x+7;
            }
            if (keyCode == event.VK_W)
            {
            	direction = 1;
            	tm.start();
            }
            }
        }
//Double Buffer

    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        g.fillOval(x, y, 15, 15);
        repaint();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(y == 450)
			direction = -1;
		else if(y == 399)
			direction = 0;
		if(direction > 0)
			y+=5;
		else if(direction < 0)
			y-=5;
		else
			tm.stop();

		repaint();
	}
}