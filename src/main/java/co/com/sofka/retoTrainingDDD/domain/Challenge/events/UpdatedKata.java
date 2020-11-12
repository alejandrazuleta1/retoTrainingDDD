package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Excercise;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;

import java.util.List;

public class UpdatedKata extends DomainEvent {
    private final KataId kataId;
    private final String purpose;
    private final List<Excercise> excerciseList;
    private final String description;
    private final Integer limitOfTime;

    public UpdatedKata(KataId kataId, String purpose, List<Excercise> excerciseList, String description, Integer limitOfTime) {
        super("Challenge.UpdatedKata");
        this.kataId = kataId;
        this.purpose = purpose;
        this.excerciseList = excerciseList;
        this.description = description;
        this.limitOfTime = limitOfTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public List<Excercise> getExcerciseList() {
        return excerciseList;
    }

    public String getDescription() {
        return description;
    }

    public Integer getLimitOfTime() {
        return limitOfTime;
    }

    public KataId getKataId() {
        return kataId;
    }
}
