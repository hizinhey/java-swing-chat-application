import main.SavePreference;
import sockets.SocketConfig;
import sockets.SocketUtil;
import views.Login;
import views.Register;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        File config = new File("configClient.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(config));
            String host = br.readLine();
            String port = br.readLine();
            br.close();

            SocketConfig.SERVER = host;
            SocketConfig.PORT = Integer.parseInt(port);

            //Socket socketOfClient = null;
            Login login = new Login();

            SavePreference instance = SavePreference.getInstance();

            Socket socket = instance.getSocket();

            login.showUI();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi nhập file config. Tắt chương trình.");
        }

    }
}
