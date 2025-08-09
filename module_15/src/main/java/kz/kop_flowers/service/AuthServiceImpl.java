package kz.kop_flowers.service;

import kz.kop_flowers.model.dto.AuthResponseDto;
import kz.kop_flowers.model.dto.AuthUserDto;
import kz.kop_flowers.model.dto.RegisterUserDto;
import kz.kop_flowers.model.entity.Role;
import kz.kop_flowers.model.entity.User;
import kz.kop_flowers.model.exception.UserNotFoundException;
import kz.kop_flowers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponseDto register(RegisterUserDto registerUserDto) {

        if (usernameExists(registerUserDto.getUsername())) {
            throw new RuntimeException("User with this username already exists");
        }

        User user = User.builder()
                .username(registerUserDto.getUsername())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .role(Role.USER)
                .build();
        user = userRepository.save(user);

        String jwt = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                ));
        return new AuthResponseDto(jwt);
    }

    @Override
    public AuthResponseDto authenticate(AuthUserDto authUserDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authUserDto.getUsername(),
                        authUserDto.getPassword()
                ));
        User user = userRepository.findByUsername(authUserDto.getUsername()).orElseThrow(() -> new UserNotFoundException("No such user"));
        String jwt = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                ));
        return new AuthResponseDto(jwt);
    }

    private boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
