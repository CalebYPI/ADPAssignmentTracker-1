package org.assignmentTracker.service.task;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface TaskService extends IService<Task, Integer> {
    Set<Task> getAll();
}
