package org.assignmentTracker.entity;
import java.util.List;
public class Choice {

    private int id;
    private String name;
    private List <Vote> votes;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List <Vote> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", votes=" + votes +
                '}';
    }
    public static class Builder {

        private int id;
        private String name;
        private List <Vote> votes;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setVotes(List <Vote> votes) {
            this.votes = votes;
            return this;
        }

        public Builder copy(Choice choice) {
            this.id = choice.id;
            this.name = choice.name;
            this.votes = choice.votes;
            return this;
        }

        public Choice build() {
            Choice choice = new Choice();
            choice.id = this.id;
            choice.name = this.name;
            choice.votes = this.votes;

            return choice;
        }
    }
}
