package logic;

import models.packet.PacketSendFile;

import java.util.Date;

public class BuildFileName {
    public static String createMessageName(String userA, String userB){
        String user1, user2;
        if(userA.compareTo(userB)>0){
            user1 = userA; user2 = userB;
        } else {
            user1 = userB; user2 = userA;
        }
        return "messages\\" + user1 + "_" + user2 + ".txt";
    }

    public static String createFile(PacketSendFile packetSendFile){
        String user1, user2;
        if(packetSendFile.getUser().compareTo(packetSendFile.getSendUser())>0){
            user1 = packetSendFile.getUser(); user2 = packetSendFile.getSendUser();
        } else {
            user1 = packetSendFile.getSendUser(); user2 = packetSendFile.getUser();
        }

        Date codeFile = new Date();
        return "files\\" + user1 + "_" + user2 + "_" + codeFile.getTime() + "_" + packetSendFile.getNameFile();
    }
}
