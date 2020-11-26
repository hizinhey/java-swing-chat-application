package logic;

import model.ListUserOnline;
import model.OnlineUser;
import models.ListUserRegister;
import models.MessPacket;
import models.MessageChat;
import models.User;
import models.packet.*;
import models.packetRespone.PackResponeDownloadFile;
import models.packetRespone.PacketAllMess;
import models.packetRespone.PacketListOnlineUser;
import models.packetRespone.PacketRespone;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class WorkerThread extends Thread {
    private Socket socket;
    private ObjectOutputStream outSocket;
    private ObjectInputStream inSocket;

    public WorkerThread(Socket socketClient, ObjectInputStream inSocket, ObjectOutputStream outSocket) {
        this.socket = socketClient;
        this.inSocket = inSocket;
        this.outSocket = outSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client kết nối");

            while (true) {
                // Đọc dữ liệu tới server (Do client gửi tới).
                MessPacket packet = (MessPacket) inSocket.readObject();
                if(packet != null){
                    System.out.println("Đọc được 1 tập tin " + packet.getFlag());
                } else {
                    System.out.println("Tập tin bị lỗi");
                }

                String flag = packet.getFlag();
                if (flag.equals("Login")) {
                    PacketLogin packetLogin = (PacketLogin) packet;
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));

                    List<User> userList;
                    if ((userList = ((ListUserRegister) ois.readObject()).getUserList()) != null) {
                        boolean kt = false;
                        for (User e : userList) {
                            if (packetLogin.getUsername().equals(e.getUsername())
                                    && packetLogin.getPassword().equals(e.getPassword())) {
                                kt = true;
                                break;
                            }
                        }
                        if (kt) {
                            MessPacket res = new PacketRespone("Success");
                            ListUserOnline.getInstance().list.add(new OnlineUser(new models.User(
                                    packetLogin.getUsername(),
                                    packetLogin.getPassword()
                            ), socket, outSocket, inSocket));
                            outSocket.writeObject(res);
                            for(OnlineUser e:ListUserOnline.getInstance().list){
                                // cap nhat view tat ca
                                HashSet<String> list = new HashSet<String>();

                                for(OnlineUser ex: ListUserOnline.getInstance().list){
                                    list.add(ex.getUser().getUsername());
                                }

                                List<String> a = new ArrayList<String>(list);
                                PacketListOnlineUser packetRes = new PacketListOnlineUser(a);

                                e.getOos().writeObject(packetRes);
                            }
                        } else {
                            MessPacket res = new PacketRespone("False");
                            outSocket.writeObject(res);
                        }
                    }
                    ois.close();
                }
                else if (flag.equals("Register")) {
                    // Thực hiện khi người dùng gửi lệnh đăng ký
                    PacketRegister packetRegister = (PacketRegister) packet;
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));

                    List<User> userList;
                    if ((userList = ((ListUserRegister) ois.readObject()).getUserList()) != null) {
                        boolean kt = true;
                        for (User e : userList) {
                            if (packetRegister.getUsername().equals(e.getUsername())) {
                                kt = false;
                                break;
                            }
                        }
                        if (kt) {
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.bin"));
                            userList.add(new User(packetRegister.getUsername(), packetRegister.getPassword()));
                            oos.writeObject(new ListUserRegister(userList));
                            oos.close();
                            MessPacket res = new PacketRespone("Success");
                            outSocket.writeObject(res);
                            System.out.println("Không tồn tại user nào");
                        } else {
                            MessPacket res = new PacketRespone("False");
                            outSocket.writeObject(res);
                            System.out.println("Tồn tại user trong list");
                        }
                    }
                    ois.close();
                }
                else if (flag.equals("GetListOnlineUser")){
                    HashSet<String> list = new HashSet<String>();

                    for(OnlineUser e: ListUserOnline.getInstance().list){
                        list.add(e.getUser().getUsername());
                    }

                    List<String> a = new ArrayList<String>(list);
                    PacketListOnlineUser packetRes = new PacketListOnlineUser(a);

                    outSocket.writeObject(packetRes);
                }
                else if (flag.equals("GetMess")){
                    PacketGetMess packetGetMess = (PacketGetMess) packet;
                    List<MessageChat> list = null;
                    File fileMess = new File(BuildFileName.createMessageName(packetGetMess.getUser(), packetGetMess.getSendUser()));
                    File folder = new File("messages");
                    if(!folder.exists()){
                        folder.mkdir();
                    }
                    if(!fileMess.exists()){
                        if(fileMess.createNewFile()){
                            System.out.println("true");
                        } else {
                            System.out.println("false");
                        }
                        ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(fileMess));
                        bw.writeObject(new ArrayList<MessageChat>());
                    }
                    ObjectInputStream br = new ObjectInputStream(new FileInputStream(fileMess));
                    list = (List<MessageChat>) br.readObject();
                    br.close();
                    PacketAllMess res = new PacketAllMess(packetGetMess.getUser(), packetGetMess.getSendUser(), list);
                    outSocket.writeObject(res);
                }
                else if(flag.equals("SendMess")){
                    PacketSendMess packetSendMess = (PacketSendMess) packet;
                    List<MessageChat> list = null;
                    File fileMess = new File(BuildFileName.createMessageName(packetSendMess.getUser(), packetSendMess.getSendUser()));
                    File folder = new File("messages");
                    ObjectOutputStream bw = null;
                    if(!folder.exists()){
                        folder.mkdir();
                    }
                    if(!fileMess.exists()){
                        if(fileMess.createNewFile()){
                            System.out.println("true");
                        } else {
                            System.out.println("false");
                        }
                        bw = new ObjectOutputStream(new FileOutputStream(fileMess));
                        bw.writeObject(new ArrayList<MessageChat>());
                    }
                    ObjectInputStream br = new ObjectInputStream(new FileInputStream(fileMess));
                    list = (List<MessageChat>) br.readObject();
                    br.close();

                    list.add(new MessageChat(packetSendMess.getUser(), packetSendMess.getDetail(), new Date()));
                    bw = new ObjectOutputStream(new FileOutputStream(fileMess));
                    bw.writeObject(list);
                    bw.close();

                    ListUserOnline.getInstance().flush();
                    for(OnlineUser e: ListUserOnline.getInstance().list){
                       if(e.getUser().getUsername().equals(packetSendMess.getUser())){
                            PacketAllMess res = new PacketAllMess(packetSendMess.getUser(), packetSendMess.getSendUser(), list);
                            e.getOos().writeObject(res);
                        } else if(e.getUser().getUsername().equals(packetSendMess.getSendUser())) {
                            PacketAllMess res = new PacketAllMess(packetSendMess.getSendUser(), packetSendMess.getUser(), list);
                            e.getOos().writeObject(res);
                        }
                    }
                }
                else if(flag.equals("SendFile")){
                    // TODO: lam nhu tin nhan
                    // Tao code file
                    PacketSendFile packetSendFile = (PacketSendFile) packet;
                    String codeFile = BuildFileName.createFile(packetSendFile);

                    // Luu file
                    File folder = new File("files");
                    if(!folder.exists()){
                        folder.mkdir();
                    }
                    File file = new File(codeFile);
                    BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file));

                    bw.write(packetSendFile.getBytesFile());
                    bw.close();

                    // Luu dinh dang tin nhan hop li <file>codefile:tenfile
                    File fileMess = new File(BuildFileName.createMessageName(packetSendFile.getUser(), packetSendFile.getSendUser()));
                    File folder2 = new File("messages");
                    ObjectOutputStream bw2 = null;
                    if(!folder2.exists()){
                        folder2.mkdir();
                    }
                    if(!fileMess.exists()){
                        if(fileMess.createNewFile()){
                            System.out.println("true");
                        } else {
                            System.out.println("false");
                        }
                        bw2 = new ObjectOutputStream(new FileOutputStream(fileMess));
                        bw2.writeObject(new ArrayList<MessageChat>());
                    }
                    ObjectInputStream br = new ObjectInputStream(new FileInputStream(fileMess));
                    List<MessageChat> list = (List<MessageChat>) br.readObject();
                    br.close();
                    list.add(new MessageChat(packetSendFile.getUser(), "<file>"+file.getName()+":"+packetSendFile.getNameFile(), new Date()));
                    bw2 = new ObjectOutputStream(new FileOutputStream(fileMess));
                    bw2.writeObject(list);
                    bw2.close();

                    ListUserOnline.getInstance().flush();
                    for(OnlineUser e: ListUserOnline.getInstance().list){
                        if(e.getUser().getUsername().equals(packetSendFile.getUser())){
                            PacketAllMess res = new PacketAllMess(packetSendFile.getUser(), packetSendFile.getSendUser(), list);
                            e.getOos().writeObject(res);
                        } else if(e.getUser().getUsername().equals(packetSendFile.getSendUser())) {
                            PacketAllMess res = new PacketAllMess(packetSendFile.getSendUser(), packetSendFile.getUser(), list);
                            e.getOos().writeObject(res);
                        }
                    }
                }
                else if(flag.equals("DownloadFile")){
                    PacketDownloadFile packetDownloadFile = (PacketDownloadFile) packet;
                    File file = new File("files\\"+packetDownloadFile.getCodeFile());
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

                        outSocket.writeObject(new PackResponeDownloadFile(bytesArray, true, packetDownloadFile.getCodeFile()));
                    } catch (IOException e) {
                        e.printStackTrace();

                        outSocket.writeObject(new PackResponeDownloadFile(null, false, null));
                    }

                }
                else if (flag.equals("Logout")){
                    outSocket.writeObject(new PacketLogout());
                    socket.close();
                    ListUserOnline.getInstance().flush();
                    for(OnlineUser e:ListUserOnline.getInstance().list){
                        // cap nhat view tat ca
                        HashSet<String> list = new HashSet<String>();

                        for(OnlineUser ex: ListUserOnline.getInstance().list){
                            list.add(ex.getUser().getUsername());
                        }

                        List<String> a = new ArrayList<String>(list);
                        PacketListOnlineUser packetRes = new PacketListOnlineUser(a);

                        e.getOos().writeObject(packetRes);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
