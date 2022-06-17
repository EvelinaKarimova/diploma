package ru.itis.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.diplom.check.CheckHandler;
import ru.itis.diplom.dto.AnswerDto;
import ru.itis.diplom.models.Block;
import ru.itis.diplom.models.Task;
import ru.itis.diplom.models.User;
import ru.itis.diplom.services.ProfileService;
import ru.itis.diplom.services.TasksService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TasksController {

    @Autowired
    protected TasksService tasksService;

    @Autowired
    protected ProfileService profileService;

    @Autowired
    protected CheckHandler checkHandler;

    protected Task currentTask;


    @GetMapping("/tasks")
    public String getTasksList(Model model, Authentication authentication) {
        model.addAttribute("active_menu_attr", "tasks");
        List<Block> allBlocks = tasksService.getAllBlocks();
        User user = profileService.getCurrentUser(authentication).get();
        model.addAttribute("blocks", allBlocks );
        model.addAttribute("passed_blocks",user.getPassed_blocks());
        model.addAttribute("authentication", authentication);
        model.addAttribute("current_user", user);
        return "tasks";
    }

    @PostMapping("/tasks")
    public String selectTask() {
        return "redirect:/select-task";
    }

    @GetMapping("select-task/{id}")
    public String getSomeTask(Model model, Authentication authentication, @PathVariable("id") Integer id) {
        model.addAttribute("active_menu_attr", "tasks");
        model.addAttribute("authentication", authentication);
        Task task = tasksService.findTaskById(id).get();
        model.addAttribute("task", task);
        currentTask = task;
        return "task";
    }

    @GetMapping("select-task/{id}/passed")
    public String taskPassed(Model model, Authentication authentication, @PathVariable("id") Integer id) {
        model.addAttribute("active_menu_attr", "tasks");
        model.addAttribute("authentication", authentication);
        model.addAttribute("passed","Ура! У тебя получилось!");
        model.addAttribute("task", currentTask);
        return "task";
    }

    @GetMapping("select-task/{id}/try-again")
    public String tryAgain(Model model, Authentication authentication, @PathVariable("id") Integer id) {
        model.addAttribute("active_menu_attr", "tasks");
        model.addAttribute("authentication", authentication);
        model.addAttribute("passed", "Неудача :( Попробуй ещё раз!");
        model.addAttribute("task", currentTask);
        return "task";
    }

    @PostMapping("/answer")
    public String answer(@Valid AnswerDto ans, Model model, Authentication authentication) {
        boolean result = checkHandler.check(currentTask, ans.getAns());
        if (result) {
            profileService.setPassed(profileService.getCurrentUser(authentication).get(), currentTask);
            return "redirect:/select-task/" + currentTask.getId() + "/passed";
        } else return "redirect:/select-task/" + currentTask.getId() + "/try-again";

    }
}
