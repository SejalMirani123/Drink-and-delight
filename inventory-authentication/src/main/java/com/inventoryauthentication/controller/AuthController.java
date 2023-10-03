package com.inventoryauthentication.controller;

import com.inventoryauthentication.dto.ForgotPasswordRequest;
import com.inventoryauthentication.dto.LoginRequest;
import com.inventoryauthentication.dto.LoginResponse;
import com.inventoryauthentication.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
    }

    @GetMapping("/forgotpassword/{username}")
    public ResponseEntity<Map<String, String>> forgotPassword(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.fetchSecurityQuestionForUser(username));
    }

    @PutMapping("/forgotpassword")
    public ResponseEntity<Map<String, String>> validateAnswerAndUpdatePassword(
            @Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.validateAnswerAndUpdate(forgotPasswordRequest));
    }

}
