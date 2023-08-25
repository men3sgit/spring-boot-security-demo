package com.menes.security.services.dto;

import com.menes.security.models.User;
import com.menes.security.models.UserDTO;

import java.util.function.Function;

public interface UserDTOMapper extends Function<User, UserDTO> {
}
