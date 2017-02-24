package games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Pong_Panel extends JPanel implements ActionListener, KeyListener {

	private Pong game;
    private Pong_Ball ball;
    private Pong_Player p1, p2;
    private int score1, score2;
	private String string;
    
	public Pong_Panel(Pong game) {
		setBackground(Color.WHITE);
		this.game = game;
		ball = new Pong_Ball(game);
		p1 = new Pong_Player(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 1, Color.BLUE, 50);
		p2 = new Pong_Player(game, KeyEvent.VK_W, KeyEvent.VK_S, 2, Color.RED, 50);
		Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        game.addKeyListener(this);
        setFocusable(true);
        
        addComponentListener(new ComponentAdapter() 
        {  
                public void componentResized(ComponentEvent evt) {
                    p1.resized();
                    p2.resized();
                }
        });
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        string = game.getPanel().getScore(1) + " : " + game.getPanel().getScore(2);
        g.drawString(string, game.getWidth() / 2 - g.getFontMetrics().stringWidth(string) / 2, 10);
        ball.paint(g);
        p1.paint(g);
        p2.paint(g);
    }

	@Override
	public void keyPressed(KeyEvent e) {
		p1.pressed(e.getKeyCode());
		p2.pressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p1.released(e.getKeyCode());
		p2.released(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//Do nothing
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
        repaint();
	}

	private void update() {
		p1.update();
		p2.update();
		ball.update();
	}
	
	public Pong_Player getPlayer(int playerNo) {
        if (playerNo == 1)
            return p1;
        else
            return p2;
    }

    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
    }

    public int getScore(int playerNo) {
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }
}
