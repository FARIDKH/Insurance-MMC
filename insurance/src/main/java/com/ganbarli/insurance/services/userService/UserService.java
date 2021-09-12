package com.ganbarli.insurance.services.userService;

import com.ganbarli.insurance.exceptions.UserAlreadyExistException;
import com.ganbarli.insurance.forms.AuthForms.UserRegister;
import com.ganbarli.insurance.models.user.User;
import com.ganbarli.insurance.repositories.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByID(Long id){
        return this.userRepository.findById(id);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerNewUserAccount(UserRegister user)
            throws UserAlreadyExistException {
        if(userRepository.findByPhone(user.getPhone()).isEmpty() == false ){
            System.out.println(userRepository.findByPhone(user.getPhone()).toString());
            throw new UserAlreadyExistException("There is an account with that phone number!");
        }
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPhone(user.getPhone());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setClient_id(user.getClient_id());
        userRepository.save(newUser);
        return newUser;
    }

    public Optional<User> getUserByPhone(String email) { return this.userRepository.findByPhone(email); }


}
