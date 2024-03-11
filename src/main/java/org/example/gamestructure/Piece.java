package org.example.gamestructure;

public abstract class Piece {
    protected Position position;
    protected PieceColor color;

    public Piece(PieceColor color, Position position){
        this.color = color;
        this.position = position;
    }
    public Position getPosition(){
        return position;
    }

    public PieceColor getColor() {
        return color;
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public abstract boolean isValidMove(Position newPosition, Piece[][] board);
}
