package com.example.TicTacToeApi.Controller;

import com.example.TicTacToeApi.Service.TicTacToeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TicTacToeController.java
@RestController
public class TicTacToeController {
    @GetMapping("/api")
    public int[][] getBoard(@RequestParam("board") String boardString, @RequestParam("symbol") char symbol) {
        return TicTacToeService.getBoard(boardString, symbol);
    }
}