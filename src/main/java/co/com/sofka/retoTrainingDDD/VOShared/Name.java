package co.com.sofka.retoTrainingDDD.VOShared;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {
    private final String name;

    public Name(String name) {
        this.name = Objects.requireNonNull(name); ;
    }

    @Override
    public String value() {
        return name;
    }
}
