package handler;

import entity.Payment;
import entity.User;
import service.UserService;
import user.UserContextHolder;
import view.AdminView;
import view.LoginView;
import view.MenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {
    private LoginView loginView;
    private UserService userService;

    public LoginHandler(LoginView loginView) {
        this.loginView = loginView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginView.getButton()) {
            userService = new UserService();
            User user = userService.getUser(loginView.getUsernameField().getText());
            if(user == null) {
                System.out.println("등록된 회원이 아닙니다.");
            } else if(!user.getPassword().equals(loginView.getPasswordField().getText())) {
                System.out.println("아이디 또는 비밀번호가 맞지 않습니다");
            } else if(user.getUsername().equals("admin")){
                loginView.dispose();
                UserContextHolder.getInstance().setUsername(loginView.getUsernameField().getText());
                UserContextHolder.getInstance().setPassword(loginView.getPasswordField().getText());
                new AdminView();
            } else {
                loginView.dispose();
                UserContextHolder.getInstance().setUsername(loginView.getUsernameField().getText());
                UserContextHolder.getInstance().setPassword(loginView.getPasswordField().getText());
                new MenuView();
            }

        }

    }
}
