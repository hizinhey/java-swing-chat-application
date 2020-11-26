package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void showUI(){
        a = new JTextPane();
        JScrollPane b = new JScrollPane(a);
        b.setPreferredSize(new Dimension(720, 568));

        add(b);
        pack();
        setTitle("Server ChatApp v1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JTextPane a;

    private void appendText(String text){
        int len = a.getDocument().getLength();
        a.setCaretPosition(len);
        a.replaceSelection(text);
    }

    public void println(String msg){
        appendText(msg + "\n");
    }
}
