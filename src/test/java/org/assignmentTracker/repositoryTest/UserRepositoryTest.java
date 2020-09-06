package org.assignmentTracker.repositoryTest;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.repositoryTest.impl.UserRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {

    private static UserRepository repo = UserRepository.getRepo();
    Date date = new Date();
    private static User user = UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com");

    @Test
    public void a_create(){
        User created = repo.create(user);
        Assert.assertEquals(user.getID(), created.getID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        User read = repo.read(user.getID());
        System.out.println("Created: " + read);
    }

    @Test
    public void c_update(){
        User updated = new User.Builder().copy(user).setPassword("mynewpassword").build();
        updated = repo.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repo.getAll());
    }

    @Test
    public void e_delete(){
        boolean deleted = repo.delete(user.getID());
        Assert.assertTrue(deleted);
    }



}
