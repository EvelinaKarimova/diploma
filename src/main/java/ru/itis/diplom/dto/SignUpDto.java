package ru.itis.diplom.dto;

import lombok.*;
import ru.itis.diplom.models.Role;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    private String username;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String password;
    private String passwordRep;
}
