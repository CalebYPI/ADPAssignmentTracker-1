package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChoiceFactoryTest {

    @Test
    public void choiceFactory() {
        Choice choiceName = new Choice.Builder().setName("Anganathi").build();
        Assert.assertEquals("Anganathi", choiceName.getName());
    }
}