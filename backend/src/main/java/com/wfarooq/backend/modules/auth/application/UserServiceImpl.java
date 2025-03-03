package com.wfarooq.backend.modules.auth.application;

import com.wfarooq.backend.common.exception.ResourceAlreadyExistsException;
import com.wfarooq.backend.modules.auth.domain.User;
import com.wfarooq.backend.modules.auth.dto.RegistrationRequestDto;
import com.wfarooq.backend.modules.auth.mapper.UserMapper;
import com.wfarooq.backend.modules.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     *
     * @param requestDto Object
     * @return string
     */
    @Override
    public String register(RegistrationRequestDto requestDto) {

        if (userRepository.existsByEmail(requestDto.getEmail()))
            throw new ResourceAlreadyExistsException("User", "email", requestDto.getEmail());

        User newUser = UserMapper.mapRegistrationRequestToUser(requestDto, new User());
        newUser.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        userRepository.save(newUser);
        return "User Registered successfully";
    }
}
