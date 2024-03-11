package org.example.pieceobject;

import org.example.gamestructure.Piece;
import org.example.gamestructure.PieceColor;
import org.example.gamestructure.Position;

public class Rook extends Piece {

    public Rook(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        //Rooks can move horizontally and vertically any number of sqare
        //They cannot jump over piece
        if (position.getRow() == newPosition.getRow()) {

            int columnStart = Math.min(position.getColumn(), newPosition.getColumn()) + 1;
            int columnEnd = Math.max(position.getColumn(), newPosition.getColumn());
            for (int column = columnStart; column < columnEnd; column++) {
                if (board[position.getRow()][column] != null) {
                    return false;
                }
            }

        } else if (position.getColumn() == newPosition.getColumn()) {
            int rowStart = Math.min(position.getRow(), newPosition.getRow()) + 1;
            int rowEnd = Math.max(position.getRow(), newPosition.getRow());
            for (int row = rowStart; row < rowEnd; row++) {
                if (board[row][position.getColumn()] != null) {
                    return false;
                }
            }
        }else {
            return false; //for other than straight moves
        }
        //check if the destination sqauare has capturing piece
        Piece destinationPlace = board[newPosition.getRow()][newPosition.getColumn()];
        if(destinationPlace==null){
            return true; //the place is empty
        } else if (destinationPlace.getColor()!=color) {
            return true; //capture the piece
        }
        return false;
    }
}
