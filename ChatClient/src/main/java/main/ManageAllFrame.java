package main;

import models.packet.PacketLogin;
import models.packet.PacketLogout;
import sockets.SocketHandle;
import views.ChatView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageAllFrame{
    private List<ChatView> list = null;
    private SocketHandle socketHandle = null;
    private static ManageAllFrame instance = null;

    public static ManageAllFrame getInstance(){
        if(instance == null){
            synchronized(ManageAllFrame.class){
                if (instance == null){
                    instance = new ManageAllFrame();
                }
            }
        }
        return instance;
    }

    private ManageAllFrame(){
        list = new ArrayList<ChatView>();

        list = Collections.synchronizedList(list);

        list.add(new ChatView());
        socketHandle = new SocketHandle(
                SavePreference.getInstance().getSocket(),
                SavePreference.getInstance().getOos(),
                SavePreference.getInstance().getOis()
        );
        list.get(0).showUI();
        socketHandle.start();
    }

    public SocketHandle getSocketHandle() {
        return socketHandle;
    }

    public void setSocketHandle(SocketHandle socketHandle) {
        this.socketHandle = socketHandle;
    }

    public synchronized List<ChatView> getList() {
        clearEmpty();
        return list;
    }

    public void setList(List<ChatView> list) {
        this.list = list;
    }

    public void addList(ChatView a){
        list.add(a);
    }

    private void clearEmpty(){
        for(int i = list.size()-1; i >=0; i--){
            if(!list.get(i).isDisplayable()){
                list.remove(i);
            }
        }
    }



    public void closeAll(){
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).isDisplayable()){
                list.remove(i);
                break;
            }
        }
        if (list.size() == 0){
            try {
                SavePreference.getInstance().getOos().writeObject(new PacketLogout());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
