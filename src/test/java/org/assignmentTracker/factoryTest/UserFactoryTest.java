package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.UserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
@author Byron Cloete
StudNo: 214189872
Date: 29 June 2020
Desc: Test for User Factory
 */

import java.util.Date;

public class UserFactoryTest {

    @Test
    public void createUser(){
        Date date = new Date();
        User user = UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com");

        Assert.assertTrue(user instanceof User);
    }
}
