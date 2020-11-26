package sockets;

import main.SavePreference;
import models.MessageChat;
import models.packet.*;
import models.packetRespone.PacketListOnlineUser;
import models.packetRespone.PacketRespone;

import java.io.*;
import java.net.Socket;

public class SocketUtil {
    // function
    public boolean createAccount(String user, String pass){
        if(socket != null){
            try {
                SavePreference.getInstance().getOos().writeObject(new PacketRegister(user, pass));
                PacketRespone packet = (PacketRespone) SavePreference.getInstance().getOis().readObject();
                if(packet.getRespone().equals("Success")){
                    return true;
                } else {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean login(String user, String pass){
        if(socket != null){
            try {
                SavePreference.getInstance().getOos().writeObject(new PacketLogin(user, pass));
                PacketRespone packet = (PacketRespone) SavePreference.getInstance().getOis().readObject();
                if(packet.getRespone().equals("Success")){
                    return true;
                } else {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public void getMess(String user, String sendUser){
        if(socket != null) {
            try {
                SavePreference.getInstance().getOos().writeObject(new PacketGetMess(user, sendUser));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getList(){
        if(socket != null){
            try {
                SavePreference.getInstance().getOos().writeObject(new PacketGetListOnlineUser());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMess(String user, String sendUser, String detail){
        PacketSendMess packet = new PacketSendMess(user, sendUser, detail);
        try {
            SavePreference.getInstance().getOos().writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String user, String sendUser, File file){
        byte[] bytesArray = new byte[(int) file.length()];

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fis.read(bytesArray); //read file into bytes[]
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PacketSendFile packetSendFile = new PacketSendFile(user, sendUser, null, file.getName(), bytesArray);

        ObjectOutputStream oos = SavePreference.getInstance().getOos();
        try {
            oos.writeObject(packetSendFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFile(String text){
        ObjectOutputStream oos = SavePreference.getInstance().getOos();

        PacketDownloadFile packet = new PacketDownloadFile(text.split(":")[0].substring(6));

        try {
            oos.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendOffline(){

    }

    private Socket socket;

    public SocketUtil(Socket socket){
        this.socket = socket;
        System.out.println(socket);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
