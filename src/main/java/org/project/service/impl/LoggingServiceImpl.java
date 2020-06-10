package org.project.service.impl;

import org.project.domain.dto.user.*;
import org.project.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoggingServiceImpl implements LoggingService {

    @Autowired
    private UserBase baseOfUsers;
    @Autowired
    private AccountData currentUser;

    @Override
    public boolean register(AccountData data) {
        System.out.println(baseOfUsers.toString());
        if(baseOfUsers.findUser(data.getNick())==null)
        {
            baseOfUsers.add(data);
            return true;
        }
        return false;
    }

    @Override
    public boolean logging(LogginData data) {
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
    public void fpChange(LogginData fpChangeData) {
        currentUser = baseOfUsers.findUser(fpChangeData.getNick());
        currentUser.setPassword(fpChangeData.getPassword());
        baseOfUsers.updateData(currentUser,"password");
    }

    @Override
    public boolean userChangingPassword(ChangePasswordDto changePasswordDto) {
        if(changePasswordDto.getNick().equals(baseOfUsers.findUser(changePasswordDto.getNick()).getNick())){
            if(changePasswordDto.getPassword().equals(baseOfUsers.findUser((changePasswordDto.getPassword())).getPassword())){
                baseOfUsers.updateData(new AccountData(changePasswordDto.getNick(),changePasswordDto.getNewPassword(),null,null),"password");
                return true;
            }
        }
        return false;
    }


}
