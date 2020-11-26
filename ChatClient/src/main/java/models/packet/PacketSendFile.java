package models.packet;

import models.MessPacket;

public class PacketSendFile extends MessPacket {
    String user;
    String sendUser;
    String codeFile;
    String nameFile;
    byte[] bytesFile;

    @Override
    protected void setFlag() {
        flag = "SendFile";
    }

    public PacketSendFile(String user, String sendUser, String codeFile, String nameFile, byte[] bytesFile) {
        setFlag();
        this.user = user;
        this.sendUser = sendUser;
        this.codeFile = codeFile;
        this.nameFile = nameFile;
        this.bytesFile = bytesFile;
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

    public String getCodeFile() {
        return codeFile;
    }

    public void setCodeFile(String codeFile) {
        this.codeFile = codeFile;
    }

    public byte[] getBytesFile() {
        return bytesFile;
    }

    public void setBytesFile(byte[] bytesFile) {
        this.bytesFile = bytesFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
