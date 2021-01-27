package org.assignmentTracker.factory;


import org.assignmentTracker.entity.*;
import org.assignmentTracker.util.Helper;

import java.util.Date;
import java.util.List;

/**
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: Factory/Assignment provides an abstraction layer for creating Assignment objects
 * Date: 5 July 2020
 */
public class AssignmentFactory {

    public static Assignment createAssignment(String name, Subject subject, Date dateAssigned,
                                       List<Admin> admins, List<Member> members, User creator) {
        int id = Helper.generateAssignmentId();
        Assignment assignment = new Assignment.Builder()
                .setId(id)
                .setName(name)
                .setSubject(subject)
                .setDateAssigned(dateAssigned)
                .setAdmins(admins)
                .setMembers(members)
                .setCreator(creator)
                .build();

        return assignment;
    }

}
