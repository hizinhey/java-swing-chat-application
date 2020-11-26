import logic.WorkerThread;
import models.ListUserRegister;
import models.User;
import view.MainFrame;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        File a = new File("user.bin");
        if (!a.exists()) {
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(a));
            ob.writeObject(new ListUserRegister(new ArrayList<User>()));
        }

        File config  =new File("config.txt");
        BufferedReader br = new BufferedReader(new FileReader(config));

        String port = br.readLine();

        MainFrame mainFrame = new MainFrame();
        mainFrame.showUI();

        mainFrame.println("Xin chào các bạn");

        ServerSocket listener = null;

        // Listen
        try {
            listener = new ServerSocket(Integer.parseInt(port));

            mainFrame.println("tạo server ở port "+ Integer.parseInt(port));
            try {
                while (true) {
                    Socket listenSocket = listener.accept();
                    mainFrame.println("Một kết nối được thiết lập.");

                    ObjectOutputStream out = new ObjectOutputStream(listenSocket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(listenSocket.getInputStream());


                    new WorkerThread(listenSocket, in, out).start();

                    if(!mainFrame.isVisible()){
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                listener.close();
            }
        } catch (IOException e) {
            mainFrame.println("Server không thể tạo trên port 9999.");
        }

        //Socket listenSocket;


    }
}
