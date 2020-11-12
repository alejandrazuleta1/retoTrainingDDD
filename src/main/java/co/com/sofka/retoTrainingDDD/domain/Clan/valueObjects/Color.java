package co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects;

import co.com.sofka.domain.generic.ValueObject;

public class Color implements ValueObject<String> {
    private final String color;

    public Color(String color) {
        this.color = color;
    }

    @Override
    public String value() {
        return color;
    }
}
