package helpers;

import main.SavePreference;
import sockets.SocketUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChatLinkListener extends AbstractAction
{
    private String textLink;

    public ChatLinkListener(String textLink)
    {
        this.textLink = textLink;
    }

    public void execute()
    {
        JOptionPane.showMessageDialog(null, "Tài liệu đang tải, đợi trong giây lát.");
        System.out.println(textLink);
        new SocketUtil(SavePreference.getInstance().getSocket()).getFile(textLink);
    }

    public void actionPerformed(ActionEvent e)
    {
        execute();
    }
}