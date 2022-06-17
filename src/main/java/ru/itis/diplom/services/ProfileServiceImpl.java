package ru.itis.diplom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.diplom.models.Block;
import ru.itis.diplom.models.Task;
import ru.itis.diplom.models.User;
import ru.itis.diplom.repositories.UserRepository;
import ru.itis.diplom.security.details.UserDetailsImpl;

import java.util.Optional;
import java.util.Set;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getCurrentUser(Authentication authentication) {
        return Optional.of(((UserDetailsImpl) authentication.getPrincipal()).getUser());
    }

    @Override
    public User setPassed(User user, Task task) {

        Set<Task> tasks = user.getPassed_tasks();
        tasks.add(task);
        user.setPassed_tasks(tasks);
        Set<Task> allTasksOfThisBlock = task.getBlock().getTasks();
        for (Task t: tasks) {
            allTasksOfThisBlock.remove(t);
        }
        if (allTasksOfThisBlock.size() == 0) {
            Set<Block> blocks = user.getPassed_blocks();
            blocks.add(task.getBlock());
            user.setPassed_blocks(blocks);
        }

        return userRepository.save(user);
    }
}
