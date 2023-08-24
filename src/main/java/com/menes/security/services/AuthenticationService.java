package com.menes.security.services;

import com.menes.security.requests.AuthenticationRequest;
import com.menes.security.requests.RegisterRequest;
import com.menes.security.responses.AuthenticationResponse;

import java.util.Optional;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
