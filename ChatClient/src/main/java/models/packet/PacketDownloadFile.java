package models.packet;

import models.MessPacket;

public class PacketDownloadFile extends MessPacket {
    String codeFile;

    @Override
    protected void setFlag() {
        flag = "DownloadFile";
    }

    public PacketDownloadFile(String codeFile) {
        setFlag();
        this.codeFile = codeFile;
    }

    public String getCodeFile() {
        return codeFile;
    }

    public void setCodeFile(String codeFile) {
        this.codeFile = codeFile;
    }
}
