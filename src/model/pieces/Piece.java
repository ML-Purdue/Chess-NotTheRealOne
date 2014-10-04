package model.pieces;

import model.Position;
import model.Team;

public abstract class Piece {
	Position pos;
	Team team;
	
	public Piece(Position pos, Team team){
		this.pos = pos;
		this.team = team;
	}
	
	public abstract void getPossibleMoves();
	
	
	
}
