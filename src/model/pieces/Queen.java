package model.pieces;

import model.Position;
import model.Team;


public class Queen extends Piece{

	public Queen(Position pos, Team team){
		super(pos, team);
	}
	
	public void getPossibleMoves(){
		//This will be overriden
	}
	

}
