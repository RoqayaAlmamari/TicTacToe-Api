package com.example.TicTacToeApi.Model;

public class Board {
    private char[][] board;

    // constructor to create the board
    public Board(int[] board) {
        this.board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            int row = i / 3;
            int col = i % 3;
            this.board[row][col] = (board[i] == 1) ? 'X' : (board[i] == 2) ? 'O' : '-';
        }
    }

    // method to get the current state of the board based on the input symbol
    public String[][] getBoardState(char symbol) {
        String[][] boardState = new String[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boardState[row][col] = (board[row][col] == symbol) ? String.valueOf(symbol) : String.valueOf(board[row][col]);
            }
        }
        return boardState;
    }

    // method to get the board
    public char[][] getBoard() {
        return board;
    }
}
