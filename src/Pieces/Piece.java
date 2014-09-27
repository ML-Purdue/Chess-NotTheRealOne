package Pieces;

public abstract class Piece {
	int xLoc;
	int yLoc;
	int team;
	
	public Piece(int x, int y, int team){
		xLoc = x;
		yLoc = y;
		this.team = team;
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	
	public void move(){
		//Also overriden
	}
}
