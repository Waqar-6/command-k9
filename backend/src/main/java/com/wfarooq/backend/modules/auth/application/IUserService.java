package com.wfarooq.backend.modules.auth.application;

import com.wfarooq.backend.modules.auth.dto.RegistrationRequestDto;

public interface IUserService {

    /**
     *
     * @param requestDto Object
     * @return string
     */
    String register (RegistrationRequestDto requestDto);
}
