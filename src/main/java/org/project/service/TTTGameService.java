package org.project.service;


import org.project.domain.classes.tictactoe.AiMoveDto;
import org.project.domain.classes.tictactoe.Board;
import org.project.domain.classes.tictactoe.UserMoveDto;

public interface TTTGameService {
    Board showResultF ();
    Board restartGameF(String nick);
    Board usersMoveF(UserMoveDto move);
    Board aiMoveF(
            AiMoveDto move);
}

