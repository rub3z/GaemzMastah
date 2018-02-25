package mazeGame.model;

public class Cell {
	private double x,y;
	private boolean north, west, east ,south;
	public Cell() {
		x=0;
		y=0;
		north=false;
		west=false;
		east=false;
		south=false;
	}
	public Cell(int x, int y) {
		this.x=x;
		this.y=y;
		north=false;
		west=false;
		east=false;
		south=false;
	}
	public void setSide(boolean walled, Direction direction) {
		switch (direction) {
			case North:
				this.north=walled;
			case East:
				this.east=walled;
			case West:
				this.west=walled;
			case South:
				this.south=walled;
		}
	}
}
