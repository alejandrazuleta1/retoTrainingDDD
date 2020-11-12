package co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets;

import co.com.sofka.domain.generic.Identity;

public class KataId extends Identity {
    public KataId(String value){
        super(value);
    }
    public static KataId of(String value){
        return new KataId(value);
    }
}
