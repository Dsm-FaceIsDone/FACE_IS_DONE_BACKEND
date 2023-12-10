package com.example.face_back.domain.user.presentation;


import com.example.face_back.domain.user.presentation.dto.request.LogInRequest;
import com.example.face_back.domain.user.presentation.dto.request.SignUpRequest;
import com.example.face_back.domain.user.presentation.dto.response.TokenResponse;
import com.example.face_back.domain.user.service.LogInService;
import com.example.face_back.domain.user.service.SignUpService;
import com.example.face_back.domain.user.service.UserService;
import com.example.face_back.domain.user.service.util.UserUtil;
import com.example.face_back.global.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final SignUpService signUpService;
    private final LogInService logInService;
    private final UserService userService;
    private final UserUtil userUtil;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    @PostMapping(value = "/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signUp(@RequestBody SignUpRequest request) {
        return signUpService.userSignUp(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse login(@RequestBody LogInRequest request){
        return logInService.userLogIn(request);
    }
}
