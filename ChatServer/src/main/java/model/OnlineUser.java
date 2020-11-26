package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import models.User;

public class OnlineUser {
    User user;
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public OnlineUser(User user, Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
        this.user = user;
        this.socket = socket;
        this.oos = oos;
        this.ois = ois;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
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
