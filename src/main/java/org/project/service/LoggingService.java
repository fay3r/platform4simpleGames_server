package org.project.service;

import org.project.domain.classes.user.ChangePasswordDto;

import org.project.domain.classes.user.LogginData;
import org.project.domain.classes.user.AccountData;

import java.util.List;
import java.util.Map;

public interface LoggingService {
    boolean register(AccountData data);
    boolean logging(LogginData data);
    Map<String,String> isUser(String nick);
    void fpChange(LogginData fpChangeData);
    boolean userChangingPassword(ChangePasswordDto changePasswordDto);
    List<String> getLogins();

    void deletePlayer(String nick);
}
