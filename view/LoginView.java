package view;

import handler.LoginHandler;
import user.UserContextHolder;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    public LoginView() {
        setTitle("키오스크 로그인");
        setSize(480, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        usernameField = new JTextField("username", 15);
        passwordField = new JPasswordField("password", 15);
        loginButton = new JButton("Login");
        LoginHandler loginHandler = new LoginHandler(this);
        loginButton.addActionListener(loginHandler);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(usernameField);
        c.add(passwordField);
        c.add(loginButton);

        setVisible(true);
    }

    public JButton getButton() {
        return loginButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }
}
