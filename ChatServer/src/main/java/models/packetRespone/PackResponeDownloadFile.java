package models.packetRespone;

import models.MessPacket;

public class PackResponeDownloadFile extends MessPacket {
    byte[] array;
    boolean isSuccess;
    String nameFile;

    public PackResponeDownloadFile(byte[] array, boolean isSuccess, String nameFile) {
        setFlag();
        this.array = array;
        this.isSuccess = isSuccess;
        this.nameFile = nameFile;
    }
    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    protected void setFlag() {
        flag = "ResponeDownloadFile";
    }

    public byte[] getArray() {
        return array;
    }

    public void setArray(byte[] array) {
        this.array = array;
    }
}
