package org.project.domain.classes.user;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class ChangePasswordDto implements Serializable {
    private String nick;
    private String password;
    private String newPassword;

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
