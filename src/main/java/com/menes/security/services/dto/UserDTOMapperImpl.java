package com.menes.security.services.dto;

import com.menes.security.models.User;
import com.menes.security.models.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapperImpl implements UserDTOMapper{
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
