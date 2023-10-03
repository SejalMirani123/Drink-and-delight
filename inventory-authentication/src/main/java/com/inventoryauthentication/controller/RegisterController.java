package com.inventoryauthentication.controller;

import com.inventoryauthentication.dto.RegisterRequest;
import com.inventoryauthentication.dto.UpdateRequest;
import com.inventoryauthentication.dto.UserDetailsDto;
import com.inventoryauthentication.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/register")
@RestController
@AllArgsConstructor
public class RegisterController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<UserDetailsDto> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> updateUser(@Valid @RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.updateUser(updateRequest));
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsDto>> fetchAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(authService.fetchAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDto> fetchUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.fetchUserById(id));
    }

}
