package org.assignmentTracker.repository.user;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

public interface IUserRepository extends IRepository<User, Integer> {

    Set<User> getAll();

}
