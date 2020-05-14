package org.project.domain.dto.user;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FPChangeData {
    private String nick;
    private String answer;
    private String newPassword;

    public String getNick() {
        return nick;
    }

    public String getAnswer() {
        return answer;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
