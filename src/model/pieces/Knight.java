package model.pieces;

import model.Position;
import model.Team;


public class Knight extends Piece{

	public Knight(Position pos, Team team){
		super(pos, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	

}
