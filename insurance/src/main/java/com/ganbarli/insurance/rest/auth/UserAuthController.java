package com.ganbarli.insurance.rest.auth;

import com.ganbarli.insurance.exceptions.UserAlreadyExistException;
import com.ganbarli.insurance.forms.AuthForms.UserLogin;
import com.ganbarli.insurance.forms.AuthForms.UserRegister;
import com.ganbarli.insurance.models.client.Client;
import com.ganbarli.insurance.models.user.User;
import com.ganbarli.insurance.repositories.userRepository.UserRepository;
import com.ganbarli.insurance.security.CustomerDetails;
import com.ganbarli.insurance.security.jwt.JwtTokenProvider;
import com.ganbarli.insurance.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/userAuth")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserAuthController {


    @Autowired
    private UserService userAuthService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/user/registration")
    @ResponseBody
    public ResponseEntity registerUser(@RequestBody UserRegister user) {
        try{
            User newUser = userAuthService.registerNewUserAccount(user);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getPhone(),
                            user.getPassword()
                    )
            );

            return getAuthResponse(authentication);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(200).body(e.getMessage());
        }

    }

    private ResponseEntity getAuthResponse(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Long id = userRepository.findByPhone(userDetails.getUsername()).get().getId();

//        JwtResponse jwtResponse = new JwtResponse(jwt,userDetails.getUsername(),id,userDetails.getAuthorities());


        return ResponseEntity.status(200).body(userDetails);
    }

    @PostMapping("/user/login")
    public ResponseEntity loginUser(@RequestBody UserLogin userLogin){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogin.getPhone(),
                        userLogin.getPassword()
                )
        );



        return getAuthResponse(authentication);
    }


    @RequestMapping(value="/user", method = RequestMethod.GET)
    public CustomerDetails getUser(){
        CustomerDetails cs = (CustomerDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return cs;
    }


}