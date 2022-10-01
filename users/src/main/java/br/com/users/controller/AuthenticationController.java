package br.com.users.controller;

import br.com.users.config.TokenService;
import br.com.users.mapper.request.UserRequest;
import br.com.users.mapper.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> authenticate(@RequestBody @Valid UserRequest userRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                userRequest.toUsernamePasswordAuthenticationToken();

        try {
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            String token = tokenService.generateToken(authentication);

            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
