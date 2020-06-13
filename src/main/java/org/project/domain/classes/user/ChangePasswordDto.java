package org.project.domain.classes.user;

public class ChangePasswordDto {
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
