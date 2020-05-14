package org.project.service.impl;

import org.project.domain.dto.user.*;
import org.project.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoggingServiceImpl implements LoggingService {


    private AccountData administrator = new AccountData();

    @Autowired
    private UserBase baseOfUsers;
    @Autowired
    private AccountData currentUser;

    @Override
    public boolean register(AccountData data) {
        System.out.println(baseOfUsers.toString());
        //baseOfUsers.add(administrator);
        if(baseOfUsers.findUser(data.getNick())==null)
        {
            baseOfUsers.add(data);
            return true;
        }
        return false;
    }

    @Override
    public boolean logging(LogginData data) {
       // baseOfUsers.add(administrator);
        currentUser=baseOfUsers.findUser(data.getNick());
        if(currentUser!=null) {
            if(currentUser.getPassword().equals(data.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String,String> isUser(String nick) {
        HashMap<String, String> temp = new HashMap<>();
        currentUser=baseOfUsers.findUser(nick);
        if(currentUser!=null){
            temp.put("question", currentUser.getQuestion());
            temp.put("answer", currentUser.getAnswer());
            return temp;
        }
        return null;
    }

    @Override
    public boolean fpChange(FPChangeData fpChangeData) {
       String tempAnswer = administrator.getAnswer();
        if(tempAnswer.equals(fpChangeData.getAnswer())){
            administrator.setPassword(fpChangeData.getNewPassword());
            return true;
        }
        return false;
    }

    @Override
    public boolean userChangingPassword(ChangePasswordDto changePasswordDto) {
        if(changePasswordDto.getNick().equals(administrator.getNick())){
            if(changePasswordDto.getPassword().equals(administrator.getPassword())){
                administrator.setPassword(changePasswordDto.getNewPassword());
                return true;
            }
        }
        return false;
    }


}
