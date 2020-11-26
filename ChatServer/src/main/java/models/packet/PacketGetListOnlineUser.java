package models.packet;

import models.MessPacket;

public class PacketGetListOnlineUser extends MessPacket {
    @Override
    protected void setFlag() {
        flag = "GetListOnlineUser";
    }

    public PacketGetListOnlineUser() {
        setFlag();
    }
}
