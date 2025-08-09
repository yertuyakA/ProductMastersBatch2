package kz.kop_flowers.util;

import kz.kop_flowers.model.entity.User;
import kz.kop_flowers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MigratePasswordDB {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void migratePasswords() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (!user.getPassword().startsWith("$2a$")) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
            }
        }
    }
}
