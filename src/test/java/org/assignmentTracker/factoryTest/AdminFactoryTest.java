package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Admin;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.AdminFactory;
import org.junit.Assert;
import java.util.Date;
import static org.assignmentTracker.factory.UserFactory.createUser;

public class AdminFactoryTest {

    @org.junit.Test
    public void createAdmin() {
        User user1 = createUser("Brandon", "Villet", "pass", "villetbrandon@gmail.com");//create user to insert into admin
        Admin admin = AdminFactory.createAdmin(user1, null);//did not create assigment because assignment requires a list of admin
        Assert.assertEquals(admin.getAssignment(),null);
        System.out.println(admin);
    }
}//end of test class