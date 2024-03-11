package org.example.pieceobject;

import org.example.gamestructure.Piece;
import org.example.gamestructure.PieceColor;
import org.example.gamestructure.Position;

public class Bishop extends Piece {
    public Bishop(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow()- newPosition.getRow());
        int colDiff = Math.abs(position.getColumn()- newPosition.getColumn());
        if(rowDiff != colDiff){
            return false; //move is not diagonal
        }
        int rowStep = newPosition.getRow() > position.getRow() ? 1: -1;
        int colStep = newPosition.getColumn() > position.getColumn() ? 1 : -1;
        int steps = rowDiff-1; // number of sqare for obstruction

        //check for pieces along the path
        for(int i=1; i<=steps; i++){
            if(board[position.getRow()+i*rowStep][position.getColumn()+i*colStep]!=null){
                return false;
            }
        }
        //check for capture or move
        Piece destinationPlace = board[newPosition.getRow()][newPosition.getColumn()];
        if(destinationPlace == null){
            return true;
        } else if (destinationPlace.getColor()!=color) {
            return true;

        }
        return false;
    }
}
