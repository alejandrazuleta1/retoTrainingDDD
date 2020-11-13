package co.com.sofka.retoTrainingDDD.domain.Challenge.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Excercise;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;

import java.util.List;

public class Kata extends Entity<KataId> {
    private final String purpose;
    private final List<Excercise> excerciseList;
    private final String description;
    private Integer limitOfTime;

    public Kata(KataId entityId, String purpose, List<Excercise> excerciseList, String description, Integer limitOfTime) {
        super(entityId);
        this.purpose = purpose;
        this.excerciseList = excerciseList;
        this.description = description;
        this.limitOfTime = limitOfTime;
    }

    public void changeLimitOfTime(Integer limitOfTime){
        this.limitOfTime = limitOfTime;
    }

    public void removeExercise(Excercise excercise){
        excerciseList.removeIf(excercise1 ->
            excercise1.value().goal().equals(excercise.value().goal()) &&
            excercise1.value().level() == excercise.value().level() &&
            excercise1.value().metadata().equals(excercise.value().metadata()));
    }

    public void addNewExcersise(Excercise excercise){
        excerciseList.add(excercise);
    }

    public String Purpose() {
        return purpose;
    }

    public List<Excercise> ExcerciseList() {
        return excerciseList;
    }

    public String Description() {
        return description;
    }

    public Integer LimitOfTime() {
        return limitOfTime;
    }
}
