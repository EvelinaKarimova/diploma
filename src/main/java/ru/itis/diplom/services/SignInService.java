package ru.itis.diplom.services;

import org.springframework.stereotype.Service;
import ru.itis.diplom.dto.SignInDto;
import ru.itis.diplom.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInData);
}
