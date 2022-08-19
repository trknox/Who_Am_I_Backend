package com.revature.whoAmI.user;

import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Inject
    private final UserService userService;

    @Inject
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping(value = "/all-users")
    public @ResponseBody ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @CrossOrigin
    @GetMapping(value = "/user-id/{id}")
    public @ResponseBody User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

}
