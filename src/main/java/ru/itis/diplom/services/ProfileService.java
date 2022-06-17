package ru.itis.diplom.services;


import org.springframework.security.core.Authentication;
import ru.itis.diplom.models.Block;
import ru.itis.diplom.models.Task;
import ru.itis.diplom.models.User;
import ru.itis.diplom.security.details.UserDetailsImpl;

import java.util.Optional;

public interface ProfileService {
    Optional<User> getCurrentUser(Authentication authentication);
    public User setPassed(User user, Task task);
}
