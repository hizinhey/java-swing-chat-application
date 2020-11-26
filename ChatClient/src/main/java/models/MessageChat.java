package models;

import java.io.Serializable;
import java.util.Date;

public class MessageChat implements Serializable {
    private String user;
    private String message;
    private Date time;

    public MessageChat(){}
    public MessageChat(String user, String message, Date time) {
        this.user = user;
        this.message = message;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
