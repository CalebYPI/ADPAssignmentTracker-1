package org.assignmentTracker.factory;

import org.assignmentTracker.entity.Member;
import org.assignmentTracker.util.Helper;

/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Factory for Member
 * Date: 05 July 2020
 */

public class MemberFactory {

    public static Member createMember (String assignment_id){

        String id = Integer.toString(Helper.generateID()) ;
        Member member = new Member.Builder()
                .setId(id)
                .setAssignment_id(assignment_id)
                .builder();
        return member;

    }

}
