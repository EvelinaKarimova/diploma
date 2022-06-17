package ru.itis.diplom.services;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.diplom.dto.SignInDto;
import ru.itis.diplom.dto.TokenDto;
import ru.itis.diplom.models.User;
import ru.itis.diplom.repositories.UserRepository;
import io.jsonwebtoken.Jwts;

import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String key;

    public SignInServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public TokenDto signIn(SignInDto signInData) {
        Optional<User> userOptional = userRepository.findByUsername(signInData.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getActive()) {
                if (passwordEncoder.matches(signInData.getPassword(), user.getPassword())) {
                    String tokenValue = Jwts.builder()
                            .claim("login", user.getUsername())
                            .claim("id", user.getId())
                            .signWith(SignatureAlgorithm.HS512, key)
                            .compact();

                    return new TokenDto(tokenValue);
                } else throw new IllegalArgumentException("Wrong data");
            } else throw new IllegalArgumentException("User is not active");
        } else throw new IllegalArgumentException("User not found");
    }
}
