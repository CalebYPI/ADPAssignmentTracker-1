package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.*;
import org.assignmentTracker.factory.TaskFactory;
import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTest {

    @Test
    public void createTask() {
        Task newTask = TaskFactory.createTask(1,215169751,5);

        Assert.assertTrue(newTask instanceof Task);

    }
}
