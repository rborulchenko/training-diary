package net.bizarrerus.training_diary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "exercise_name")
    private String exercise_name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "exercises")
    private Set<Complex> complexes;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private MuscleGroup muscleGroup;

    public Exercise() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public Set<Complex> getComplexes() {
        return complexes;
    }

    public void setComplexes(Set<Complex> complexes) {
        this.complexes = complexes;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", exercise_name='" + exercise_name + '\'' +
                ", complexes=" + complexes +
                ", muscleGroup=" + muscleGroup.getGroup_name() +
                '}';
    }
}
