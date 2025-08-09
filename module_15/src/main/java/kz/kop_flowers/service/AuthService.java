package kz.kop_flowers.service;

import kz.kop_flowers.model.dto.AuthResponseDto;
import kz.kop_flowers.model.dto.AuthUserDto;
import kz.kop_flowers.model.dto.RegisterUserDto;

public interface AuthService {

    AuthResponseDto register(RegisterUserDto registerUserDto);
    AuthResponseDto authenticate(AuthUserDto authUserDto);
}
