package ru.itis.diplom.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String patronymic;
    private Boolean active;
    private String profileImage;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "app_user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    @CollectionTable(name = "app_user_passed_blocks", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Block> passed_blocks;
    @ManyToMany(fetch = FetchType.EAGER)
    @CollectionTable(name = "app_user_passed_tasks", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Task> passed_tasks;

}
