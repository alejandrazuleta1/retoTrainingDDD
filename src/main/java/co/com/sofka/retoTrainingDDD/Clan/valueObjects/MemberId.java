package co.com.sofka.retoTrainingDDD.Clan.valueObjects;

import co.com.sofka.domain.generic.Identity;

public class MemberId extends Identity {
    public MemberId(String value){
        super(value);
    }
    public static MemberId of(String value){
        return new MemberId(value);
    }
}
