package com.example.TicTacToeApi.Model;

public class Board {
    private int[][] board;
    private String currentPlayer;

    public Board(int[] boardArr) {
        // Initialize the board array
        this.board = new int[3][3];
        for (int i = 0; i < boardArr.length; i++) {
            int row = i / 3;
            int col = i % 3;
            this.board[row][col] = boardArr[i];
        }

        // Initialize the current player symbol
        this.currentPlayer = "X";
    }

    public int[][] getBoard() {
        return this.board;
    }

    public String getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(String symbol) {
        this.currentPlayer = symbol;
    }

    public boolean makeMove(int row, int col) {
        if (this.board[row][col] != 0) {
            return false;
        } else {
            int symbol = this.currentPlayer.equals("X") ? 1 : 2;
            this.board[row][col] = symbol;
            this.currentPlayer = this.currentPlayer.equals("X") ? "O" : "X";
            return true;
        }
    }

    public boolean isGameOver() {
        return getWinner() != 0 || isBoardFull();
    }

    public boolean isBoardFull() {
        for (int[] row : this.board) {
            for (int cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (this.board[i][0] != 0 && this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2]) {
                return this.board[i][0];
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (this.board[0][i] != 0 && this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i]) {
                return this.board[0][i];
            }
        }

        // Check diagonals
        if (this.board[0][0] != 0 && this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) {
            return this.board[0][0];
        }
        if (this.board[0][2] != 0 && this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]) {
            return this.board[0][2];
        }

        // No winner
        return 0;
    }

    public String getBoardString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) {
                    sb.append("_ ");
                } else if (cell == 1) {
                    sb.append("X ");
                } else {
                    sb.append("O ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : this.board) {
            for (int cell : row) {
                if (cell == 0) {
                    sb.append("_ ");
                } else if (cell == 1) {
                    sb.append("X ");
                } else {
                    sb.append("O ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}