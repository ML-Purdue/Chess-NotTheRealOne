package pieces;


public class King extends Piece{

	public King(int x, int y, int team){
		super(x, y, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	
	public void move(){
		//Also overriden
	}
	
}
