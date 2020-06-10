package org.project.service;

import org.project.domain.dto.user.ChangePasswordDto;

import org.project.domain.dto.user.LogginData;
import org.project.domain.dto.user.AccountData;

import java.util.Map;

public interface LoggingService {
    boolean register(AccountData data);
    boolean logging(LogginData data);
    Map<String,String> isUser(String nick);
    void fpChange(LogginData fpChangeData);
    boolean userChangingPassword(ChangePasswordDto changePasswordDto);
}
