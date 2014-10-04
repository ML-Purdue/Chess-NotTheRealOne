package model.pieces;

import model.Position;
import model.Team;


public class Bishop extends Piece{

	
	public Bishop(Position pos, Team team) {
		super(pos, team);
	}

	public void getPossibleMoves(){
		//This will be overriden
	}

	
}
