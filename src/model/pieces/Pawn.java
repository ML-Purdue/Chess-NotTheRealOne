package model.pieces;

import model.Position;
import model.Team;


public class Pawn extends Piece{

	public Pawn(Position pos, Team team){
		super(pos, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	

	
}
