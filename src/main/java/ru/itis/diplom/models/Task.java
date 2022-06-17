package ru.itis.diplom.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean main;

    @ManyToOne(targetEntity = Block.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "block_id")
    @JsonManagedReference
    private Block block;

    @OneToMany(targetEntity = Answer.class, mappedBy = "task", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Answer> answers;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "task_hints", joinColumns = @JoinColumn(name = "task_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<String> hints;
    @Enumerated(EnumType.STRING)
    private TaskType type;
    private String img_src;

}
