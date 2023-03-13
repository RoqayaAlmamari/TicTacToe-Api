package com.example.TicTacToeApi.Service;

import com.example.TicTacToeApi.Model.Board;
import com.example.TicTacToeApi.Model.Bot;

import java.util.Arrays;

public class TicTacToeService {
    public static int[][] getBoard(String boardString, char symbol) {
        int[] boardArray = Arrays.stream(boardString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        Board board = new Board(boardArray);
        Bot bot = new Bot(symbol);
        int[] nextMove = bot.getNextMove(board.toArray());
        board.set(nextMove[0], nextMove[1], symbol == 'X' ? 1 : 2);
        return board.toArray();
    }
}
