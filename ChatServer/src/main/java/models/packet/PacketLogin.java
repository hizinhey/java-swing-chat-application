package models.packet;

import models.MessPacket;

public class PacketLogin extends MessPacket {
    String username;
    String password;

    public PacketLogin(String username, String password){
        setFlag();
        this.username = username;
        this.password = password;
    }

    @Override
    protected void setFlag() {
        flag = "Login";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
