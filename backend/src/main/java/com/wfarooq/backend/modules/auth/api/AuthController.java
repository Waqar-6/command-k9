package com.wfarooq.backend.modules.auth.api;

import com.wfarooq.backend.common.dto.ResponseDto;
import com.wfarooq.backend.modules.auth.application.IUserService;
import com.wfarooq.backend.modules.auth.dto.RegistrationRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AuthController {

    private final IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser (@Valid @RequestBody RegistrationRequestDto requestDto) {
        String responseMessage = iUserService.register(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", responseMessage));
    }
}
