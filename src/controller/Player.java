package controller;
import java.util.ArrayList;

import model.Team;
import model.pieces.Piece;


public class Player {
	private ArrayList<Piece> pieces;
	private Team team;
	
	public Player(ArrayList<Piece> pieces, Team team) {
		this.pieces = pieces;
		this.team = team;
		
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public Team getTeam() {
		return team;
	}
	
}
