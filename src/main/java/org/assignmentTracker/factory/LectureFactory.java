package org.assignmentTracker.factory;
/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Factory for Lecture
 * Date: 05 July 2020
 */

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.util.Helper;

public class LectureFactory {

    public  static Lecture newLecture(String name , String surname, String email, String cell_num , String room){

        String id = Integer.toString(Helper.generateID());
        Lecture lecture = new Lecture.Builder()
                .setId(id)
                .setName(surname)
                .setSurname(surname)
                .setEmail(email)
                .setCell_num(cell_num)
                .setRoom(room)
                .build();
        return  lecture;
    }
}
