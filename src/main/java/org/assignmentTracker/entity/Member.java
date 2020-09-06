package org.assignmentTracker.entity;

/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Test class for Lecture
 * Date: 05 July 2020
 */


public class Member {

    String id , assignment_id ;

    public Member(Builder builder) {
        this.id = builder.id;
        this.assignment_id = builder.assignment_id;
    }

    public String getId() {
        return id;
    }

    public String getAssignment_id() {
        return assignment_id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", assignment_id='" + assignment_id + '\'' +
                '}';
    }

    public static class Builder{

        String id , assignment_id ;

        public Builder setId(String id){

            this.id = id ;
            return  this;
        }
        public Builder setAssignment_id(String assignment_id){

            this.assignment_id = assignment_id ;
            return  this;
        }

        public Builder copy(Member member){

            this.id = member.id;
            this.assignment_id = member.assignment_id;
            return this;
        }

        public Member builder(){
            return new Member(this);
        }


    }//end of builder

}//end of Member class
