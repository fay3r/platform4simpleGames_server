package org.project.rest;

import org.project.domain.classes.tictactoe.AiMoveDto;
import org.project.domain.classes.tictactoe.Board;
import org.project.domain.classes.tictactoe.UserMoveDto;
import org.project.service.TTTGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticktacktoe")
public class TTTApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TTTApiController.class);

    @Autowired
     private TTTGameService tttGameService;
    @Autowired
    private Board board;

    @CrossOrigin
    @GetMapping(value = "/result")
    public ResponseEntity<Board> showResult() {
        //  aktualny stan planszy (dane potrzebne klientowi do aktualizacji planszy). http 200
        board=tttGameService.showResultF();

        return new ResponseEntity(board,HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/reset-game") // to bedzie koniec gry
    public ResponseEntity<Board> resetGame() {
        board=tttGameService.restartGameF("mocl");
        return new ResponseEntity(board, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/set-field-by-user")
    public ResponseEntity usersMove(@RequestBody UserMoveDto userMoveDto) {
        board=tttGameService.usersMoveF(userMoveDto);
        return board == null ? new ResponseEntity(board,HttpStatus.BAD_REQUEST) : new ResponseEntity(board,HttpStatus.OK) ;
    }

    @CrossOrigin
    @PostMapping(value = "/set-field-by-ai")
    public ResponseEntity<Board> aiMove(@RequestBody AiMoveDto aiMoveDto) {
        board=tttGameService.aiMoveF(aiMoveDto);
        // JSON ze znakiem
        //200 - gdy pole zostało wypełnione.
        //400 - gdy tablica jest wypełniona w całości.
        //Wprowadza określony znak w pole które wyznaczy algorytm AI.
        return board == null ? new ResponseEntity(board,HttpStatus.BAD_REQUEST) : new ResponseEntity(board,HttpStatus.OK) ;
    }
}