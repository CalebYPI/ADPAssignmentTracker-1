package org.assignmentTracker.entity;

public class Lecture {

    String id , name ,surname ,email, cell_num , room;


    public Lecture(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.cell_num = builder.cell_num;
        this.room = builder.room;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCell_num() {
        return cell_num;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", cell_num='" + cell_num + '\'' +
                ", room='" + room + '\'' +
                '}';
    }

    public static class Builder{

        String id , name ,surname ,email, cell_num , room;

        public Builder setId(String id){
            this.id = id;
            return  this;
        }
        public Builder setName(String name){
            this.name = name;
            return  this;
        }
        public Builder setSurname(String surname){
            this.surname = surname;
            return  this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return  this;
        }
        public Builder setCell_num(String cell_num){
            this.cell_num = cell_num;
            return  this;
        }
        public Builder setRoom(String room){
            this.room = room;
            return  this;
        }

        public Builder copy(Lecture lecture){

            this.id = lecture.id;
            this.name = lecture.name;
            this.surname = lecture.surname;
            this.email = lecture.email;
            this.cell_num = lecture.cell_num;
            this.room = lecture.room;

            return this;
        }

        public Lecture build(){
            return  new Lecture (this);
        }
    }
}
