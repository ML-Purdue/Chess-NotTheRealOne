package pieces;


public class Rook extends Piece{

	public Rook(int x, int y, int team){
		super(x, y, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	
	public void move(){
		//Also overriden
	}
	
}
