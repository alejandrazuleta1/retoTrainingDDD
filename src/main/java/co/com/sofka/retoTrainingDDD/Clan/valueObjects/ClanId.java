package co.com.sofka.retoTrainingDDD.Clan.valueObjects;

import co.com.sofka.domain.generic.Identity;

public class ClanId extends Identity {
    public ClanId(String value){
        super(value);
    }
    public static ClanId of(String value){
        return new ClanId(value);
    }
}
