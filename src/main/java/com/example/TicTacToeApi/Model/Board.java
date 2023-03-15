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
    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
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

    // method to check if the input symbol has won the game
    public boolean checkWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        // No win condition found
        return false;
    }
}
