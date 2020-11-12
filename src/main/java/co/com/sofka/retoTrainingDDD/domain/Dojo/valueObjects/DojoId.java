package co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects;

import co.com.sofka.domain.generic.Identity;

public class DojoId extends Identity {
    public DojoId(String value){
        super(value);
    }

    public static DojoId of(String value){
        return new DojoId(value);
    }
}
