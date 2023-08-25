package com.menes.security.services;

import com.menes.security.models.UserDTO;
import com.menes.security.repositories.UserRepository;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
}
