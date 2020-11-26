package models.packet;

import models.MessPacket;

public class PacketLogout extends MessPacket {
    public PacketLogout() {
        setFlag();
    }

    @Override
    protected void setFlag() {
        flag = "Logout";
    }
}
