package main;

import sockets.SocketConfig;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SavePreference {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String user;

    private static SavePreference instance = null;

    public static SavePreference getInstance() {
        if (instance == null) {
            synchronized (SavePreference.class){
                instance = new SavePreference();
            }
        }
        return instance;
    }

    private SavePreference() {
        try {
            socket = new Socket(SocketConfig.SERVER, SocketConfig.PORT);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Không thể kết nối đến server " + SocketConfig.SERVER);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }
}
