package models;

import java.io.Serializable;
import java.util.List;

public class ListUserRegister implements Serializable {
    List<User> userList;

    public ListUserRegister(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
