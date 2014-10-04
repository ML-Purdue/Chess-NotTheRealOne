package model.pieces;

import model.Position;
import model.Team;


public class Rook extends Piece{

	public Rook(Position pos, Team team){
		super(pos, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	

	
}
