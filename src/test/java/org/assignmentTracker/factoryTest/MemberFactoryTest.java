package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Member;
import org.assignmentTracker.factory.MemberFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberFactoryTest {

    @Test
    public void createMember() {


        Member member = MemberFactory.createMember("8");
        // Member members = MemberFactory.createMember("8");

        Assert.assertSame(member ,member);
    }
}