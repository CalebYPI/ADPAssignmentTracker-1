package org.assignmentTracker.controller.task;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.factory.TaskFactory;
import org.assignmentTracker.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* TaskController.java
 *
 * @author Caleb Ruiters
 * student number: 215169751
 * */

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public Task create(@RequestBody Task task){
        Task newTask = TaskFactory.createTask(
                task.getAssignmentId(),
                task.getStudentId(),
                task.getMemberId()
        );
        return taskService.create(newTask);
    }

    @GetMapping("/read{id}")
    public Task read(@PathVariable int id){ return taskService.read(id); }

    @PutMapping("/update")
    public Task update(@RequestBody Task task){ return taskService.update(task); }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){ taskService.delete(id); }

    @GetMapping("/all")
    public Set<Task> getAll(){ return taskService.getAll(); }

}
