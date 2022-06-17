package ru.itis.diplom.services;

import ru.itis.diplom.models.Answer;
import ru.itis.diplom.models.Block;
import ru.itis.diplom.models.Task;

import java.util.List;
import java.util.Optional;

public interface TasksService {
    List<Task> getAllTasks();
    Optional<Task> findTaskById(Integer id);
    List<Block> getAllBlocks();
    public List<Answer> getAllAnswers(Integer id);
}
