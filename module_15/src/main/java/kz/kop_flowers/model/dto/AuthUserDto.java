package kz.kop_flowers.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserDto {

    private String username;
    private String password;
}
