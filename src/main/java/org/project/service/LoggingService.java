package org.project.service;

import org.project.domain.classes.user.*;

import java.util.LinkedList;
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

    List<AccountScoresDto> sendScores();
    void resetPlayerStats (String nick);

    void saveNewMessage(ChatMessage newMessage);
    LinkedList sendMsgToClient();
    void clearChatHistory();
}
