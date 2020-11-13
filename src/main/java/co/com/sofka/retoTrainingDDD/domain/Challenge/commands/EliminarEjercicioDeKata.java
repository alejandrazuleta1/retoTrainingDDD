package co.com.sofka.retoTrainingDDD.domain.Challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Excercise;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;

public class EliminarEjercicioDeKata implements Command {
    private final ChallengeId challengeId;
    private final KataId kataId;
    private final Excercise excercise;

    public EliminarEjercicioDeKata(ChallengeId challengeId, KataId kataId, Excercise excercise) {
        this.challengeId = challengeId;
        this.kataId = kataId;
        this.excercise = excercise;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public KataId getKataId() {
        return kataId;
    }

    public Excercise getExcercise() {
        return excercise;
    }
}
