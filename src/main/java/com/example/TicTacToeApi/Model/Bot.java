package com.example.TicTacToeApi.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {

    // Method to make a move on the board with the given symbol
    public char[][] makeMove(char[][] board, char symbol) {
        // Find all available positions to play
        List<int[]> availablePositions = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    availablePositions.add(new int[]{i, j});
                }
            }
        }

        // Choose a random available position to play
        int[] randomPosition = availablePositions.get(new Random().nextInt(availablePositions.size()));
        board[randomPosition[0]][randomPosition[1]] = symbol;
        return board;
    }

    // Method to check if the given symbol has won the game on the given board
    public boolean hasWon(char[][] board, char symbol) {
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

    // Method to check if the board is full
    public boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to get the opposite symbol of the given symbol
    public char getOppositeSymbol(char symbol) {
        return (symbol == 'X') ? 'O' : 'X';
    }
}
