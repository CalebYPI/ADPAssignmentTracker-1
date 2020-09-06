package org.assignmentTracker.repositoryTest;

import junit.framework.TestCase;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.repositoryTest.impl.VoteRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VoteRepositoryTest extends TestCase {

    private static VoteRepository repository = VoteRepository.getRepository();
    private static Vote vote = VoteFactory.createVote(
            UserFactory.createUser("John", "Doe", "joh#pass1", "john@email.com")
    );

    @Test
    public void test_a_create() {
        Vote voteCreated = repository.create(vote);
        Assert.assertEquals(voteCreated.getId(), vote.getId());
        System.out.println("Created: " + voteCreated);
    }

    @Test
    public void test_b_read() {
        Vote voteRead = repository.read(vote.getId());
        System.out.println("Read: " + voteRead);
    }

    @Test
    public void test_c_update() {
        User user = UserFactory.createUser("Karen", "Lee", "joh#pass1", "john@email.com");
        Vote voteUpdate = new Vote.Builder().copy(vote).setVoter(user).build();
        voteUpdate = repository.update(voteUpdate);

        System.out.println("Updated: " + voteUpdate);
    }

    @Test
    public void test_d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }

    @Test
    public void test_e_Delete() {
        boolean isVoteDeleted = repository.delete(vote.getId());
        Assert.assertTrue(isVoteDeleted);
    }
}