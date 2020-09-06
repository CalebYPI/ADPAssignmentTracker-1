package org.assignmentTracker.repositoryTest.impl;

import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.repository.assignment.IAssignmentRepository;

import java.util.HashSet;
import java.util.Set;


/**
 * AssignmentRepository.java
 *
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: repository/assignment/impl/AssignmentRepository data access layer
 * Date: 25 August 2020
 */
public class AssignmentRepository implements IAssignmentRepository {

    private static AssignmentRepository repository = null;
    private Set<Assignment> assignmentDB;

    public AssignmentRepository() {
        this.assignmentDB = new HashSet<Assignment>();
    }

    public static AssignmentRepository getRepository() {
        if (repository == null) repository = new AssignmentRepository();
        return repository;
    }

    @Override
    public Set<Assignment> getAll() {
        return this.assignmentDB;
    }

    @Override
    public Assignment create(Assignment assignment) {
        this.assignmentDB.add(assignment);
        return assignment;
    }

    @Override
    public Assignment read(Integer id) {
        for (Assignment assignment : this.assignmentDB) {
            if (assignment.getId() == id)
                return assignment;
        }

        return null;
    }

    @Override
    public Assignment update(Assignment assignment) {
        boolean deleteAssignment = delete(assignment.getId());

        if (deleteAssignment) {
            this.assignmentDB.add(assignment);
            return assignment;
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Assignment assignment = read(id);

        if (assignment != null) {
            this.assignmentDB.remove(assignment);
            return true;
        }

        return false;
    }

}
