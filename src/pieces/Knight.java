package Pieces;


public class Knight extends Piece{

	public Knight(int x, int y, int team){
		super(x, y, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	
	public void move(){
		//Also overriden
	}
	
}
