package helpers;

import models.LoginUser;
import models.MessageChat;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BuildChatMessageBox {
    public static final Color COLOR_ONE = Color.DARK_GRAY;
    public static final Color COLOR_TWO = Color.gray;

    public static void getFormMess(List<MessageChat> listMess, JTextPane textPane) {
        // for each message, form: <font color=#xxxxxx> username: message       time-sending-message </font>
        for (MessageChat e : listMess) {
            addMessage(textPane, e);
        }
    }

    public static void appendToPane(JTextPane tp, Color c, boolean isTime, String msg) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        if (isTime) {
            aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_RIGHT);
            aset = sc.addAttribute(aset, StyleConstants.Size, 9);
        } else {
            aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_LEFT);
            aset = sc.addAttribute(aset, StyleConstants.Size, 12);
        }

        if(msg.length() > 6 && msg.substring(0,6).equals("<file>")){
                String[] file = msg.split(":");
                String codeFile = file[0].substring(6);
                String nameFile = file[1];

                StyledDocument doc = tp.getStyledDocument();
                Style regularBlue = doc.addStyle("regularBlue", StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE));
                StyleConstants.setForeground(regularBlue, Color.BLUE);
                StyleConstants.setUnderline(regularBlue, true);
                regularBlue.addAttribute("linkact", new ChatLinkListener(msg));
                try {
                    doc.insertString(doc.getLength(), nameFile, regularBlue);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
        } else {
            StyledDocument doc = tp.getStyledDocument();
            try {
                doc.insertString(doc.getLength(), msg, doc.getStyle(StyleContext.DEFAULT_STYLE));
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addMessage(JTextPane tp, MessageChat e){
        StringBuilder mess = new StringBuilder();
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm dd-MM-yyyy");

        appendToPane(tp, COLOR_ONE, false, e.getUser() + ": ");
        appendToPane(tp, COLOR_ONE, false, e.getMessage() + "\n");
        appendToPane(tp, COLOR_TWO, true, "(" + dt.format(e.getTime()) + ")\n");
    }
}
