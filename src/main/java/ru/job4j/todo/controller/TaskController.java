package ru.job4j.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.service.TaskService;

@Controller
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/allTasks")
    public String allTasks(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "allTasks";
    }

    @GetMapping("/formAddTask")
    public String addTask(Model model) {
        model.addAttribute("task", new Task(0, "Заполните поле", "Заполните поле"));
        return "addTask";
    }

    @PostMapping("/createTask")
    public String createTask(@ModelAttribute Task task) {
        service.add(task);
        return "redirect:/allTasks";
    }
}
