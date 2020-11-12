package co.com.sofka.retoTrainingDDD.VOShared;

import co.com.sofka.domain.generic.ValueObject;

public class Date implements ValueObject<String> {
    private final String date;

    public Date(String date) {
        this.date = date;
    }

    @Override
    public String value() {
        return date;
    }
}
