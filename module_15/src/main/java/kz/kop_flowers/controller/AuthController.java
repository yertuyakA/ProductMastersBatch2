package kz.kop_flowers.controller;

import kz.kop_flowers.model.dto.AuthResponseDto;
import kz.kop_flowers.model.dto.AuthUserDto;
import kz.kop_flowers.model.dto.RegisterUserDto;
import kz.kop_flowers.service.AuthService;
import kz.kop_flowers.util.MigratePasswordDB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MigratePasswordDB migratePasswordDB;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterUserDto registerUserDto) {
        return ResponseEntity.ok(authService.register(registerUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthUserDto authUserDto) {
        return ResponseEntity.ok(authService.authenticate(authUserDto));
    }

    @PostMapping("/migrate-passwords")
    public String migrate() {
        migratePasswordDB.migratePasswords();
        return "Done!";
    }
}
