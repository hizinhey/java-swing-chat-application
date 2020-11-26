package models.packetRespone;

import models.MessPacket;

public class PacketRespone extends MessPacket {
    String respone;

    public PacketRespone(String respone) {
        setFlag();
        this.respone = respone;
    }

    public String getRespone() {
        return respone;
    }

    public void setRespone(String respone) {
        this.respone = respone;
    }

    @Override
    protected void setFlag() {
        flag = "Respone";
    }
}
