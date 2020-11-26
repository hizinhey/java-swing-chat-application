package models.packet;

import models.MessPacket;

public class PacketGetMess extends MessPacket {
    String user;
    String sendUser;

    @Override
    protected void setFlag() {
        flag = "GetMess";
    }

    public PacketGetMess(String user, String sendUser) {
        setFlag();
        this.user = user;
        this.sendUser = sendUser;
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
}
