package models.packet;

import models.MessPacket;

public class PacketSendMess extends MessPacket {
    String user;
    String sendUser;
    String detail;

    @Override
    protected void setFlag() {
        flag = "SendMess";
    }

    public PacketSendMess(String user, String sendUser, String detail) {
        setFlag();
        this.user = user;
        this.sendUser = sendUser;
        this.detail = detail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
