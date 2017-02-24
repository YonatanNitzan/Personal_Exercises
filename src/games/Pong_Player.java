package games;

public class Pong_Player {

	private static final int WIDTH = 10, HEIGHT = 60;
	private int up, down, x, y;
	private Pong game;
	
	public Pong_Player(Pong game, int up, int down, int x) {
		this.game = game;
		this.up = up;
		this.down = down;
		this.x = x;
		y = game.getWidth() / 2;
	}

	public void pressed(int key) {
		
	}

	public void released(int key) {
		
	}

}
