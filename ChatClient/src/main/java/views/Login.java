package views;

import Validate.UserValidate;
import main.ManageAllFrame;
import main.SavePreference;
import sockets.SocketUtil;
import views.customView.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    public Login() {
        initComponent();
    }

    @SuppressWarnings("unchecked")
    public void initComponent() {
        // init new component
        lblUser = new JLabel();
        lblLogin = new JLabel();
        lblPass = new JLabel();

        linkRegister = new JLabel();

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        btnLogin = new JButton();

        // lblLogin
        lblLogin.setFont(new java.awt.Font("Tahoma", 0, 36));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setText("Đăng nhập");

        // lblUser
        lblUser.setText("Tài khoảng");

        // lblPass
        lblPass.setText("Mật khẩu");

        // txtUsername
        txtUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (txtUsername.getText().length() >= 31 ) // limit to 31 characters
                    e.consume();
            }
        });
        // txtPassword
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (txtPassword.getText().length() >= 64 ) // limit to 64 characters
                    e.consume();
            }
        });

        // linkRegister
        linkRegister.setText("<html><u>Bạn chưa có tài khoảng?</u></html>");
        linkRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        linkRegister.setHorizontalAlignment(SwingConstants.CENTER);
        linkRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new Register().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                linkRegister.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                linkRegister.setForeground(Color.black);
            }
        });

        // btnLogin
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        // layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblLogin, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUser)
                                        .addComponent(lblPass))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUsername, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 380, javax.swing.GroupLayout.DEFAULT_SIZE)
                                        .addComponent(txtPassword, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 380, javax.swing.GroupLayout.DEFAULT_SIZE)))
                        .addComponent(btnLogin, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 250, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addComponent(linkRegister,GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUser)
                                        .addComponent(txtUsername))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPass)
                                        .addComponent(txtPassword)))
                        .addComponent(btnLogin)
                        .addComponent(linkRegister)
        );

        setTitle("Đăng nhập");
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }



    // function
    private void btnLoginActionPerformed(ActionEvent e) {
        String user = txtUsername.getText();
        String pass = txtPassword.getText();

        if (!UserValidate.validateUsername(user)) {
            JOptionPane.showMessageDialog(this, "Định dạng tài khoảng không hợp lệ.\n Chứa kí tự đặc biệt hoặc độ dài không phù hợp.");
        } else if (!UserValidate.validatePassword(pass)) {
            JOptionPane.showMessageDialog(this, "Định dạng mật khẩu không phù hợp.");
        } else {
            SavePreference savePreference = SavePreference.getInstance();

            SocketUtil socketUtil = new SocketUtil(savePreference.getSocket());
            if (socketUtil.login(user, pass)) {
                SavePreference.getInstance().setUser(user);
                ManageAllFrame.getInstance();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thất bại.");
            }
        }
    }


    // variable
    private JLabel lblLogin;
    private JLabel lblUser;
    private JLabel lblPass;

    private JLabel linkRegister;

    private JTextField txtUsername;
    private JTextField txtPassword;

    private JButton btnLogin;

    public void showUI() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            "javax.swing.plaf.metal.MetalLookAndFeel");
                    //  "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    //UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                setVisible(true);
            }
        });
    }
}
