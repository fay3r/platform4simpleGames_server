package org.project.domain.classes.user;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@NoArgsConstructor
@Repository
public class ChatMessage implements Serializable {

    private String nick;
    private String text;
    private String data;

    public String getNick() {
        return nick;
    }

    public String getText() {
        return text;
    }

    public String getData() {
        return data;
    }


    @Override
    public String toString() {
        return ""+ nick + "\t" + data + "\n" + text + "\n";
    }

}