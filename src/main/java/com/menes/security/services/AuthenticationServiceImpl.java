package com.menes.security.services;

import com.menes.security.exceptions.ApiRequestException;
import com.menes.security.models.Role;
import com.menes.security.models.User;
import com.menes.security.repositories.UserRepository;
import com.menes.security.requests.AuthenticationRequest;
import com.menes.security.requests.RegisterRequest;
import com.menes.security.responses.AuthenticationResponse;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        System.out.println("Im first");

        if(userRepository.findUserByEmail(request.getEmail()).isPresent()){
            throw new ApiRequestException("Email taken");
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
            userRepository.save(user);

        String jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(()-> new ApiRequestException("Email not found!"));
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public String logout(String token) {
        return "access token expired!!";
    }

}
