package co.com.sofka.retoTrainingDDD.domain.Challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;

import java.util.List;

public class AgregarKatasAlChallenge implements Command {
    private final ChallengeId challengeId;
    private final List<Kata> katas;

    public AgregarKatasAlChallenge(ChallengeId challengeId, List<Kata> katas) {
        this.challengeId = challengeId;
        this.katas = katas;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public List<Kata> getKatas() {
        return katas;
    }
}
