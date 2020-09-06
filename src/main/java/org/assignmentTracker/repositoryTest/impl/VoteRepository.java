package org.assignmentTracker.repositoryTest.impl;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.repository.vote.IVoteRepository;

import java.util.*;


/**
 * VoteRepository.java
 *
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: repository/vote/impl/VoteRepository data access layer
 * Date: 25 August 2020
 */
public class VoteRepository implements IVoteRepository {

    private static VoteRepository repository = null;
    private Set<Vote> voteDB;

    public VoteRepository() {
        this.voteDB = new HashSet<>();
    }

    public static VoteRepository getRepository() {
        if (repository == null) repository = new VoteRepository();
        return repository;
    }

    @Override
    public Set<Vote> getAll() {
        return this.voteDB;
    }

    @Override
    public Vote create(Vote vote) {
        this.voteDB.add(vote);
        return vote;
    }

    @Override
    public Vote read(Integer id) {

        for (Vote vote : this.voteDB) {
            if (vote.getId() == id)
                return vote;
        }

        return null;
    }

    @Override
    public Vote update(Vote vote) {
        boolean deleteRace = delete(vote.getId());

        if (deleteRace) {
            this.voteDB.add(vote);
            return vote;
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Vote vote = read(id);

        if (vote != null){
            this.voteDB.remove(vote);
            return true;
        }

        return false;
    }

}
