package Pieces;


public class Queen extends Piece{

	public Queen(int x, int y, int team){
		super(x, y, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	
	public void move(){
		//Also overriden
	}
	
}
