package com.menes.security.services;

import com.menes.security.models.UserDTO;
import com.menes.security.repositories.UserRepository;
import com.menes.security.services.dto.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserDTOMapper mapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return repository.findAll()
                .stream().map(mapper).collect(Collectors.toList());
    }
}
