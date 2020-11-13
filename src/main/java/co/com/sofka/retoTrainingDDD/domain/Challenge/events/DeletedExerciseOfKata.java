package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Excercise;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;

public class DeletedExerciseOfKata extends DomainEvent {
    private final KataId kataId;
    private final Excercise excercise;

    public DeletedExerciseOfKata(KataId kataId, Excercise excercise) {
        super("Challenge.DeletedExerciseOfKata");
        this.kataId = kataId;
        this.excercise = excercise;
    }

    public KataId getKataId() {
        return kataId;
    }
    public Excercise getExcercise() {
        return excercise;
    }

}
