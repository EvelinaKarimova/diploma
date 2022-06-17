package ru.itis.diplom.services;

import ru.itis.diplom.dto.SignUpDto;
import ru.itis.diplom.dto.UserDto;

public interface SignUpService {
    UserDto signUp(SignUpDto dto);
}
