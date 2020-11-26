package models.packetRespone;

import models.MessPacket;

import java.util.List;

public class PacketListOnlineUser extends MessPacket {
    private List<String> users = null;

    public PacketListOnlineUser(List<String> users) {
        setFlag();
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }

    @Override
    protected void setFlag() {
        flag = "ListOnlineUser";
    }
}
