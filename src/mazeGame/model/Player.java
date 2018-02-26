package mazeGame.model;

public class Player {
	int x;
	int y;
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void movePlayerTo(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
