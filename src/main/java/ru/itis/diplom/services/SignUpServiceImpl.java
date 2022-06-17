package ru.itis.diplom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.diplom.dto.SignUpDto;
import ru.itis.diplom.dto.UserDto;
import ru.itis.diplom.models.Role;
import ru.itis.diplom.models.User;
import ru.itis.diplom.repositories.UserRepository;

import java.util.Collections;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto signUp(SignUpDto dto) {
        if (!userExists(dto.getEmail())) {
          if (dto.getPassword().equals(dto.getPasswordRep())) {
                String hashPassword = passwordEncoder.encode(dto.getPassword());
                User user = User.builder()
                        .username(dto.getUsername())
                        .firstName(dto.getFirstName())
                        .lastName(dto.getLastName())
                        .patronymic(dto.getPatronymic())
                        .email(dto.getEmail())
                        .password(hashPassword)
                        .roles(Collections.singleton(Role.USER))
                        .active(true)
                        .build();
                userRepository.save(user);
                return UserDto.from(user);
            } else throw new IllegalArgumentException("Passwords don't match");
       } else throw new IllegalArgumentException("User does not exist");
    }

    private boolean userExists(String login) {
        return userRepository.findByUsername(login).isPresent();
    }
}
