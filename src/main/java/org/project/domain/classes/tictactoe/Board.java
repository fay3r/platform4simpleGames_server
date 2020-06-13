package org.project.domain.classes.tictactoe;

import lombok.ToString;
import org.springframework.stereotype.Repository;

@ToString
@Repository
public class Board {
    public Character[][] plansza;

    public Board(){
        this.plansza=new Character[3][3];
    }
}
