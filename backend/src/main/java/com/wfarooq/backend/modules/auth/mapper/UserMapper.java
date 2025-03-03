package com.wfarooq.backend.modules.auth.mapper;

import com.wfarooq.backend.modules.auth.domain.User;
import com.wfarooq.backend.modules.auth.dto.RegistrationRequestDto;

public final class UserMapper {

    private UserMapper () {}

    public static User mapRegistrationRequestToUser (RegistrationRequestDto requestDto, User user) {
        user.setEmail(requestDto.getEmail());
        user.setRole(requestDto.getRole());
        return user;
    }
}
