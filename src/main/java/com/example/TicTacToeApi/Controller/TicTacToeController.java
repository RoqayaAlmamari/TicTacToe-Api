package com.example.TicTacToeApi.Controller;

import com.example.TicTacToeApi.Model.Board;
import com.example.TicTacToeApi.Model.Bot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class TicTacToeController {

    @GetMapping
    public ResponseEntity<String[][]> getBoardState(
            @RequestParam(value = "board") String boardParam,
            @RequestParam(value = "symbol") String symbolParam) {

        try {
            // Convert board parameter string to integer array
            int[] board = Arrays.stream(boardParam.split(",")).mapToInt(Integer::parseInt).toArray();
            // Check that the board parameter contains 9 integers separated by commas
            if (board.length != 9) {
                throw new IllegalArgumentException("Board parameter must contain 9 integers separated by commas");
            }

            // Create new Tic Tac Toe board object using the integer array
            Board ticTacToeBoard = new Board(board);
            // Create new Tic Tac Toe bot object
            Bot ticTacToeBot = new Bot();
            // Make a move on the board with the given symbol
            char[][] updatedBoard = ticTacToeBot.makeMove(ticTacToeBoard.getBoard(), symbolParam.charAt(0));
            // Update the board state with the new move
            ticTacToeBoard.setBoard(updatedBoard);
            // Get the current state of the board as a string array
            String[][] boardState = ticTacToeBoard.getBoardState(symbolParam.charAt(0));

            // Return the current board state as a response entity
            return ResponseEntity.ok(boardState);
        } catch (Exception e) {
            // Handle any exceptions by returning a bad request with a null body
            return ResponseEntity.badRequest().body(null);
        }
    }
}
