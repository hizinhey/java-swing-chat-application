package views;

import Validate.UserValidate;
import main.SavePreference;
import sockets.SocketUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;

public class Register extends JFrame {
    public Register() {
        initComponent();
    }

    public void initComponent() {
        // init new component
        lblUser = new JLabel();
        lblLogin = new JLabel();
        lblPass = new JLabel();
        lblRepassword = new JLabel();

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        txtRepassword = new JPasswordField();

        btnRegister = new JButton();

        // lblLogin
        lblLogin.setFont(new java.awt.Font("Tahoma", 0, 36));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setText("Đăng ký");

        // lblUser
        lblUser.setText("Tài khoảng");

        // lblPass
        lblPass.setText("Mật khẩu");

        // lblRepassword
        lblRepassword.setText("Nhập lại mật khẩu");

        // txtUsername

        // txtPassword

        // btnRegister
        btnRegister.setText("Đăng ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
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
                                        .addComponent(lblPass)
                                        .addComponent(lblRepassword))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUsername, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 380, javax.swing.GroupLayout.DEFAULT_SIZE)
                                        .addComponent(txtPassword, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 380, javax.swing.GroupLayout.DEFAULT_SIZE)
                                        .addComponent(txtRepassword, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 380, javax.swing.GroupLayout.DEFAULT_SIZE)))
                        .addComponent(btnRegister, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 250, javax.swing.GroupLayout.DEFAULT_SIZE)
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
                                        .addComponent(txtPassword))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblRepassword)
                                        .addComponent(txtRepassword)))
                        .addComponent(btnRegister)
        );

        setTitle("Đăng ký");
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


    // function
    private void btnRegisterActionPerformed(ActionEvent e) {
        // Đăng ký is here
        String user = txtUsername.getText();
        String pass = txtPassword.getText();
        String repass = txtRepassword.getText();

        if (!repass.equals(pass)) {
            JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu không giống mật khẩu.");
        } else if (!UserValidate.validateUsername(user)) {
            JOptionPane.showMessageDialog(this, "Định dạng tài khoảng không hợp lệ.\n Chứa kí tự đặc biệt hoặc độ dài không phù hợp.");
        } else if (!UserValidate.validatePassword(pass)) {
            JOptionPane.showMessageDialog(this, "Định dạng mật khẩu không phù hợp.");
        } else {
            // TODO: Thuc hien dang ki voi user va pass
            SavePreference savePreference = SavePreference.getInstance();

            SocketUtil socketUtil = new SocketUtil(savePreference.getSocket());
            if (socketUtil.createAccount(user, pass)) {
                JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại.");
            }
        }
    }


    // variable
    private JLabel lblLogin;
    private JLabel lblUser;
    private JLabel lblPass;
    private JLabel lblRepassword;

    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtRepassword;

    private JButton btnRegister;

    public void showUI() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            "javax.swing.plaf.metal.MetalLookAndFeel");
                    //  "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    //UIManager.getCrossPlatformLookAndFeelClassRepassword());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                setVisible(true);
            }
        });
    }
}
