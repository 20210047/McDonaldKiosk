package service;


import entity.User;
import repository.UserRepository;
import util.PasswordEncoder;

import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void createUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user.getUsername().equals(username)) {
            System.out.println("중복된 유저가 있습니다.");
        } else {
            passwordEncoder = new PasswordEncoder();
            String _password = passwordEncoder.getPassword(password, passwordEncoder.getSalt());
            User _user = new User(username, _password);
            userRepository.save(_user);
        }
    }

    public User getUser(String username) {
        userRepository = new UserRepository();
        User user = userRepository.findByUsername(username);
        return user;
    }
}
