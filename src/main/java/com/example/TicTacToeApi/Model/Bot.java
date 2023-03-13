package com.example.TicTacToeApi.Model;

public class Bot {
    private char symbol;

    public Bot(char symbol) {
        this.symbol = symbol;
    }

    public int[] getNextMove(int[][] board) {
        // Implementation of the bot's logic
        return new int[]{0, 0};
    }
}