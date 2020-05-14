package org.project.domain.dto.user;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


@Repository

public class UserBase {
    private ArrayList<AccountData> platformBase = new ArrayList<>();

    public UserBase() {
        this.platformBase.add(new AccountData("administrator","admin","asd","aff"));
    }

    public ArrayList<AccountData> getPlatformBase() {
        return platformBase;
    }

    public void setPlatformBase(ArrayList<AccountData> platformBase) {
        this.platformBase = platformBase;
    }

    public void add(AccountData accountData){
        System.out.println("dodawanie: "+ accountData.getNick());
        platformBase.add(accountData);
    }

    public AccountData findUser(String nick){
        for(AccountData thisOne :platformBase) {
            if(nick.equals(thisOne.getNick())){
                return thisOne;
            }
        }
        return null;
    }

    public Boolean changePassword(AccountData accountNewData){
        for(int i =0 ; i<platformBase.size();i++){
            if(platformBase.get(i).getNick().equals(accountNewData.getNick())){
                platformBase.set(i,accountNewData);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String temp="" ;
        for(AccountData thisOne:platformBase){
            temp+=thisOne.getQuestion() +" ";
        }
        return temp;
    }
}
