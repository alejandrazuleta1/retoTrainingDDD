package co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects;

import co.com.sofka.domain.generic.Identity;

public class SenseiId extends Identity {
    public SenseiId(String value){
        super(value);
    }

    public static SenseiId of(String value){
        return new SenseiId(value);
    }
}
