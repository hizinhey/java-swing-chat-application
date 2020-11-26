package sockets;

import main.ManageAllFrame;
import models.MessPacket;
import models.User;
import models.packet.PacketGetMess;
import models.packetRespone.PackResponeDownloadFile;
import models.packetRespone.PacketAllMess;
import models.packetRespone.PacketListOnlineUser;
import views.ChatView;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class SocketHandle extends Thread {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public SocketHandle(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
        this.socket = socket;
        this.oos = oos;
        this.ois = ois;
    }

    @Override
    public void run() {
        super.run();
        while (socket.isConnected()) {
            try {
                MessPacket packet = (MessPacket) ois.readObject();

                System.out.println("Bắt 1 tâp tin " + packet.getFlag());

                String FLAG = packet.getFlag();
                if (FLAG.equals("ListOnlineUser")) {
                    PacketListOnlineUser packetListOnlineUser = (PacketListOnlineUser) packet;
                    List<String> listUser = packetListOnlineUser.getUsers();

                    List<ChatView> chatViewList = ManageAllFrame.getInstance().getList();

                    for (ChatView e : chatViewList) {
                        e.updateListOnline(listUser);
                    }
                }
                else if (FLAG.equals("AllMess")) {
                    PacketAllMess packetAllMess = (PacketAllMess) packet;
                    for (ChatView e : ManageAllFrame.getInstance().getList()) {
                        e.updateBoxChat(packetAllMess.getSendUser(),packetAllMess.getList());
                    }
                    System.out.println(ManageAllFrame.getInstance().getList().size());
                }
                else if(FLAG.equals("ResponeDownloadFile")){
                    PackResponeDownloadFile packResponeDownloadFile = (PackResponeDownloadFile) packet;
                    if (packResponeDownloadFile.isSuccess()){
                        File file = new File(packResponeDownloadFile.getNameFile());
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(packResponeDownloadFile.getArray());
                        fileOutputStream.close();
                        JOptionPane.showMessageDialog(null, "Tải tài liệu thành công.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tải tài liệu thất bại.");
                    }
                }
                else if(FLAG.equals("Logout")){
                    socket.close();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
