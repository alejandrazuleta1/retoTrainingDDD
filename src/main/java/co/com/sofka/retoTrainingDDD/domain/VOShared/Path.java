package co.com.sofka.retoTrainingDDD.domain.VOShared;

import co.com.sofka.domain.generic.ValueObject;

public class Path implements ValueObject<String> {
    private final String path;

    public Path(String path) {
        this.path = path;
    }

    @Override
    public String value() {
        return path;
    }
}
