package com.revature.whoAmI.user;

import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class UserService {
    @Inject
    private final UserRepo userRepository;


    @Inject
    @Autowired
    public UserService(UserRepo userRepository) { this.userRepository = userRepository; }

    public User getUserById(String id) { return userRepository.getUserByID(id); }
    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }
    public User getUserByUsernameAndPassword(String username, String password) { return userRepository.getUserByUsernameAndPassword(username, password); }
    public ArrayList<User> getAllUsers() { return userRepository.getAllUsers(); }
}
