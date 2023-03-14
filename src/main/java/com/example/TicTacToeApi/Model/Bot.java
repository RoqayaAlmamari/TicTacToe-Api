package com.example.TicTacToeApi.Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {
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

        // If there are no available positions, return the board as it is
        if (availablePositions.isEmpty()) {
            return board;
        }

        // Check if the bot can win in the next move
        for (int[] position : availablePositions) {
            board[position[0]][position[1]] = symbol;
            if (checkWin(board, symbol)) {
                return board;
            }
            board[position[0]][position[1]] = '-';
        }

        // Check if the opponent can win in the next move and block them
        char opponentSymbol = (symbol == 'X') ? 'O' : 'X';
        for (int[] position : availablePositions) {
            board[position[0]][position[1]] = opponentSymbol;
            if (checkWin(board, opponentSymbol)) {
                board[position[0]][position[1]] = symbol;
                return board;
            }
            board[position[0]][position[1]] = '-';
        }

        // Choose a random available position to play
        int[] randomPosition = availablePositions.get(new Random().nextInt(availablePositions.size()));
        board[randomPosition[0]][randomPosition[1]] = symbol;
        return board;
    }

    private boolean checkWin(char[][] board, char symbol) {
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
