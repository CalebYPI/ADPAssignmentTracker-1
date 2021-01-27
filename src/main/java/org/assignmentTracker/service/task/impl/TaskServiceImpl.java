package org.assignmentTracker.service.task.impl;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.repository.task.ITaskRepository;
import org.assignmentTracker.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ITaskRepository repository;

    @Override
    public Set<Task> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Task create(Task task) {

        return this.repository.save(task);
    }

    @Override
    public Task read(Integer integer) {

        return this.repository.findById(integer).orElseGet(null);
    }

    @Override
    public Task update(Task task) {
        if (repository.existsById(task.getTaskId()))
            return this.repository.save(task);
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        this.repository.deleteById(integer);
        if (repository.existsById(integer))
            return false;
        else return true;
    }
}
