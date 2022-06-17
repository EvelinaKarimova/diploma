package ru.itis.diplom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diplom.models.Answer;
import ru.itis.diplom.models.Block;
import ru.itis.diplom.models.Task;
import ru.itis.diplom.repositories.BlockRepository;
import ru.itis.diplom.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TasksServiceImpl implements TasksService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    BlockRepository blockRepository;

    public TasksServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    @Override
    public List<Answer> getAllAnswers(Integer id) {
        return taskRepository.findById(id).get().getAnswers();
    }


}
