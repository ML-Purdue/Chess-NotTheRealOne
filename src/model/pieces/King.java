package model.pieces;

import model.Position;
import model.Team;


public class King extends Piece{

	public King(Position pos, Team team){
		super(pos, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	

	
}
