package org.assignmentTracker.factory;
import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.util.Helper;

import java.util.List;

/*
 * @author Anganathi Ngodwane
 * @date 04.07.2020
 * Description: Choice factory
 */
public class ChoiceFactory {
    public Choice choiceFactory(String name, List<Vote> votes){
        int choiceID = Helper.generateID();
        Choice choice = new Choice.Builder()
                .setId(choiceID)
                .setName(name)
                .setVotes(votes)
                .build();
        return choice;
    }
}
