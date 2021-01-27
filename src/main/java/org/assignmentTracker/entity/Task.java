package org.assignmentTracker.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 * @author: Caleb Ruiters
 * student number: 215169751
 * */

@Entity
@Embeddable
public class Task {
    @Id
    private int taskId;

    private int assignmentId;
    private long studentId;
    private int memberId;

    protected Task() {
    }

    public Task(Builder builder) {
        this.taskId = builder.taskId;
        this.assignmentId = builder.assignmentId;
        this.studentId = builder.studentId;
        this.memberId = builder.memberId;
    }

    public static class Builder{
        private int taskId;
        private int assignmentId;
        private long studentId;
        private int memberId;

        public Builder setTaskId(int taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder setAssignmentId(int assignmentId) {
            this.assignmentId = assignmentId;
            return this;
        }

        public Builder setMemberId(int memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder setStudentId(long students) {
            this.studentId = students;
            return this;
        }
        public Task build() {
            Task task = new Task();
            task.taskId = this.taskId;
            task.assignmentId = this.assignmentId;
            task.studentId = this.studentId;
            task.memberId = this.memberId;

            return new Task(this);
        }

        public Builder copy(Task task) {
            task.taskId = this.taskId;
            task.assignmentId = this.assignmentId;
            task.studentId = this.studentId;
            task.memberId = this.memberId;

            return this;
        }
    }

    public int getTaskId() {
        return taskId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public long getStudentId() {
        return studentId;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskId=" + taskId +
                ", AssignmentId=" + assignmentId +
                ", students=" + studentId +
                ", MemberId=" + memberId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}
