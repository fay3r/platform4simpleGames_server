package org.project.service.impl;

import org.project.domain.classes.tictactoe.AiMoveDto;
import org.project.domain.classes.tictactoe.Board;
import org.project.domain.classes.tictactoe.UserMoveDto;
import org.project.service.TTTGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TTTGameServiceImpl implements TTTGameService {

    @Autowired
    private Board board;
    @Override
    public Board showResultF() {
        return board;
    }

    @Override
    public Board restartGameF(String nick) {

        board=new Board();
        return board;
    }


    @Override
    public Board usersMoveF(UserMoveDto move) {
        Character tmp = board.plansza[Integer.parseInt(move.getFieldX())-1][Integer.parseInt(move.getFieldY())-1] ;
        if(tmp!=null){
            return null;}
        board.plansza[Integer.parseInt(move.getFieldX())-1][Integer.parseInt(move.getFieldY())-1] = move.getMark();
        return board;
    }

    @Override
    public Board aiMoveF(AiMoveDto move) {

        Random rand = new Random();
        for(int i=0;i<board.plansza.length;i++){
            for(int j=0;j<board.plansza[i].length;j++){
                if(board.plansza[i][j]==null){
                    while(true){
                        int x = rand.nextInt(3);
                        int y = rand.nextInt(3);
                        Character tmp = board.plansza[x][y];
                        System.out.println(x + " " + y + " " + tmp);
                        if (tmp == null){
                            System.out.println("#END");
                            board.plansza[x][y] = move.getMark();
                            break;}
                    }
                    return board;
                }
            }
        }
        return null;
    }
}

