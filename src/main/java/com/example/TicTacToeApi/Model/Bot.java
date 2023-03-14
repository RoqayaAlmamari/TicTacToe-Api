package com.example.TicTacToeApi.Model;


public class Bot {

    private String symbol;

    public Bot(String symbol) {
        this.symbol = symbol;
    }

    public int[] getMove(Board board) {
        // Implement your bot logic here
        return new int[]{0, 0};
    }
}
