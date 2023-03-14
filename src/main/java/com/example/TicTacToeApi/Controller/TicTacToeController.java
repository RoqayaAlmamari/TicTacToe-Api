package com.example.TicTacToeApi.Controller;

import com.example.TicTacToeApi.Model.Board;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TicTacToeController {
    private Board board;

    @GetMapping("/api")
    public String getBoard(@RequestParam(name = "board") int[] boardArr, @RequestParam(name = "symbol") String symbol) {
        this.board = new Board(boardArr);

        // Make the player's move
        String currentPlayer = this.board.getCurrentPlayer();
        if (!currentPlayer.equals(symbol)) {
            return "Invalid symbol. It's " + currentPlayer + "'s turn.";
        }
        int row = 0;
        int col = 0;
        boolean moveMade = false;
        for (int i = 0; i < 9; i++) {
            row = i / 3;
            col = i % 3;
            if (this.board.getBoard()[row][col] == 0) {
                moveMade = this.board.makeMove(row, col);
                if (moveMade) {
                    break;
                }
            }
        }
        if (!moveMade) {
            return "Invalid move. The board is full or the cell is already occupied.";
        }

        // Print the board
        String boardString = "";
        int[][] boardArrCurrent = this.board.getBoard();
        for (int[] rowArr : boardArrCurrent) {
            boardString += "\n";
            for (int cell : rowArr) {
                if (cell == 0) {
                    boardString += "_ ";
                } else if (cell == 1) {
                    boardString += "X ";
                } else if (cell == 2) {
                    boardString += "O ";
                }
            }
        }

        return "Current player: " + this.board.getCurrentPlayer() + "\nBoard:" + boardString + "\n" + boardArrCurrent;
    }

    @GetMapping("/")
    public ResponseEntity<String> playGame(@RequestParam String board, @RequestParam String symbol) {
        int[] boardArr = Arrays.stream(board.split(",")).mapToInt(Integer::parseInt).toArray();
        Board gameBoard = new Board(boardArr);
        gameBoard.setCurrentPlayer(symbol);

        System.out.println("Current player: " + gameBoard.getCurrentPlayer());
        System.out.println("Board:\n" + gameBoard.getBoardString());

        return ResponseEntity.ok("Current player: " + gameBoard.getCurrentPlayer() + "\nBoard:\n" + gameBoard.toString());
    }
}