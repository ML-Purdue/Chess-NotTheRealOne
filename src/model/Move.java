package model;


public class Move {

	private Position from;
	private Position to;
	private boolean isAttack;
	
	public Move(Position from, Position to, boolean isAttack) {
		this.from = from;
		this.to = to;
		this.isAttack = isAttack;
	}

	public Position getFrom() {
		return from;
	}

	public Position getTo() {
		return to;
	}

	public boolean isAttack() {
		return isAttack;
	}	
		
}
