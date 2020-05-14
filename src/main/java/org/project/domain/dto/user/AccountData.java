package org.project.domain.dto.user;

import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public class AccountData implements Serializable {
    private String nick;
    private String password;
    private String question;
    private String answer;

    public AccountData(){
        this.nick=null;
        this.password=null;
        this.question=null;
        this.answer=null;
    }

    public AccountData(String nick, String password, String question, String answer) {
        this.nick = nick;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
