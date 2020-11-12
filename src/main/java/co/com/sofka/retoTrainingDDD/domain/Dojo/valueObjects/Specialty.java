package co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Specialty implements ValueObject<String> {
    private final String specialty;

    public Specialty(String specialty) {
        this.specialty = Objects.requireNonNull(specialty);
    }

    @Override
    public String value() {
        return specialty;
    }
}
