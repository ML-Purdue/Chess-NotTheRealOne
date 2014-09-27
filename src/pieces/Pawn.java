package pieces;


public class Pawn extends Piece{

	public Pawn(int x, int y, int team){
		super(x, y, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	
	public void move(){
		//Also overriden
	}
	
}
