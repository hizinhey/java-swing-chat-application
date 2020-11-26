package model;

import java.util.ArrayList;
import java.util.List;

import models.User;

public class ListUserOnline {
    private static class Handler {
        public static ListUserOnline instance = null;
    }

    private ListUserOnline() {
        list = new ArrayList<OnlineUser>();
    }
    public static ListUserOnline getInstance(){
        if(Handler.instance == null){
            Handler.instance = new ListUserOnline();
        }
        return Handler.instance;
    }

    public ArrayList<OnlineUser> list;

    public boolean checkOnlineUser(User user){
        for(OnlineUser e: list){
            if(user.getUsername() == e.getUser().getUsername()){
                return true;
            }
        }
        return false;
    }

    public List<OnlineUser> getAllOnlineUser(){
        return list;
    }

    public void flush(){
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i).getSocket().isClosed()){
                list.remove(i);
            }
        }
    }
}
