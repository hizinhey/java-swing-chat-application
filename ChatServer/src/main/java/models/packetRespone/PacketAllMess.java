package models.packetRespone;

import models.MessPacket;
import models.MessageChat;

import java.util.List;

public class PacketAllMess extends MessPacket {
    String user;
    String sendUser;

    List<MessageChat> list;
    @Override
    protected void setFlag() {
        flag = "AllMess";
    }

    public PacketAllMess(String user, String sendUser, List<MessageChat> list) {
        setFlag();
        this.user = user;
        this.sendUser = sendUser;
        this.list = list;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public List<MessageChat> getList() {
        return list;
    }

    public void setList(List<MessageChat> list) {
        this.list = list;
    }
}
