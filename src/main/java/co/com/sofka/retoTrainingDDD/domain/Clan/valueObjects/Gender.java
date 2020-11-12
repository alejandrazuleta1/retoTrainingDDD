package co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Gender implements ValueObject<String> {
    private final String gender;

    public Gender(String gender) {
        this.gender = Objects.requireNonNull(gender); ;
    }
    @Override
    public String value() {
        return gender;
    }
}
