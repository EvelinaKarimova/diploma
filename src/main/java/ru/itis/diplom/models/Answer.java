package ru.itis.diplom.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String answer;
    @ManyToOne(targetEntity = Task.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    @JsonManagedReference
    private Task task;
}
