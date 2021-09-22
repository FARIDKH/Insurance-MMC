package com.ganbarli.insurance.services.userService;

import com.ganbarli.insurance.exceptions.UserAlreadyExistException;
import com.ganbarli.insurance.forms.AuthForms.UserRegister;
import com.ganbarli.insurance.models.user.User;
import com.ganbarli.insurance.repositories.userRepository.UserRepository;
import com.ganbarli.insurance.services.emailService.EmailService;
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

    @Autowired
    private EmailService emailService;

    public User registerNewUserAccount(UserRegister user)
            throws UserAlreadyExistException {
        if(userRepository.findByEmail(user.getEmail()).isEmpty() == false ){
            throw new UserAlreadyExistException("There is an account with that phone number!");
        }
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setClient_id(user.getClient_id());
        userRepository.save(newUser);
        return newUser;
    }

    public Optional<User> getUserByEmail(String email) { return this.userRepository.findByEmail(email); }


}
