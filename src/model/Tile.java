package model;
import model.pieces.Piece;


public class Tile {

	private Position pos;
	private Piece piece;
	
	public Tile(Position pos, Piece piece) {
		this.pos = pos;
		this.piece = piece;
		
	}

	public Position getPos() {
		return pos;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
}
