package com.revature.whoAmI.auth.dto;

import com.revature.whoAmI.auth.dto.requests.LoginRequest;
import com.revature.whoAmI.auth.dto.requests.NewUserRequest;
import com.revature.whoAmI.user.User;
import com.revature.whoAmI.user.UserRepo;
import com.revature.whoAmI.util.annotations.Inject;
import com.revature.whoAmI.util.custom_exception.InvalidRequestException;
import com.revature.whoAmI.util.custom_exception.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Service
@Transactional
public class AuthService {

    @Inject
    private final UserRepo userRepository;

    @Inject
    @Autowired
    public AuthService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public User login(LoginRequest loginRequest){
        if(loginRequest.getUsername() == null || loginRequest.getPassword() == null) throw new InvalidRequestException();//401
        if(!isValidUsername(loginRequest.getUsername()) || !isValidPassword(loginRequest.getPassword())) throw new InvalidRequestException("Invalid username or password");//404
        User user = userRepository.getUserByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if(user == null)throw new InvalidRequestException("Invalid credentials");//404
        //if (!user.getIsActive()) throw new AuthenticationException("Inactive User");//403
        return user;
    }

    public User register(NewUserRequest request){
        User user = request.extractUser();

        //validation checks
        String message = nullChecker(request);
        if(!message.isEmpty()) throw new InvalidRequestException(message);
        if(userExists(user.getUsername())) throw new ResourceConflictException("This username is already taken");
        if(!isValidUsername(user.getUsername())) throw new InvalidRequestException("Invalid username, must be 8-20 characters long and no special characters except _ and .");
        if(!isValidPassword(user.getPassword())) throw new InvalidRequestException("Invalid password, must be longer than 8 characters and contain one number, one special character, and one alphabetical character");

        userRepository.saveUser(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        return user;
    }

    private boolean userExists(String username){
        return userRepository.getUserByUsername(username) != null;
    }

    private String nullChecker(NewUserRequest request){
        //todo change to string builder and make it a public util class
        String eMessage = "";
        try {
            Field[] fields = com.revature.whoAmI.auth.dto.requests.NewUserRequest.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(request) == null) {
                    if(!eMessage.isEmpty()){
                        eMessage += ", ";
                    }
                    eMessage += field.getName() + " is null";
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return eMessage;
    }

    //todo fix up this regex
    public boolean isValidEmail(String email){
        return email.matches("^([\\w][\\-\\_\\.]?)*\\w@([\\w+]\\-?)*\\w\\.\\w+$");
    }

    private boolean isValidUsername(String username){
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    private boolean isValidPassword(String password){
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }

    private boolean isValidBio(String bio){
        return bio.length() < 255;
    }
}
