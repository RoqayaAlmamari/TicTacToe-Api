package com.example.TicTacToeApi.Model;

public class Board {
    private int[][] board;

    public Board(int[] board) {
        this.board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            int row = i / 3;
            int col = i % 3;
            this.board[row][col] = board[i];
        }
    }

    public void set(int row, int col, int value) {
        board[row][col] = value;
    }

    public int get(int row, int col) {
        return board[row][col];
    }

    public int[][] toArray() {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }
}