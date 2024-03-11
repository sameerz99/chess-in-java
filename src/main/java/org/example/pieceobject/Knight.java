package org.example.pieceobject;

import org.example.gamestructure.Piece;
import org.example.gamestructure.PieceColor;
import org.example.gamestructure.Position;

public class Knight extends Piece {
    public Knight(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(newPosition.equals(this.position)){
            return false; // cannot place in same position
        }

        int rowDiff = Math.abs(position.getRow()- newPosition.getRow());
        int colDiff = Math.abs(position.getColumn()- newPosition.getColumn());

        //checking L pattern
        boolean isValidMove = (rowDiff == 2 && colDiff ==1) || (rowDiff ==1 && colDiff ==2);
        if(!isValidMove){
            return false;
        }
        //check for destinationPlace
        Piece destinationPlace = board[newPosition.getRow()][newPosition.getColumn()];
        if(destinationPlace == null){
            return true;
        } else if (destinationPlace.getColor()!=color) {
            return true;
        }
        return false;
    }
}
