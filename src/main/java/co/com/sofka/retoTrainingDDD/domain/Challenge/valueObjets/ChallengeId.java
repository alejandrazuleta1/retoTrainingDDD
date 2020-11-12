package co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets;

import co.com.sofka.domain.generic.Identity;

public class ChallengeId extends Identity {
    public ChallengeId(String value){
        super(value);
    }
    public static ChallengeId of(String value){
        return new ChallengeId(value);
    }
}
