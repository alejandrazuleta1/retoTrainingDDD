package co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rule implements ValueObject<String> {
    private final String rule;

    public Rule(String rule) {
        this.rule = Objects.requireNonNull(rule);
    }

    @Override
    public String value() {
        return rule;
    }
}
